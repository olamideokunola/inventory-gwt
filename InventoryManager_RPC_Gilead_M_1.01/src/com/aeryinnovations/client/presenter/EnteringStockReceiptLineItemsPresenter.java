package com.aeryinnovations.client.presenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import com.aeryinnovations.client.InventoryManagerServiceAsync;
import com.aeryinnovations.client.event.StockReceiptCreatedEvent;
import com.aeryinnovations.client.event.StockReceiptUpdatedEvent;
import com.aeryinnovations.shared.coredomain.InventorySystem;
import com.aeryinnovations.shared.coredomain.SparePartSpecification;
import com.aeryinnovations.shared.coredomain.StockReceipt;
import com.aeryinnovations.shared.coredomain.StockReceiptLineItem;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

public class EnteringStockReceiptLineItemsPresenter implements Presenter  {
	
	public interface Display {
		HasValue<String> getSpSpecIdField();
		HasValue<String> getSpSpecDescField();
		HasValue<String> getSpSpecTypeField();
		HasClickHandlers getFindSpSpec_Button();
		HasData<SparePartSpecification> getSearchResultsCellTable();
		Widget asWidget();
	}
	
	private Display display;
	private StockReceiptLineItem stockReceiptLineItem;
	private InventoryManagerServiceAsync rpcService;
	private HandlerManager eventBus;
	public SparePartSpecification selectedItem;
	private List<SparePartSpecification> searchResultsList;
	
	public EnteringStockReceiptLineItemsPresenter(InventoryManagerServiceAsync rpcService, HandlerManager eventBus, Display display) {
	    this.rpcService = rpcService;
	    this.eventBus = eventBus;
	    this.stockReceiptLineItem = new StockReceiptLineItem();
	    this.display = display;
	    bind();
	}
	
	
	// listen for UI events
	void bind() {
		display.getFindSpSpec_Button().addClickHandler(event -> findSparePartSpecifications());
		
		final SingleSelectionModel<SparePartSpecification> ssm = new SingleSelectionModel<SparePartSpecification>();
		display.getSearchResultsCellTable().setSelectionModel(ssm);
		ssm.addSelectionChangeHandler(
			new SelectionChangeEvent.Handler() {
			    @Override
			    public void onSelectionChange(SelectionChangeEvent event) {
		    		selectedItem = ssm.getSelectedObject();
			    }
			});
	}

	@Override
	public void go(HasWidgets container) {
	    container.clear();
	    container.add(display.asWidget());
	}

	private void findSparePartSpecifications() {
		// TODO Auto-generated method stub
		
		String spSpecId = display.getSpSpecIdField().getValue();
		String spSpecDesc = display.getSpSpecDescField().getValue();
		String spSpecType = display.getSpSpecTypeField().getValue();
		
		//rootLogger.log(Level.INFO, "Search Area, number of items: " + inventorySystem.getSparePartRegister().getSparePartSpecifications().size());

		List<SparePartSpecification> specSearchList = InventorySystem.findSparePartSpecs(spSpecId, spSpecDesc, spSpecType);
		
		ListDataProvider<SparePartSpecification> searchResults_dataProvider = new ListDataProvider<SparePartSpecification>();
		searchResults_dataProvider.addDataDisplay(display.getSearchResultsCellTable());
			
		List<SparePartSpecification> resultList = searchResults_dataProvider.getList();
		List<SparePartSpecification> searchResultsList = new ArrayList<>();
		resultList.clear();
		resultList.addAll(specSearchList);
		//searchResultsList = resultList;
		
		if (searchResultsList.size() > 0) {
			eventBus.fireEvent(new SpareSpecsSearchDoneEvent(resultList));
		}
	}

}

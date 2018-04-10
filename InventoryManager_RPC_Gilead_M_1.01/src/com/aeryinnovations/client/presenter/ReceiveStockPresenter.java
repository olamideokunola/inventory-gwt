package com.aeryinnovations.client.presenter;

import java.util.logging.Level;

import com.aeryinnovations.client.InventoryManagerServiceAsync;
import com.aeryinnovations.client.event.StockReceiptUpdatedEvent;
import com.aeryinnovations.shared.coredomain.InventorySystem;
import com.aeryinnovations.shared.coredomain.StockReceipt;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class ReceiveStockPresenter implements Presenter  {
	
	public interface Display {
		HasClickHandlers getCompleteStockReceipt_Button();
		HasValue<String> getReceiptDateField();
		HasValue<String> getCommentsField();
		Widget asWidget();
	}
	
	private Display display;
	private StockReceipt stockReceipt;
	private InventoryManagerServiceAsync rpcService;
	private HandlerManager eventBus;
	//private InventorySystem inventorySystem;
	
	//public ReceiveStockPresenter(InventoryManagerServiceAsync rpcService, HandlerManager eventBus, Display view) {

	public ReceiveStockPresenter(InventoryManagerServiceAsync rpcService, HandlerManager eventBus, Display display) {
	    this.rpcService = rpcService;
	    this.eventBus = eventBus;
	    this.stockReceipt = new StockReceipt();
	    this.display = display;
	    bind();
	}
	
	
	// listen for UI events
	void bind() {
		display.getCompleteStockReceipt_Button().addClickHandler(event -> saveStockReceipt());
	}

	@Override
	public void go(final HasWidgets container) {
	    container.clear();
	    container.add(display.asWidget());
	}
	
	private void saveStockReceipt() {
		stockReceipt.setReceiptDate(DateTimeFormat.getFormat("dd/mm/yyyy").parse(display.getReceiptDateField().getValue()));
		stockReceipt.setComments(display.getCommentsField().getValue());
		
		rpcService.saveStockReceipt(stockReceipt, 
			new AsyncCallback<Long>() {

				@Override
				public void onFailure(Throwable caught) {
					InventorySystem.getRootLogger().log(Level.SEVERE, "saveStockReceipt Failure: " 
				            + caught.fillInStackTrace());
				}

				@Override
				public void onSuccess(Long result) {
					//newStockReceiptId = result;
					//InventorySystem.getCurrentStockReceipt();
					eventBus.fireEvent(new StockReceiptUpdatedEvent(result));
					InventorySystem.getRootLogger().log(Level.INFO, "saveStockReceipt Successful, new stockReceiptId is: " 
				            + result.toString());
				}
		
			}
			
			);
	}

	
}

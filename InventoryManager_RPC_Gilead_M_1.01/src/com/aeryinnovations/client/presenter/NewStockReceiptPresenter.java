package com.aeryinnovations.client.presenter;

import java.util.logging.Level;

import com.aeryinnovations.client.InventoryManagerServiceAsync;
import com.aeryinnovations.client.event.StockReceiptCreatedEvent;
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

public class NewStockReceiptPresenter implements Presenter  {
	
	public interface Display {
		HasClickHandlers getCreateStockReceipt_Button();
		HasValue<String> getReceiptDateField();
		HasValue<String> getCommentsField();
		Widget asWidget();
	}
	
	private Display display;
	private StockReceipt stockReceipt;
	private InventoryManagerServiceAsync rpcService;
	private HandlerManager eventBus;
	
	public NewStockReceiptPresenter(InventoryManagerServiceAsync rpcService, HandlerManager eventBus, Display display) {
	    this.rpcService = rpcService;
	    this.eventBus = eventBus;
	    this.stockReceipt = new StockReceipt();
	    this.display = display;
	    bind();
	}
	
	
	// listen for UI events
	void bind() {
		display.getCreateStockReceipt_Button().addClickHandler(event -> createStockReceipt());
	}

	@Override
	public void go(final HasWidgets container) {
	    container.clear();
	    container.add(display.asWidget());
	}

	protected void createStockReceipt() {
		// TODO Auto-generated method stub
		stockReceipt.setComments(display.getCommentsField().getValue());
		stockReceipt.setReceiptDate(DateTimeFormat.getFormat("dd/mm/yyyy").parse(display.getReceiptDateField().getValue()));
		//InventorySystem.setStockReceipt(stockReceipt);
		eventBus.fireEvent(new StockReceiptCreatedEvent(stockReceipt));
	}
}

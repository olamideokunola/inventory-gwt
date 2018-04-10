package com.aeryinnovations.client;

import com.aeryinnovations.client.event.AddStockReceiptEvent;
import com.aeryinnovations.client.event.AddStockReceiptEventHandler;
import com.aeryinnovations.client.event.StockReceiptCreatedEvent;
import com.aeryinnovations.client.event.StockReceiptCreatedEventHandler;
import com.aeryinnovations.client.event.StockReceiptUpdatedEvent;
import com.aeryinnovations.client.event.StockReceiptUpdatedEventHandler;
import com.aeryinnovations.client.gui.*;
import com.aeryinnovations.client.presenter.Presenter;
import com.aeryinnovations.client.presenter.*;
import com.aeryinnovations.shared.coredomain.StockReceipt;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements Presenter, ValueChangeHandler<String> {
	private final HandlerManager eventBus;
	private final InventoryManagerServiceAsync rpcService; 
	private HasWidgets container;
	
	/* Constructors */
	public AppController(InventoryManagerServiceAsync rpcService, HandlerManager eventBus) {
	    this.eventBus = eventBus;
	    this.rpcService = rpcService;
	    bind();
	  }
	
	private void bind() {
		// TODO Auto-generated method stub
		/* register to receive History events */
		History.addValueChangeHandler(this);
		
		/* register for events with EventBus */
		eventBus.addHandler(AddStockReceiptEvent.TYPE, 
			new AddStockReceiptEventHandler() {
				@Override
				public void onAddStockReceipt(AddStockReceiptEvent event) {
					// TODO Auto-generated method stub
					doAddStockReceipt();
				}
			});
			
		eventBus.addHandler(StockReceiptUpdatedEvent.TYPE, 
			new StockReceiptUpdatedEventHandler() {
				@Override
				public void onStockReceiptUpdated(StockReceiptUpdatedEvent event) {
					// TODO Auto-generated method stub
					doEditStockReceipt(event.getUpdatedStockReceiptId());
				}
			});
		
		eventBus.addHandler(StockReceiptCreatedEvent.TYPE, 
			new StockReceiptCreatedEventHandler() {
				@Override
				public void onStockReceiptCreated(StockReceiptCreatedEvent event) {
					// TODO Auto-generated method stub
					doAddStockReceiptLineItems(event.getCreatedStockReceipt());
				}
			});
					
	}

	protected void doAddStockReceiptLineItems(StockReceipt createdStockReceipt) {
		// TODO Auto-generated method stub
		History.newItem("addStockReceiptLineItems");
	}

	protected void doEditStockReceipt(Long id) {
		// TODO Auto-generated method stub
		History.newItem("addStockReceipt");
	}

	protected void doAddStockReceipt() {
		// TODO Auto-generated method stub
		History.newItem("addStockReceipt");
	}

	@Override
	public void go(final HasWidgets container) {
		// TODO Auto-generated method stub
		this.container = container;
	    
	    if ("".equals(History.getToken())) {
	      History.newItem("addStockReceipt");
	      //Presenter presenter = new ReceiveStockPresenter(rpcService, eventBus, new ReceiveStock());
	      //presenter.go(container);
	    }
	    else {
	      History.fireCurrentHistoryState();
	    }
	}
	
	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		// TODO Auto-generated method stub
		String token = event.getValue();
	    
	    if (token != null) {
	      Presenter presenter = null;

	      if (token.equals("addStockReceipt")) {
	        presenter = new NewStockReceiptPresenter(rpcService, eventBus, new NewStockReceiptForm());
	      }
	      else if (token.equals("addStockReceiptLineItems")) {
	        presenter = new NewStockReceiptPresenter(rpcService, eventBus, new NewStockReceiptForm());
	      }
	      
	      if (presenter != null) {
	        presenter.go(container);
	      }
	    }
	}

}



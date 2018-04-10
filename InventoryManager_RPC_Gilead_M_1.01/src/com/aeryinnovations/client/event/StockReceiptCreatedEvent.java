package com.aeryinnovations.client.event;

import com.aeryinnovations.shared.coredomain.StockReceipt;
import com.google.gwt.event.shared.GwtEvent;

public class StockReceiptCreatedEvent extends GwtEvent<StockReceiptCreatedEventHandler> {
	public static Type<StockReceiptCreatedEventHandler> TYPE = new Type<StockReceiptCreatedEventHandler>();
	private final StockReceipt createdStockReceipt;
	
	public StockReceiptCreatedEvent(StockReceipt createdStockReceipt) {
		this.createdStockReceipt = createdStockReceipt;
	}
	
	public StockReceipt getCreatedStockReceipt() { 
		return createdStockReceipt; 
	}
	
	@Override
	public Type<StockReceiptCreatedEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(StockReceiptCreatedEventHandler handler) {
		// TODO Auto-generated method stub
		handler.onStockReceiptCreated(this);
	}

}

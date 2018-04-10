package com.aeryinnovations.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class StockReceiptUpdatedEvent extends GwtEvent<StockReceiptUpdatedEventHandler> {
	public static Type<StockReceiptUpdatedEventHandler> TYPE = new Type<StockReceiptUpdatedEventHandler>();
	private final Long updatedStockReceiptId;
	
	public StockReceiptUpdatedEvent(Long updatedStockReceiptId) {
		this.updatedStockReceiptId = updatedStockReceiptId;
	}
	
	public Long getUpdatedStockReceiptId() { 
		return updatedStockReceiptId; 
	}
	
	@Override
	public Type<StockReceiptUpdatedEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(StockReceiptUpdatedEventHandler handler) {
		// TODO Auto-generated method stub
		handler.onStockReceiptUpdated(this);
	}

}

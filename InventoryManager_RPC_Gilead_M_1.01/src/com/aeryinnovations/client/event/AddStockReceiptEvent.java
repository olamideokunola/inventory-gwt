package com.aeryinnovations.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class AddStockReceiptEvent extends GwtEvent<AddStockReceiptEventHandler>{
	public static Type<AddStockReceiptEventHandler> TYPE = new Type<AddStockReceiptEventHandler>();
	
	@Override
	public Type<AddStockReceiptEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return  TYPE;
	}

	@Override
	protected void dispatch(AddStockReceiptEventHandler handler) {
		// TODO Auto-generated method stub
		handler.onAddStockReceipt(this);
	}

}

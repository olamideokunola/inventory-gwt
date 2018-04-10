package com.aeryinnovations.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface StockReceiptCreatedEventHandler extends EventHandler{
	void onStockReceiptCreated(StockReceiptCreatedEvent event);
}

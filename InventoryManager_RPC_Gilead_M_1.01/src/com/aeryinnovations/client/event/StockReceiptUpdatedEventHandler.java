package com.aeryinnovations.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface StockReceiptUpdatedEventHandler extends EventHandler{
	void onStockReceiptUpdated(StockReceiptUpdatedEvent event);
}

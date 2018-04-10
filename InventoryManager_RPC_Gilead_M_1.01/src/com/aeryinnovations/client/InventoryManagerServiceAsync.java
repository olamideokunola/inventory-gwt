package com.aeryinnovations.client;

import java.util.List;

import com.aeryinnovations.shared.coredomain.*;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface InventoryManagerServiceAsync {
	
	void loadSpecifications(AsyncCallback<List<SparePartSpecification>> callback);
	
	public void saveStockReceiptLineItem(StockReceiptLineItem srli, AsyncCallback<Long> callback);
	
	public void saveStockReceipt(StockReceipt sr, AsyncCallback<Long> callback);
	
}

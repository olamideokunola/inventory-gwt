package com.aeryinnovations.client;

import java.util.List;

import com.aeryinnovations.shared.coredomain.*;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("inventorymanager")
public interface InventoryManagerService extends RemoteService {
	
	public List<SparePartSpecification> loadSpecifications();
	
	public Long saveStockReceiptLineItem(StockReceiptLineItem srli);
	
	public Long saveStockReceipt(StockReceipt sr);

}
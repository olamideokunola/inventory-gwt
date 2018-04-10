package com.aeryinnovations.client;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.aeryinnovations.client.gui.*;
import com.aeryinnovations.shared.coredomain.*;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.logging.client.HasWidgetsLogHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;



/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */

public class InventoryManager implements EntryPoint {
	/* Create Root Logger */
	   	private static Logger rootLogger = Logger.getLogger("");
	   	private VerticalPanel customLogArea;
	   
		final Label error_Label = new Label();
		
		public InventorySystem invSys;
	 
		List<SparePartSpecification> specs = new ArrayList<>();
	
		//RPC  Service
		private InventoryManagerServiceAsync inventoryManagerService;
	  /**
	    * A composite of a TextBox and a CheckBox that optionally enables it.
	    */

	   public void onModuleLoad() {
		  inventoryManagerService = GWT.create(InventoryManagerService.class);
	      invSys = new InventorySystem();
	      //final NewStockReceiptForm newStockReceiptForm = new NewStockReceiptForm(invSys);
	      final FindSparePartSpecification findSparePart = new FindSparePartSpecification(invSys);
	      //final EnteringStockReceiptLineItem enteringStockReceiptLineItem = new EnteringStockReceiptLineItem(invSys);
	      //final EnteringStockReceiptLineItems enteringStockReceiptLineItems = new EnteringStockReceiptLineItems(invSys);
	      
	      //final DisplayingStockReceipt displayingStockReceipt = new DisplayingStockReceipt(invSys);
	      
	      /** Load SparePartSpecifications into the SparePartRegister */
	      
	      loadSpecificationsToRegister();
	      InventorySystem.getSparePartRegister().loadSparePartSpecs(specs);
	      	
	      final ReceiveStock receiveStock = new ReceiveStock(invSys);
	      
	      //RootPanel.get().add(otb);
	      //RootPanel.get().add(findSparePart);
	      RootPanel.get().add(receiveStock);
	      RootPanel.get().add(error_Label);	      
	      
	      VerticalPanel vPanel = new VerticalPanel();
	      
	      customLogArea = new VerticalPanel();	   
	      vPanel.add(customLogArea);

	      /* an example of using own custom logging area. */
	      rootLogger.addHandler(new HasWidgetsLogHandler(customLogArea));

	      /* add controls to RootPanel */
	      RootPanel.get().add(vPanel);
	      
	      rootLogger.log(Level.INFO, "testing");
	      GWT.log("testing---");
	      
	      	   }
	   
	private void loadSpecificationsToRegister() {
		// TODO Auto-generated method stub
		
		inventoryManagerService.loadSpecifications(new AsyncCallback<List<SparePartSpecification>>() {
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				error_Label.setText("Error message: " + caught.getMessage());
				rootLogger.log(Level.SEVERE, "loadSpecifications Failure: " 
			            + caught.fillInStackTrace());
			}

			@Override
			public void onSuccess(List<SparePartSpecification> result) {
				// TODO Auto-generated method stub
				specs.addAll(result);
				rootLogger.log(Level.INFO, "loadSpecifications Success, number loaded: " 
			            + result.size());
				rootLogger.log(Level.INFO, "loadSpecifications Success, number loaded into invSys.sparePartRegister: " 
			            + InventorySystem.getSparePartRegister().getSparePartSpecifications().size());

			}
			
		});
	}   
} 
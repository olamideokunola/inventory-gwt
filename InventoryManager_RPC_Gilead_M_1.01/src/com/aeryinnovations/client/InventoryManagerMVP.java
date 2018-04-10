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
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.logging.client.HasWidgetsLogHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;



/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */

public class InventoryManagerMVP implements EntryPoint {
		/* Create Root Logger */
	   	private static Logger rootLogger = Logger.getLogger("");
	   	private VerticalPanel customLogArea;
	   
	   	private VerticalPanel mainPanel;
		final Label error_Label = new Label();
		
		public InventorySystem invSys;
	 
		List<SparePartSpecification> specs = new ArrayList<>();
	
		/* RPC  Service */
		private InventoryManagerServiceAsync rpcService;


	   public void onModuleLoad() {
		  rpcService = GWT.create(InventoryManagerService.class);
	      invSys = new InventorySystem();
	      HandlerManager eventBus = new HandlerManager(null);
	      /* Load SparePartSpecifications into the SparePartRegister */
	      loadSpecificationsToRegister();
	      InventorySystem.getSparePartRegister().loadSparePartSpecs(specs);
	      AppController appViewer = new AppController(rpcService, eventBus);
	      
	      //RootPanel.get().add(mainPanel);
	      appViewer.go(RootPanel.get());  
	      
	      setupCutomLoggerComponent();
	            
	    }
	   
	private void loadSpecificationsToRegister() {
		
		rpcService.loadSpecifications(new AsyncCallback<List<SparePartSpecification>>() {
			
			@Override
			public void onFailure(Throwable caught) {
				error_Label.setText("Error message: " + caught.getMessage());
				rootLogger.log(Level.SEVERE, "loadSpecifications Failure: " 
			            + caught.fillInStackTrace());
			}

			@Override
			public void onSuccess(List<SparePartSpecification> result) {
				specs.addAll(result);
				rootLogger.log(Level.INFO, "loadSpecifications Success, number loaded: " 
			            + result.size());
				rootLogger.log(Level.INFO, "loadSpecifications Success, number loaded into invSys.sparePartRegister: " 
			            + InventorySystem.getSparePartRegister().getSparePartSpecifications().size());
			}
			
		});
	}   
	
	private void setupCutomLoggerComponent() {
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
} 
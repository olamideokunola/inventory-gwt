package com.aeryinnovations.client.gui;

import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Level;

import com.aeryinnovations.client.InventoryManagerService;
import com.aeryinnovations.client.InventoryManagerServiceAsync;
import com.aeryinnovations.client.presenter.ReceiveStockPresenter;
import com.aeryinnovations.shared.coredomain.InventorySystem;
import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ReceiveStock extends Composite implements ReceiveStockPresenter.Display {
	/** @RPC Services */
	
	/** @DomainComponents */

	
	/** @GUIcomponents */
	public VerticalPanel m_Panel = new VerticalPanel();
	
	//public Button createStockReceipt_Button = new Button();
	public Button completeStockReceipt_Button = new Button();
	
	/** @GUI */
	private NewStockReceiptForm NewStockReceiptForm_GUI; 
	private EnteringStockReceiptLineItems EnteringStockReceiptLineItems_GUI;
	private DisplayingStockReceipt DisplayingStockReceipt_GUI;
	
	public ReceiveStock(){
		try{
			initWidget(m_Panel);
			//inventorySystem = invSys;			
			jbInit();
			
		}
		catch(JavaScriptException e) {
			
		}
	}
	
	private void jbInit() throws JavaScriptException{
		
		
		/** @GUI */
		
	
		/** @Button */
		completeStockReceipt_Button.setText("Complete");
		
		
		/** @Label */
		
		
		/** @Panel */
		NewStockReceiptForm_GUI = new NewStockReceiptForm();
		
		m_Panel.add(NewStockReceiptForm_GUI);
			
	}


	@Override
	public HasClickHandlers getCompleteStockReceipt_Button() {
		// TODO Auto-generated method stub
		return completeStockReceipt_Button;
	}

	@Override
	public HasValue<String> getReceiptDateField() {
		// TODO Auto-generated method stub
		return NewStockReceiptForm_GUI.receiptDate_TextBox;
	}

	@Override
	public HasValue<String> getCommentsField() {
		// TODO Auto-generated method stub
		return NewStockReceiptForm_GUI.comments_TextBox;
	}
	
	public Widget asWidget() {
	    return this;
	}
}

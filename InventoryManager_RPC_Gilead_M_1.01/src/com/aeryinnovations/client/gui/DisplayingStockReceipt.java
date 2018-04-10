package com.aeryinnovations.client.gui;

import com.aeryinnovations.shared.coredomain.*;
import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class DisplayingStockReceipt extends Composite{
	/** @GUIcomponents */
	private VerticalPanel m_Panel = new VerticalPanel();
	
	private Label receiptDate_Label_Label = new Label();
	private Label receiptDate_Value_Label = new Label();
	private HorizontalPanel receiptDate_Panel = new HorizontalPanel();
	
	private Label comments_Label_Label = new Label();
	private Label comments_Value_Label = new Label();
	private HorizontalPanel comments_Panel = new HorizontalPanel();
	
	private Label totalQuantity_Label_Label = new Label();
	private Label totalQuantity_Value_Label = new Label();
	private HorizontalPanel totalQuantity_Panel = new HorizontalPanel();
	
	private Label totalValue_Label_Label = new Label();
	private Label totalValue_Value_Label = new Label();
	private HorizontalPanel totalValue_Panel = new HorizontalPanel();
	
	private Label inventoryUpdated_Label_Label = new Label();
	private Label inventoryUpdated_Value_Label = new Label();
	private HorizontalPanel inventoryUpdated_Panel = new HorizontalPanel();
	
	private Label status_Label_Label = new Label();
	private Label status_Value_Label = new Label();
	private HorizontalPanel status_Panel = new HorizontalPanel();
	
	private CellTable lineItemsCellTable;
	
	/** @DomainComponents */
	public InventorySystem inventorySystem;
	
	/** @GUI */
	
	public DisplayingStockReceipt(InventorySystem invSys, CellTable lineItems){
		try{
			initWidget(m_Panel);
			inventorySystem = invSys;
			lineItemsCellTable = lineItems;
			jbInit();
		}
		catch(JavaScriptException e) {
			
		}
	}

	private void jbInit() throws JavaScriptException {
		/** @Button */
		
		/** @Label */
		status_Label_Label.setText("Status");
		totalQuantity_Label_Label.setText("Total Quantity");
		totalValue_Label_Label.setText("Total Value");
		comments_Label_Label.setText("Comments");
		receiptDate_Label_Label.setText("Receipt Date");
		
		StockReceipt currReceipt = inventorySystem.getCurrentStockReceipt();
		String totQty="";
		totQty = String.valueOf(currReceipt.getTotalQuantity());
		
		String totValue="";
		totValue = currReceipt.getTotalValue().toString();
		
		String receiptDate="";
		receiptDate = currReceipt.getReceiptDate().toString();
		
		String statusText="";
		statusText = currReceipt.getStatus();
		
		String comments = "";
		comments = currReceipt.getComments();
		
		Window.alert("totQty: " + totQty + "; totaValue: " + totValue + "; receiptDate: " + receiptDate + "; statusText: " + statusText + "; comments: " + comments);
		
		totalQuantity_Value_Label.setText(totQty);
		totalValue_Value_Label.setText(totValue);
		receiptDate_Value_Label.setText(receiptDate);
		status_Value_Label.setText(statusText);
		comments_Value_Label.setText(comments);
		
		/** @List */
		
		/** @Panel */
		receiptDate_Panel.add(receiptDate_Label_Label);
		receiptDate_Panel.add(receiptDate_Value_Label);
		comments_Panel.add(comments_Label_Label);
		comments_Panel.add(comments_Value_Label);
		totalQuantity_Panel.add(totalQuantity_Label_Label);
		totalQuantity_Panel.add(totalQuantity_Value_Label);
		totalValue_Panel.add(totalValue_Label_Label);
		totalValue_Panel.add(totalValue_Value_Label);
		inventoryUpdated_Panel.add(inventoryUpdated_Label_Label);
		inventoryUpdated_Panel.add(inventoryUpdated_Value_Label);
		status_Panel.add(status_Label_Label);
		status_Panel.add(status_Value_Label);
		
		m_Panel.add(totalQuantity_Panel);
		m_Panel.add(totalValue_Panel);
		m_Panel.add(inventoryUpdated_Panel);
		m_Panel.add(status_Panel);
		m_Panel.add(receiptDate_Panel);
		m_Panel.add(comments_Panel);
		m_Panel.add(lineItemsCellTable);
		
	}
}

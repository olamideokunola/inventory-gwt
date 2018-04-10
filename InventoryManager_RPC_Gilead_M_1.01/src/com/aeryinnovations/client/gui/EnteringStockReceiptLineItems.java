package com.aeryinnovations.client.gui;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.aeryinnovations.shared.coredomain.*;
import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;

public class EnteringStockReceiptLineItems extends Composite {
	
	private static Logger rootLogger = Logger.getLogger("");
	
	/** @GUIcomponents */
	public Label stockReceiptLineItems_Label = new Label();
	public CellTable <StockReceiptLineItem> stockReceiptLineItems_CellTable = new CellTable<StockReceiptLineItem>();
	public ListDataProvider<StockReceiptLineItem> stockReceiptLineItems_dataProvider = new ListDataProvider<StockReceiptLineItem>();
	public Button addStockReceiptLineItem_Button = new Button();
	public VerticalPanel m_Panel = new VerticalPanel();
	
	/** @DomainComponents */
	public InventorySystem inventorySystem;
	
	/** @GUI */
	public NewStockReceiptForm NewStockReceiptForm_GUI;
	public EnteringStockReceiptLineItem EnteringStockReceiptLineItem_GUI;

	public EnteringStockReceiptLineItems(){
		try{
			initWidget(m_Panel);
			NewStockReceiptForm_GUI = new NewStockReceiptForm();
			EnteringStockReceiptLineItem_GUI = new EnteringStockReceiptLineItem();
			jbInit();

		}
		catch(JavaScriptException e) {
			
		}
	}
	
	private void jbInit() throws JavaScriptException {
		/** @Button */
		this.addStockReceiptLineItem_Button.setText("Add Line Item");
		this.addStockReceiptLineItem_Button.addClickHandler(
				new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						// TODO Auto-generated method stub
						addStockReceiptLineItem_Button_GUI();
					}			
				});
		
		/** @Label */
		this.stockReceiptLineItems_Label.setText("Line Items");
		
		/** @CellTable */
		
		// Declare Columns
		TextColumn<StockReceiptLineItem> idColumn = new TextColumn<StockReceiptLineItem>() {
		      @Override
		      public String getValue(StockReceiptLineItem stockReceiptLineItem) {
		        return stockReceiptLineItem.getSparePartSpecification().getSpSpecId().toString();
		      }
	    };
	    
	    TextColumn<StockReceiptLineItem> nameColumn = new TextColumn<StockReceiptLineItem>() {
		      @Override
		      public String getValue(StockReceiptLineItem stockReceiptLineItem) {
		        return stockReceiptLineItem.getSparePartSpecification().getPartDescription();
		      }
	    };
	    TextColumn<StockReceiptLineItem> quantityColumn = new TextColumn<StockReceiptLineItem>() {
		      @Override
		      public String getValue(StockReceiptLineItem stockReceiptLineItem) {
		        return Integer.toString(stockReceiptLineItem.getQuantity());
		      }
	    };
	    TextColumn<StockReceiptLineItem> valueColumn = new TextColumn<StockReceiptLineItem>() {
		      @Override
		      public String getValue(StockReceiptLineItem stockReceiptLineItem) {
		        return  stockReceiptLineItem.getSubTotalValue().toString();
		      }
	    };
	    TextColumn<StockReceiptLineItem> poColumn = new TextColumn<StockReceiptLineItem>() {
		      @Override
		      public String getValue(StockReceiptLineItem stockReceiptLineItem) {
		        return stockReceiptLineItem.getPoNumber();
		      }
	    };
		    
		// Add Columns to CellTable
	    stockReceiptLineItems_CellTable.addColumn(idColumn,"id");
	    stockReceiptLineItems_CellTable.addColumn(nameColumn,"Description");
	    stockReceiptLineItems_CellTable.addColumn(quantityColumn,"Quantity");
	    stockReceiptLineItems_CellTable.addColumn(valueColumn,"Value");
	    stockReceiptLineItems_CellTable.addColumn(poColumn,"PO Number");
	    
		// Attach CellTable to DataProvider
	    stockReceiptLineItems_dataProvider.addDataDisplay(stockReceiptLineItems_CellTable);
	    
	    // Add Selection Handler

		
		/** @Panel */
	    m_Panel.add(EnteringStockReceiptLineItem_GUI);
	    m_Panel.add(addStockReceiptLineItem_Button);
	    m_Panel.add(stockReceiptLineItems_Label);
	    m_Panel.add(stockReceiptLineItems_CellTable);

		
	} // end jbInit()
	
	//Methods Implementation
	/** @Button */

	
	/** @CellTable */
	
	
	void addStockReceiptLineItem_Button_GUI(){
		SparePartSpecification spec  = InventorySystem.getSparePartRegister().getCurrentSparePartSpec();

		String qtyStr = EnteringStockReceiptLineItem_GUI.quantity_TextBox.getText();
		
		String poNumber = EnteringStockReceiptLineItem_GUI.poNumber_TextBox.getText();
        	
		int qty = Integer.valueOf(qtyStr);
		BigDecimal price = new BigDecimal(spec.getPrice().toString());
		price.setScale(2, BigDecimal.ROUND_HALF_EVEN);

		StockReceiptLineItem srli = new StockReceiptLineItem(qty, poNumber, "comments", spec);
		
		inventorySystem.createStockReceiptLineItem(srli);
		
		List<StockReceiptLineItem> stockReceiptLineItemsList = stockReceiptLineItems_dataProvider.getList();
		stockReceiptLineItemsList.add(srli);

		clearLineItemTextFields();
	}
	
	void clearLineItemTextFields(){
		EnteringStockReceiptLineItem_GUI.spSpecId_TextBox.setText("");
		EnteringStockReceiptLineItem_GUI.poNumber_TextBox.setText("");
		EnteringStockReceiptLineItem_GUI.quantity_TextBox.setText("");
	}
}
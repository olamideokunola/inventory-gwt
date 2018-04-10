package com.aeryinnovations.client.gui;

import com.aeryinnovations.shared.coredomain.InventorySystem;
import com.aeryinnovations.shared.coredomain.SparePartSpecification;
import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EnteringStockReceiptLineItem extends Composite{
	
	
	/** @GUIcomponents */
	public VerticalPanel m_Panel = new VerticalPanel();
	public Label quantity_Label = new Label();
	public TextBox quantity_TextBox = new TextBox();
	public HorizontalPanel quantity_Panel = new HorizontalPanel();
	
	public Label poNumber_Label = new Label();
	public TextBox poNumber_TextBox = new TextBox();
	public HorizontalPanel poNumber_Panel = new HorizontalPanel();
	
	public Label spSpecId_Label = new Label();
	public TextBox spSpecId_TextBox = new TextBox();
	public HorizontalPanel spSpecId_Panel = new HorizontalPanel();

	public Button selectSpSpec_Button = new Button();
	
	/** @GUI */
	public FindSparePartSpecification FindSparePartSpecification_GUI;
	
	/** @DomainComponents */
	InventorySystem inventorySystem;
	
	public EnteringStockReceiptLineItem(){
		try{
			FindSparePartSpecification_GUI = new FindSparePartSpecification();
			jbInit();
			
			
		}
		catch(JavaScriptException e) {
			
		}
	}

	private void jbInit() throws JavaScriptException {
		/** @Button */
		selectSpSpec_Button.setText("Select Spare part specification");
		selectSpSpec_Button.addClickHandler(
			new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					selectSpSpec_Button_FindSpSpec_GUI();
				}			
			});
		
		/** @Label */
		this.quantity_Label.setText("Quantity");
		this.poNumber_Label.setText("PO Number");
		this.spSpecId_Label.setText("Spare Part");
		
		/** @CellTable */

		
		/** @Panel */
		spSpecId_Panel.add(spSpecId_Label);
		spSpecId_Panel.add(spSpecId_TextBox);
		
		quantity_Panel.add(quantity_Label);
		quantity_Panel.add(quantity_TextBox);
		
		poNumber_Panel.add(poNumber_Label);
		poNumber_Panel.add(poNumber_TextBox);
		
		m_Panel.add(FindSparePartSpecification_GUI);
		m_Panel.add(selectSpSpec_Button);
		m_Panel.add(spSpecId_Panel);
		m_Panel.add(quantity_Panel);
		m_Panel.add(poNumber_Panel);
		
		
		this.initWidget(m_Panel);	
	} // end jbInit()
	
	//Methods Implementation
	
	/** @Button */
	void selectSpSpec_Button_FindSpSpec_GUI(){		
		//Set sparePartId from selection in search results
		SparePartSpecification selectedSpec = new SparePartSpecification();
		FindSparePartSpecification_GUI.searchResults_CellTable.getKeyboardSelectedRow();
		selectedSpec = FindSparePartSpecification_GUI.selectedItem;
		inventorySystem.getSparePartRegister().setCurrentSparePartSpec(selectedSpec);
		spSpecId_TextBox.setText(FindSparePartSpecification_GUI.selectedItem.getPartDescription());
		//sparePartId_TextBox.setText(FindSparePart_GUI.selectedItem.getSparePartSpecification().getSpareParts().get(0).getSparePartId().toString());
		
	}

	/** @CellTable */
	
}

package com.aeryinnovations.client.gui;

import com.aeryinnovations.client.presenter.NewStockReceiptPresenter;
import com.aeryinnovations.shared.coredomain.InventorySystem;
import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;


public class NewStockReceiptForm extends Composite implements NewStockReceiptPresenter.Display{
	/** @GUIcomponents */
	public Label newReceiptTitle = new Label();
	
	public HorizontalPanel receiptDate_Panel = new HorizontalPanel();
	public TextBox receiptDate_TextBox = new TextBox();
	public Label receiptDate_Label = new Label();
	
	public HorizontalPanel comments_Panel = new HorizontalPanel();
	public TextBox comments_TextBox = new TextBox();
	public Label comments_Label = new Label();
	
	public Button createStockReceipt_Button = new Button();
	
	public VerticalPanel m_Panel = new VerticalPanel();
	
	/** @DomainComponents */
	//public InventorySystem inventorySystem;
	
	/** @GUI */

	
	public NewStockReceiptForm(){
		try{
			initWidget(m_Panel);
			//inventorySystem = invSys;
			jbInit();
		}
		catch(JavaScriptException e) {
			
		}
	}
	
	private void jbInit() throws JavaScriptException{
		
		/** @Button */
		createStockReceipt_Button.setText("Create");
		
		/** @Label */
		newReceiptTitle.setText("New Receipt");
		receiptDate_Label.setText("Receipt Date");
		comments_Label.setText("Comments");
		
		/** @TextBox */
		
		
		/** @Panel */
		this.receiptDate_Panel.add(receiptDate_Label);
		this.receiptDate_Panel.add(receiptDate_TextBox);
		this.comments_Panel.add(comments_Label);
		this.comments_Panel.add(comments_TextBox);
	
		this.m_Panel.add(newReceiptTitle);
		this.m_Panel.add(receiptDate_Panel);
		this.m_Panel.add(comments_Panel);
		this.m_Panel.add(createStockReceipt_Button);
		
		/** Set Styles */
		this.setStyles();
		
		/** Domain startup */
		
	} // end jbInit()
	
	private void setStyles() throws JavaScriptException{
		
		/** @Button */
		createStockReceipt_Button.setStyleName("");
				
		/** @Label */
		newReceiptTitle.setStyleName("");
		receiptDate_Label.setStyleName("");
		comments_Label.setStyleName("");
		
		/** @TextBox */
		
		/** @Panel */
		setStyleName("");
		receiptDate_Panel.setStyleName("");
		comments_Panel.setStyleName("");

	} // end setStyles()

	@Override
	public HasClickHandlers getCreateStockReceipt_Button() {
		// TODO Auto-generated method stub
		return createStockReceipt_Button;
	}

	@Override
	public HasValue<String> getReceiptDateField() {
		// TODO Auto-generated method stub
		return receiptDate_TextBox;
	}

	@Override
	public HasValue<String> getCommentsField() {
		// TODO Auto-generated method stub
		return comments_TextBox;
	}

	
	//Methods Implementation
}

package com.aeryinnovations.client.gui;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.aeryinnovations.client.presenter.EnteringStockReceiptLineItemsPresenter;
import com.aeryinnovations.shared.coredomain.*;
import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.google.gwt.view.client.SingleSelectionModel;

public class FindSparePartSpecification extends Composite implements EnteringStockReceiptLineItemsPresenter.Display{
	private static Logger rootLogger = Logger.getLogger("");
	/** @GUIcomponents */
	public VerticalPanel m_Panel = new VerticalPanel();
	public TextBox spSpecId_TextBox = new TextBox();
	public Label spSpecId_Label = new Label();
	public HorizontalPanel spSpecId_Panel = new HorizontalPanel();
	
	public TextBox spSpecDesc_TextBox = new TextBox();
	public Label spSpecDesc_Label = new Label();
	public HorizontalPanel spSpecDesc_Panel = new HorizontalPanel();
	
	public TextBox spSpecType_TextBox = new TextBox();
	public Label spSpecType_Label = new Label();
	public HorizontalPanel spSpecType_Panel = new HorizontalPanel();
	
	public Button findSpSpec_Button = new Button();
	
	public Label searchResults_Label = new Label();
	public CellTable<SparePartSpecification> searchResults_CellTable = new CellTable<SparePartSpecification>();
	public ListDataProvider<SparePartSpecification> searchResults_dataProvider = new ListDataProvider<SparePartSpecification>();
	public VerticalPanel search_Results_Panel = new VerticalPanel();
	
	/** @DomainComponents */
	public InventorySystem inventorySystem;
	public SparePartSpecification selectedItem;
	
	/** @GUI */
	public FindSparePartSpecification(){
		try{
			initWidget(m_Panel);
			jbInit();
		}
		catch(JavaScriptException e) {
			
		}
	}
	
	private void jbInit() throws JavaScriptException {
	/** @Button */
		findSpSpec_Button.setText("Find Spare Part Spec");
		
		/**
		findSpSpec_Button.addClickHandler(
			new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					findSpSpec_Button_FindSparePartSpec_GUI();
				}			
			});
		*/
		
	/** @Label */
		spSpecId_Label.setText("Spare Part Specification Id");
		spSpecDesc_Label.setText("Spare Part Description");
		spSpecType_Label.setText("Spare Part type");
		searchResults_Label.setText("Search Results");
		
	/** @CellTable */

		TextColumn<SparePartSpecification> nameColumn = new TextColumn<SparePartSpecification>() {
		      @Override
		      public String getValue(SparePartSpecification sparePartSpecification) {
		        return sparePartSpecification.getPartDescription();
		      }
		    };
	    TextColumn<SparePartSpecification> idColumn = new TextColumn<SparePartSpecification>() {
		      @Override
		      public String getValue(SparePartSpecification sparePartSpecification) {
		        return sparePartSpecification.getSpSpecId().toString();
		      }
		    };
		searchResults_CellTable.addColumn(idColumn,"id");
		searchResults_CellTable.addColumn(nameColumn,"description");
		
		//searchResults_dataProvider.addDataDisplay(searchResults_CellTable);
		
		/**
	    final SingleSelectionModel<SparePartSpecification> ssm = new SingleSelectionModel<SparePartSpecification>();
		searchResults_CellTable.setSelectionModel(ssm);
		ssm.addSelectionChangeHandler( 	 		
			new SelectionChangeEvent.Handler() {
		    @Override
			    public void onSelectionChange(SelectionChangeEvent event)
			    {
		    		selectedItem = ssm.getSelectedObject();
			    }
		});
		*/
		
		/** @Panel */
		this.spSpecId_Panel.add(spSpecId_Label);
		this.spSpecId_Panel.add(spSpecId_TextBox);
		this.spSpecDesc_Panel.add(spSpecDesc_Label);
		this.spSpecDesc_Panel.add(spSpecDesc_TextBox);
		this.spSpecType_Panel.add(spSpecType_Label);
		this.spSpecType_Panel.add(spSpecType_TextBox);
		this.search_Results_Panel.add(searchResults_Label);
		this.search_Results_Panel.add(searchResults_CellTable);
		this.m_Panel.add(spSpecId_Panel);
		this.m_Panel.add(spSpecDesc_Panel);
		this.m_Panel.add(spSpecType_Panel);
		this.m_Panel.add(findSpSpec_Button);
		this.m_Panel.add(search_Results_Panel);
		//this.m_Panel.add(selectSparePart_Button);
		
		
	} // end jbInit()
	
	
	//Methods Implementation
	/** @List */
	
	/** @Button */
	void findSpSpec_Button_FindSparePartSpec_GUI(){		
		
		String spSpecId = spSpecId_TextBox.getText();
		String spSpecDesc = spSpecDesc_TextBox.getText();
		String spSpecType = spSpecType_TextBox.getText();
		
		rootLogger.log(Level.INFO, "Search Area, number of items: " + inventorySystem.getSparePartRegister().getSparePartSpecifications().size());

		List<SparePartSpecification> specSearchList = inventorySystem.findSparePartSpecs(spSpecId, spSpecDesc, spSpecType);
		
			
		List<SparePartSpecification> resultList = searchResults_dataProvider.getList();
		resultList.clear();
		resultList.addAll(specSearchList);
		//rootLogger.log(Level.INFO, "Search Area, number of items: " + inventorySystem.getSparePartRegister().getSparePartSpecifications().size());
		//rootLogger.log(Level.INFO, "Search Results: " + specSearchList.size());
		//resultList.add(this.inventorySystem.getStore().findSparePart(spec.getSpareParts().get(0).getSparePartId().toString()));
	}

	@Override
	public HasValue<String> getSpSpecIdField() {
		// TODO Auto-generated method stub
		return this.spSpecId_TextBox;
	}

	@Override
	public HasValue<String> getSpSpecDescField() {
		// TODO Auto-generated method stub
		return this.spSpecDesc_TextBox;
	}

	@Override
	public HasValue<String> getSpSpecTypeField() {
		// TODO Auto-generated method stub
		return this.spSpecType_TextBox;
	}

	@Override
	public HasClickHandlers getFindSpSpec_Button() {
		// TODO Auto-generated method stub
		return this.findSpSpec_Button;
	}

	@Override
	public HasData<SparePartSpecification> getSearchResultsCellTable() {
		// TODO Auto-generated method stub
		return this.searchResults_CellTable;
	}


}
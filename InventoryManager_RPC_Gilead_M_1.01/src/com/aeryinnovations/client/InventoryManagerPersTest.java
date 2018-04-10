package com.aeryinnovations.client;

import com.aeryinnovations.shared.entities.Person;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class InventoryManagerPersTest implements EntryPoint{
	
	//GUI Elements
	final Label feedback_label = new Label("blank feedback");
	final Label fName_label = new Label("Firstname:");
	final TextBox fName_textBox = new TextBox();
	final Label lName_label = new Label("Lastname:");
	final TextBox lName_textBox = new TextBox();
	final Button submit_button = new Button("Send");
	VerticalPanel nameVPanel = new VerticalPanel();
	
	//RPC  Service
	private MessageServiceAsync messageService;;
	
	//Fields
	String fName;
	String lName;
	String fullName;
	String feedback;
	
	@Override
	public void onModuleLoad() {
		
		messageService = GWT.create(MessageService.class);
	
		nameVPanel.add(fName_label);
		nameVPanel.add(fName_textBox);
		nameVPanel.add(lName_label);
		nameVPanel.add(lName_textBox);
		nameVPanel.add(submit_button);
		nameVPanel.add(feedback_label);
		
		RootPanel.get().add(nameVPanel);
		
		class MyHandler implements ClickHandler {
			@Override
			public void onClick(ClickEvent event) {
				
				fName = fName_textBox.getText();
				lName = lName_textBox.getText();
				
				fullName = fName_textBox.getText() + " " + lName_textBox.getText();
				
				sendMessage(fullName);
				savePerson(fName, lName);
				savePersonClass(new Person(fName, lName));
				
				fName_textBox.setText("");
				lName_textBox.setText("");
				
			}
		}
		
		MyHandler handler = new MyHandler();
		submit_button.addClickHandler(handler);
		
	}
	
	void sendMessage(String fullNm) {
		messageService.sendUser(fullNm, new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				feedback = "Error! " + caught.getMessage();
				feedback_label.setText(feedback);
			}

			@Override
			public void onSuccess(String result) {
				feedback = result;
				feedback_label.setText(feedback);
			}
			
		});
	}
	
	void savePerson(String fNm, String lNm) {
		messageService.saveUser(fNm, lNm, new AsyncCallback<String>() {
			
			@Override
			public void onFailure(Throwable caught) {
				feedback = "Error! " + caught.getMessage();
				feedback_label.setText(feedback);
			}
			
			@Override
			public void onSuccess(String result) {
				feedback = result;
				feedback_label.setText(feedback);
			}
			
		});		
	}
	
	void savePersonClass(Person person) {
		messageService.saveUserClass(person, new AsyncCallback<String>() {
			@Override
			public void onFailure(Throwable caught) {
				feedback = "Error! " + caught.getMessage();
				feedback_label.setText(feedback);
			}
			
			@Override
			public void onSuccess(String result) {
				feedback = result;
				feedback_label.setText(feedback);
			}
			
		});		
	}
	
}

package com.aeryinnovations.client;

import com.aeryinnovations.shared.entities.Person;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MessageServiceAsync {
	void sendUser(String s, AsyncCallback<String> callback);
	void saveUser(String firstName, String lastName, AsyncCallback<String> callback);
	void saveUserClass(Person person, AsyncCallback<String> callback);
}

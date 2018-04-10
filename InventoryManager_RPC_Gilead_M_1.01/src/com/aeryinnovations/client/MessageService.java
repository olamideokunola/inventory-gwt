package com.aeryinnovations.client;

import com.aeryinnovations.shared.entities.Person;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("message")
public interface MessageService extends RemoteService {
	public String sendUser(String s);
	public String saveUser(String firstName, String lastName);
	public String saveUserClass(Person person);
}
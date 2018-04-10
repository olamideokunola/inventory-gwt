package com.aeryinnovations.shared.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import net.sf.gilead.pojo.gwt.LightEntity;


@Entity
public class Person extends LightEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//fields
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long personId;
	@Basic
	private String firstName;
	@Basic
	private String lastName;
	
	//constructor
	Person(){}
	public Person(String fName, String lName){
		personId = null;
		firstName = fName;
		lastName = lName;
	}
	
	//methods
	
	//setters & getters
	public Long getPersonId() {
		return personId;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}
}

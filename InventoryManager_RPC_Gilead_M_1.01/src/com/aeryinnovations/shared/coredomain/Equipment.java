package com.aeryinnovations.shared.coredomain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Equipment implements Serializable

{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//fields
  @Id
  @GeneratedValue(generator="increment")
  @GenericGenerator(name="increment", strategy = "increment")
  private Long equipmentId;
  
  @Basic
  private String serialNumber;
  
  @Basic
  private EquipmentSpecification equipmentSpecification;
  
 //constructor
  public Equipment(){
	 equipmentId = null;
     equipmentSpecification = null;	
     serialNumber = null;
  }  

  public Equipment(EquipmentSpecification equipmentSpecification, String serialNumber){
     this.equipmentId = null;
	 this.equipmentSpecification  = equipmentSpecification ;
     this.serialNumber = serialNumber;
  }

 //methods

 //getter methods
  public EquipmentSpecification getEquipmentSpecification() {
	  return this.equipmentSpecification;
  }
  
  public String getSerialNumber() {
	  return this.serialNumber;
  }
  
  public Long getEquipmentId() {
	  return this.equipmentId;
  }  
}

package com.aeryinnovations.shared.coredomain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.aeryinnovations.shared.JPAUtil;

public class EquipmentRegister
{
 //fields
 private EquipmentSpecification equipmentSpecification;
 private List<EquipmentSpecification> equipmentSpecifications;
 //private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
 
 //constructor
  public EquipmentRegister(){
     this.equipmentSpecification=null;
     this.equipmentSpecifications = new ArrayList<EquipmentSpecification>();
     loadEquipmentSpecifications();
     this.equipmentSpecification = new EquipmentSpecification();
  }

 //methods
  public void loadEquipmentSpecifications(){
	  
	  EquipmentSpecification equipSpec;
	  equipSpec = new EquipmentSpecification("eq01", "Equipment 01",  "EquipmentType 01", "manufacturer01", "pn001", "10");
	  this.equipmentSpecifications.add(equipSpec);
	  equipSpec = new EquipmentSpecification("eq02", "Equipment 02",  "EquipmentType 01", "manufacturer01", "pn002", "20");
	  this.equipmentSpecifications.add(equipSpec);
  }
 
  public EquipmentSpecification findEquipmentSpecification(String equipmentSpecificationId){
	  
	  EquipmentSpecification equipmentSpec = new EquipmentSpecification();  
	
	  for (EquipmentSpecification eqSpec : equipmentSpecifications) {
		  if (equipmentSpecificationId.equals(eqSpec.getEquipmentSpecificationId())) {
			  equipmentSpec = eqSpec;
		  }
	  }
		 
	  return equipmentSpec; 
	  

  }

//getter methods
  public EquipmentSpecification getEquipmentSpecification() {
	  return equipmentSpecification;
  }
  
  public List<EquipmentSpecification> getEquipmentSpecifications(){
	return equipmentSpecifications;
  }
}

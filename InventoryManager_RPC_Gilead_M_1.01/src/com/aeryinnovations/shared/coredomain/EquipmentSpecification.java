package com.aeryinnovations.shared.coredomain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.Session;
import org.hibernate.annotations.GenericGenerator;

import com.aeryinnovations.shared.JPAUtil;

@Entity
public class EquipmentSpecification implements Serializable {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//fields
 //
 
 @Id
 @GeneratedValue(generator="increment")
 @GenericGenerator(name="increment", strategy = "increment")
 private Long equipmentSpecificationId;
 
 @Basic
 private String equipmentDescription;
 
 @Basic
 private String equipmentType;
 
 @Basic
 private String manufacturer;
 
 @Basic
 private String manufacturerPartNumber;
 
 @Basic
 private BigDecimal price; 
 
 @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
 private List<Equipment> equipments;
 
 //constructors
  public EquipmentSpecification(){
	 this.equipmentSpecificationId = null;
	 this.equipmentDescription = null;
	 this.equipmentType = null;
	 this.manufacturer = null;
     this.manufacturerPartNumber = null;
     this.price = new BigDecimal("0");
     this.price.setScale(2,BigDecimal.ROUND_HALF_EVEN);
     this.equipments = new ArrayList<Equipment>();
  }
  
  public EquipmentSpecification(String equipmentSpecificationId, String equipmentDescription,String equipmentType,String manufacturer,String manufacturerPartNumber, String price){
     this.equipmentSpecificationId = null;
     this.equipmentDescription = equipmentDescription;
     this.equipmentType = equipmentType;
     this.manufacturer = manufacturer;
     this.manufacturerPartNumber = manufacturerPartNumber;
     this.price = new BigDecimal(price);
     this.price.setScale(2,BigDecimal.ROUND_HALF_EVEN);
     this.equipments = new ArrayList<Equipment>();
  }

 //methods
 public void loadSpecifications() {

 }


 //getter methods

 public String getEquipmentDescription() {
	 return this.equipmentDescription;
 }
 public String getEquipmentType() {
	 return this.equipmentType;
 }
 public String getManufacturer() {
	 return this.manufacturer;
 }
 public String getManufacturerPartNumber() {
	 return this.manufacturerPartNumber;
 }
 public List<Equipment> getEquipments(){
	 return this.equipments;
 }

 public String getEquipmentSpecificationId() {
	 // TODO Auto-generated method stub
     return null;
 }

}

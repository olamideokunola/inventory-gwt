package com.aeryinnovations.shared.coredomain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Location implements Serializable
{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//fields
 @Id
 @GeneratedValue(generator="increment")
 @GenericGenerator(name="increment", strategy = "increment")
 private String locationId;

 @Basic
 private String locationDescription;
 
 @Basic
 private String locationType;

 @Transient
 private Equipment currentEquipment;
 
 @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
 private List<Location> childLocations;

 @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
 private List<Equipment> equipments;

 @Transient
 private Location currentChildLocation;
 
 //constructor
  public Location(){
     locationId = null;
     locationDescription = null;
     currentEquipment = null;
     childLocations = new ArrayList<Location>();
     equipments = new ArrayList<Equipment>();
     currentChildLocation= null;
  }

  public Location(String locationId, String locationDescription, String locationType){
     this.locationId = locationId;
     this.locationDescription = locationDescription;
     this.currentEquipment = null;
     childLocations = new ArrayList<Location>();
     equipments = new ArrayList<Equipment>();
     currentChildLocation= null;
  }

 //methods
 public void loadChildLocations(){
 }

 public void  loadEquipments(){
 }
 
 public Equipment findEquipment(String equipmentSpecificationId) {
	 Equipment equipment = null;
	 for (Equipment eqmt : this.getEquipments()){
		 if (equipmentSpecificationId.equals(equipment.getEquipmentSpecification().getEquipmentSpecificationId())){
			 equipment = eqmt;
		 }
	 }
	 return equipment;
 }

//getter methods
 public String getLocationId() {
	 return this.locationId;
 }
 
 public String getLocationDescription() {
	 return this.locationDescription;
 }
 
 public String getLocationType() {
	 return this.locationType;
 }
 
 public Equipment getCurrentEquipment() {
	 return this.currentEquipment;
 }
 
 public List<Location> getChildLocations(){
	 return this.childLocations;
 }
 
 public List<Equipment> getEquipments(){
	 return this.equipments;
 }
 
 public Location getCurrentChildLocation() {
	 return this.currentChildLocation;
 }
}

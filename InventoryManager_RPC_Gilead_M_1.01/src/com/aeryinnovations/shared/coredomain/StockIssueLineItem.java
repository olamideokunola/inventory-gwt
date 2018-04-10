package com.aeryinnovations.shared.coredomain;

import java.util.Date;

public class StockIssueLineItem {
    //fields
   private int quantity;
   private String SIVNumber;
   private Date issueDate;
   private String comments;
   private String serialNumber;
   private SparePart sparePart;
   private Equipment equipment;
   private Location location;

   //constructor
   public StockIssueLineItem (){
      this.quantity = 0;
      this.SIVNumber = null;
      this.issueDate =null;
      this.comments=null;
      this.serialNumber = null;
      this.sparePart = new SparePart();
      this.equipment = new Equipment();
      this.location = new Location();
   }

   public StockIssueLineItem(int qty, String SIVNum, Date issDate, String com, String sNum, SparePart sparePart, Equipment equipment, Location location){
      this.quantity = qty;
      this.SIVNumber = SIVNum;
      this.issueDate = issDate;
      this.comments = com;
      this.serialNumber = sNum;
      this.sparePart = sparePart;
      this.location = location;
      this.equipment = equipment;
   }

   //methods
 

  //getter methods
  public int getQuantity () {
	  return this.quantity;
  }
  public String getSIVNumber() {
	  return this.SIVNumber;
  }
  public Date getIssueDate() {
	  return this.issueDate;
  }
  public String getComments() {
	  return this.comments;
  }
  public String getSerialNumber() {
	  return this.serialNumber;
  }
  public SparePart getSparePart() {
	  return this.sparePart;
  }
  public Equipment getEquipment() {
	  return this.equipment;
  }
  public Location getLocation() {
	  return this.location;
  }
}

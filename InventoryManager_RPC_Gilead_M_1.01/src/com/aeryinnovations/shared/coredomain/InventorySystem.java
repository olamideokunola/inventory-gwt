package com.aeryinnovations.shared.coredomain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.aeryinnovations.client.InventoryManagerService;
import com.aeryinnovations.client.InventoryManagerServiceAsync;
import com.google.gwt.core.client.GWT;

public class InventorySystem {
	
	private static Logger rootLogger = Logger.getLogger("");
	
//fields
	//Stock Receipt Iteration
	private static StockReceipt stockReceipt ;
	private static SparePartRegister sparePartRegister = new SparePartRegister();
	private static Store store;
	
	private static List<StockReceipt> stockReceipts;
   
    //Stock Issue Iteration
	private static Location currentLocation;
	private static StockIssue stockIssue;
	private static List <Location> locations;
	private static EquipmentRegister equipmentRegister;
	private static List<StockIssue> stockIssues;
   
//constructor
	public InventorySystem(){
	//Stock Receipt Iteration
	//this.sparePartRegister = new SparePartRegister();
	InventorySystem.store = new Store("Toner Store","Lagos Brewery");
	InventorySystem.stockReceipt = null;
	InventorySystem.stockReceipts = new ArrayList<StockReceipt>();
	
	//Stock Issue Iteration
	InventorySystem.stockIssue= new StockIssue();
	locations = new ArrayList<Location>();
	this.loadLocations();
	InventorySystem.currentLocation = new Location();
	InventorySystem.equipmentRegister = new EquipmentRegister();
	InventorySystem.stockIssues = new ArrayList<StockIssue>();;

  }

 //methods
   public void newStockReceipt(Date receiptDate, int totalQuantity, BigDecimal totalValue, String comments, String status){
	   InventorySystem.stockReceipt = new StockReceipt(receiptDate, totalQuantity, totalValue, comments, status);
   }
   
   public static List<SparePartSpecification> findSparePartSpecs(String spSpecId, String spSpecDesc, String spSpecType){
	   List<SparePartSpecification> specs = new ArrayList<>();
	   specs.addAll(sparePartRegister.findSparePartSpecifications(spSpecId, spSpecDesc, spSpecType));
       return specs;
  }
   
   public SparePartSpecification getSparePartSpec(String spSpecId){
        SparePartSpecification spec = sparePartRegister.getSparePartSpecification(spSpecId);
        return spec;
   }   
   
   public void createStockReceiptLineItem(SparePartSpecification spec, int qty, BigDecimal price,String poNumber){
	   stockReceipt.createStockReceiptLineItem (spec, price, qty, poNumber);
   }
   
   public void createStockReceiptLineItem(StockReceiptLineItem srli){
	   stockReceipt.createStockReceiptLineItem (srli);
   }
   
   public void completeStockReceipt(){
	   if (stockReceipt.getStatus().equals("isCompleted") == false) {
		   stockReceipt.becomeComplete();
		   store.createInventory(stockReceipt);
		   this.logCompletedStockReceipt();
	   }
   }
   
   public void logCompletedStockReceipt(){
	   InventorySystem.stockReceipts.add(stockReceipt);
   }

   //stock issue iteration
   public void newStockIssue(){
	   InventorySystem.stockIssue = new StockIssue();
   }

   public void createStockIssueLineItem(String sparePartId, int qty, BigDecimal price, String SIVNumber, String equipmentId, String locationId){
       //SparePartSpecification spSpec = this.findSparePartSpec(sparePartId);
	   SparePart sp = store.findSparePart(sparePartId);
       Location loc = this.findLocation(locationId);
       Equipment eqmt = loc.findEquipment(equipmentId);
       InventorySystem.stockIssue.createStockIssueLineItem(sp,loc,eqmt,qty,SIVNumber);
   }
   
   

 public void completeStockIssue(){
      stockIssue.becomeComplete();
      store.reduceInventory(this.stockIssue);
      logCompletedStockIssue();
 }

 private void loadLocations(){
      Location loc = new Location();
      loc = new Location("loc1", "Location 1", "LocationType1");
      InventorySystem.locations.add(loc);
      loc = new Location("loc2", "Location 2", "LocationType1");
      InventorySystem.locations.add(loc);
 }
 
 public Location findLocation(String locationId) {
	 Location location = null;
	 for (Location loc : this.getLocations()){
		 if (locationId.equals(loc.getLocationId())){
		     location = loc;
		 }
	 }
	 return location;
 }
 

 private void logCompletedStockIssue(){
	 InventorySystem.stockIssues.add(InventorySystem.stockIssue);
 }
 
//getter methods
  public static StockReceipt getCurrentStockReceipt(){
	return InventorySystem.stockReceipt;
  }
  public static SparePartRegister getSparePartRegister(){
	return InventorySystem.sparePartRegister ;
  }
  public static Store getStore(){
	return InventorySystem.store;
  }
  
  //stock issue iteration
  public Location getCurrentLocation(){
        return InventorySystem.currentLocation;
  }
  
  public static StockIssue getStockIssue(){
        return InventorySystem.stockIssue;
  }
  public static List<Location> getLocations(){
	return InventorySystem.locations;
  }  
  
  public static EquipmentRegister getEquipmentRegister(){
	return InventorySystem.equipmentRegister;
  }
  public static List<StockIssue> getStockIssues(){
		return InventorySystem.stockIssues;
  }
  
  //getters and setters

	public static Logger getRootLogger() {
		return rootLogger;
	}

	public static StockReceipt getStockReceipt() {
		return stockReceipt;
	}

	public static void setStockReceipt(StockReceipt stockReceipt) {
		InventorySystem.stockReceipt = stockReceipt;
	}

	public static List<StockReceipt> getStockReceipts() {
		return stockReceipts;
	}

	public static void setStockReceipts(List<StockReceipt> stockReceipts) {
		InventorySystem.stockReceipts = stockReceipts;
	}

	public static void setRootLogger(Logger rootLogger) {
		InventorySystem.rootLogger = rootLogger;
	}

	public static void setSparePartRegister(SparePartRegister sparePartRegister) {
		InventorySystem.sparePartRegister = sparePartRegister;
	}

	public static void setStore(Store store) {
		InventorySystem.store = store;
	}

	public static void setCurrentLocation(Location currentLocation) {
		InventorySystem.currentLocation = currentLocation;
	}

	public static void setStockIssue(StockIssue stockIssue) {
		InventorySystem.stockIssue = stockIssue;
	}

	public static void setLocations(List<Location> locations) {
		InventorySystem.locations = locations;
	}

	public static void setEquipmentRegister(EquipmentRegister equipmentRegister) {
		InventorySystem.equipmentRegister = equipmentRegister;
	}

	public static void setStockIssues(List<StockIssue> stockIssues) {
		InventorySystem.stockIssues = stockIssues;
	}
  
  
}


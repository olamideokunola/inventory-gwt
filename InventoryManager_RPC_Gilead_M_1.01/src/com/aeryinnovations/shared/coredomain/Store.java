package com.aeryinnovations.shared.coredomain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import net.sf.gilead.pojo.java5.LightEntity;

@Entity
public class Store extends LightEntity implements Serializable {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//fields
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long storeId;
	
	@Basic
	private String name = new String();

	@Basic
	private String address = new String();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SparePart> spareParts;
	
	@Basic
	private SparePart currentSparePart;
	
	@Basic
	private boolean inventoryCreated;
 
 //constructor
	public Store() {};
	public Store(String name, String address){
		this.name=name;
		this.address=address;
		this.spareParts = null;
		this.loadInventory();
		this.currentSparePart = null;
		this.inventoryCreated = false;
	}

 //methods
  public void createInventory(StockReceipt stockReceipt){
     if (this.inventoryCreated == false) {
    	 for (StockReceiptLineItem srli : stockReceipt.getStockReceiptLineItems()) {
    		 int qty = srli.getQuantity();
    		 for (int i=1; i<qty ;i++) {
    			 this.spareParts.add(srli.getSparePart());
    		 }
    	 }
    	 this.inventoryCreated = false;
     }
  }

  public void loadInventory(){
	  spareParts = new ArrayList<SparePart>();
	  //String sparePartId, String partDescription,String partType,String manufacturer,String manufacturerPartNumber, BigDecimal price
	  
	  //Sample Data
	  SparePartSpecification spec;
	  SparePart sparePart;
	  
	  BigDecimal price = new BigDecimal("120.00");
	  price.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	  spec = new SparePartSpecification("Bearing 01","Bearing", "SKF", "6309", price);
	  sparePart = new SparePart(spec);
	  spareParts.add(sparePart);
	  spareParts.add(sparePart);
	  
	  
	  BigDecimal price2 = new BigDecimal("200.00");
	  price2.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	  spec = new SparePartSpecification("Sleeve 02","Sleeve", "SKF", "6102", price2);
	  sparePart = new SparePart(spec);
	  spareParts.add(sparePart);
	  spareParts.add(sparePart);
	  spareParts.add(sparePart);
	  spareParts.add(sparePart);
  }
  
  //stockIssue iteration
  public void reduceInventory(StockIssue stockIssue){
	  for (StockIssueLineItem sili : stockIssue.getStockIssueLineItems()){
	     for(int i=1; i<sili.getQuantity(); i++){
	         this.spareParts.remove(sili.getSparePart());
	     }  
	  }    	
  }
  
  public SparePart findSparePart(String sparePartId) {
	  SparePart spPart = null;
	  for (SparePart sp : this.spareParts) {
		  if (sp.getSparePartId().equals(sparePartId)) {
			  spPart = sp; 
		  }
	  }
	  return spPart;
  }
  
  public void loadSpareParts(){
  
  }

//getter methods
  public String getName(){
     return name;
  }

  public String getAddress(){
     return address;
  }
  
  public List<SparePart> getSpareParts(){
	  return this.spareParts;
  }
  
  public SparePart getCurrentSparePart() {
	  return this.currentSparePart;
  }
  
  public boolean getInventoryCreated() {
	  return this.inventoryCreated;
  }
}
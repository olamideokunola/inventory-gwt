package com.aeryinnovations.shared.coredomain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import net.sf.gilead.pojo.java5.LightEntity;

@Entity
public class StockReceiptLineItem extends LightEntity implements Serializable {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//fields
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long stockReceiptLineItemId;
	
	@Basic
	private Long sparePartId;
	
	@Basic
	private int quantity;
	
	@Basic
	private String poNumber;
	
	@Basic
	private String comments;
	
	@Basic
	private SparePart sparePart;
	
	@Basic
	private Store store;
	
	@Basic
	private SparePartSpecification sparePartSpecification;
 
 //constructor
	public StockReceiptLineItem(){
	}
	
	public StockReceiptLineItem(int quantity, String poNumber, String comments, SparePartSpecification spec){
      this.sparePartId = null;
      this.quantity= quantity;
      this.poNumber=poNumber;
      this.comments = comments;
      this.sparePartSpecification = spec; 
      this.sparePart = null;
	}
	
 //methods
   public BigDecimal getSubTotalValue(){
	    BigDecimal subTot= new BigDecimal("0");
        subTot.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        subTot = BigDecimal.valueOf(this.quantity).multiply(this.sparePartSpecification.getPrice());
        return subTot;	
   }

//getter & setters methods
   	public Long getSparePartId(){
   		return this.sparePartId;
   	}
  
	public Long getStockReceiptLineItemId() {
		return stockReceiptLineItemId;
	}

	public String getPoNumber(){
		return this.poNumber;
	}
  
	public int getQuantity(){
		return this.quantity;
	}
  
	public String getComments(){
		return this.comments;
	}
  
	public SparePart getSparePart(){
		return this.sparePart;
	}
 
	public Store getStore(){
		return this.store;
	}
  
	public SparePartSpecification getSparePartSpecification (){
		return this.sparePartSpecification;
	}


	
	public void setStockReceiptLineItemId(Long stockReceiptLineItemId) {
		this.stockReceiptLineItemId = stockReceiptLineItemId;
	}
	
	public void setSparePartId(Long sparePartId) {
		this.sparePartId = sparePartId;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public void setSparePart(SparePart sparePart) {
		this.sparePart = sparePart;
	}
	
	public void setStore(Store store) {
		this.store = store;
	}
	
	public void setSparePartSpecification(SparePartSpecification sparePartSpecification) {
		this.sparePartSpecification = sparePartSpecification;
	}
  
  
}


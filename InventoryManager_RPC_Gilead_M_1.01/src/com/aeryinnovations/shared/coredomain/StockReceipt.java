package com.aeryinnovations.shared.coredomain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import net.sf.gilead.pojo.java5.LightEntity;

@Entity
public class StockReceipt extends LightEntity implements Serializable {
	private static Logger rootLogger = Logger.getLogger("");
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//fields
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long stockReceiptId;
	
	@Basic
	private Date receiptDate=new Date();
	
	@Basic
	private int totalQuantity = 0;
	// private BigDecimal totalValue;
	
	@Basic
	private String comments;
	
	@Basic
	private String status;

	@Basic
	private StockReceiptLineItem stockReceiptLineItem;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<StockReceiptLineItem> stockReceiptLineItems;
  
//constructor
	public StockReceipt(){}
	public StockReceipt(Date receiptDate, int totalQuantity, BigDecimal totalValue, String comments, String status ){
		this.receiptDate= receiptDate;
		this.totalQuantity = totalQuantity;
// 	 	this.totalValue= totalValue;
		this.comments= comments;
		this.status= status;
		this.stockReceiptLineItem = null;
		this.stockReceiptLineItems = new ArrayList<StockReceiptLineItem>();
	}

 //methods
   public BigDecimal getTotalValue(){
	   	BigDecimal tot = new BigDecimal("0");
	   	tot.setScale(0,BigDecimal.ROUND_HALF_EVEN);
        for (StockReceiptLineItem srli : stockReceiptLineItems)
            tot = tot.add(srli.getSubTotalValue());
        return tot;	
   }
   
   public int getTotalQuantity (){
	   	int tot = 0;
	   	for (StockReceiptLineItem srli : stockReceiptLineItems)
            tot = tot + srli.getQuantity();
		return tot;
   }
   
   public void createStockReceiptLineItem(SparePartSpecification spec, BigDecimal price, int qty, String poNumber){
        StockReceiptLineItem srli = new StockReceiptLineItem (qty, poNumber, this.comments, spec);
        this.stockReceiptLineItems.add(srli);
        this.stockReceiptLineItem = srli;
   }
   
   public void createStockReceiptLineItem(StockReceiptLineItem srli){
       this.stockReceiptLineItems.add(srli);
       this.stockReceiptLineItem = srli;
   }
   
   public void becomeComplete(){      
	   this.status = "isCompleted";
   }

//getter methods
  public Date getReceiptDate(){
	return this.receiptDate;
  }

  public String getComments(){
	return this.comments;
  }
  
  public String getStatus(){
	return this.status;
  }
  
  public StockReceiptLineItem getStockReceiptLineItem(){
	return this.stockReceiptLineItem;
  }
  
  public List<StockReceiptLineItem> getStockReceiptLineItems(){
	return this.stockReceiptLineItems ;
  }
  
	public Long getStockReceiptId() {
		return stockReceiptId;
	}
	public void setStockReceiptId(Long stockReceiptId) {
		this.stockReceiptId = stockReceiptId;
	}
	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setStockReceiptLineItem(StockReceiptLineItem stockReceiptLineItem) {
		this.stockReceiptLineItem = stockReceiptLineItem;
	}
	public void setStockReceiptLineItems(List<StockReceiptLineItem> stockReceiptLineItems) {
		this.stockReceiptLineItems = stockReceiptLineItems;
	}
  
  
}

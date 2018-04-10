package com.aeryinnovations.shared.coredomain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockIssue {
    //fields
    private Date issueDate;
    private int totalQuantity;
    private BigDecimal totalValue;
    private String comments;
    private String status;
    private StockIssueLineItem currentStockIssueLineItem;
    private List<StockIssueLineItem> stockIssueLineItems;


   //constructor
   public StockIssue (){
       issueDate = null;
       totalQuantity = 0;
       totalValue = new BigDecimal("0.0");
       totalValue.setScale(2,BigDecimal.ROUND_HALF_EVEN);
       comments = "";
       status = "Empty";
       currentStockIssueLineItem = new StockIssueLineItem();
       stockIssueLineItems = new ArrayList<StockIssueLineItem>();
   }

   public StockIssue (Date issueDate, String comments){
       issueDate = null;
       totalQuantity = 0;
       totalValue = new BigDecimal("0.0");
       totalValue.setScale(2,BigDecimal.ROUND_HALF_EVEN);
       comments = "";
       status = "Empty";
       currentStockIssueLineItem = new StockIssueLineItem();
       stockIssueLineItems = new ArrayList<StockIssueLineItem>();
   }


   //methods

   public void createStockIssueLineItem(SparePart sp, Location loc, Equipment eqmt, int qty, String SIVNumber){
       //int qty, String SIVNum, Date issDate, String com, String sNum, SparePart sparePart, Equipment equipment, Location location
	   StockIssueLineItem sili = new StockIssueLineItem(qty, SIVNumber, this.issueDate, this.comments, "", sp, eqmt, loc);
       this.stockIssueLineItems.add(sili);
   }

   public void becomeComplete(){
       this.status = "Completed";
       //InventorySystem.currentStockIssue = this;
   }
   


  //getter methods
   public  Date getIssueDate() {
	   return this.issueDate;
   }
   public int getTotalQuantity() {
	   return this.totalQuantity;
   }
   public BigDecimal getTotalValue() {
	   return this.totalValue;
   }
   public String getComments() {
	   return this.comments;
   }
   public String getStatus() {
	   return this.status;
   }
   public StockIssueLineItem getCurrentStockIssueLineItem() {
	   return this.currentStockIssueLineItem;
   }
   public List<StockIssueLineItem> getStockIssueLineItems(){
	   return this.stockIssueLineItems;
   }
}


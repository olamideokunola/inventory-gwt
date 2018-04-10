package com.aeryinnovations.shared.coredomain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import net.sf.gilead.pojo.java5.LightEntity;

@Entity
public class SparePartSpecification extends LightEntity implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//fields
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long spSpecId;
	
	@Basic
	private String partDescription;
	@Basic
	private String partType;
	@Basic
	private String manufacturer;
	@Basic
	private String manufacturerPartNumber;
	@Basic
	private BigDecimal price;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SparePart> spareParts;
 
 //constructor
  public SparePartSpecification(){
	  this.spSpecId = null;
      this.partDescription = null;
      this.partType = null;
      this.manufacturer = null;
      this.manufacturerPartNumber = null;
      this.price = null;
      this.spareParts = new ArrayList<SparePart>();
   }
  
  public SparePartSpecification(String partDescription,String partType,String manufacturer,String manufacturerPartNumber, BigDecimal price){
	  this.spSpecId = null;
	  this.partDescription = partDescription;
      this.partType = partType;
      this.manufacturer = manufacturer;
      this.manufacturerPartNumber = manufacturerPartNumber;
      this.price = price;
      this.spareParts = new ArrayList<SparePart>();
   }

//methods
  public SparePart findSparePart(Predicate <SparePart> tester) {
	  SparePart spPart = null;
	  for (SparePart sp : this.spareParts) {
		  if(tester.test(sp)) {
			  spPart = sp;
		  }
	  }
	  return spPart;
  }
  
  /**
  public SparePartSpecification persist() {
	  SparePartSpecification spec = this;
	  EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
	  EntityTransaction tx = em.getTransaction();
	  	em.persist(spec);
	  tx.commit();
	  em.close();	  
	  
	  return spec;
  }
  */

//getter methods
  
  public Long getSpSpecId(){
      return this.spSpecId;
  }

  public String getPartDescription(){
      return this.partDescription;
  }

  public String getPartType(){
      return this.partType;
  }

  public String getManufacturer(){
      return this.manufacturer;
  }

  public String getManufacturerPartNumber (){
      return this.manufacturerPartNumber ;
  }
  public BigDecimal getPrice(){
      return this.price;
  }
  public List<SparePart> getSpareParts(){
	  return this.spareParts;
  }

	public void setSpSpecId(Long spSpecId) {
		this.spSpecId = spSpecId;
	}
	
	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}
	
	public void setPartType(String partType) {
		this.partType = partType;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public void setManufacturerPartNumber(String manufacturerPartNumber) {
		this.manufacturerPartNumber = manufacturerPartNumber;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public void setSpareParts(List<SparePart> spareParts) {
		this.spareParts = spareParts;
	}
  
  
}

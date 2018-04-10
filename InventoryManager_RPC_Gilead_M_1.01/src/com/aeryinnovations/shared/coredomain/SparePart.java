package com.aeryinnovations.shared.coredomain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import net.sf.gilead.pojo.java5.LightEntity;


@Entity
public class SparePart extends LightEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//fields
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long sparePartId;
	
	@Basic
	private SparePartSpecification sparePartSpecification;
 
	//constructor
	public SparePart(){
		this.sparePartId = null;
		this.sparePartSpecification = new SparePartSpecification();
	}
  
	public SparePart(SparePartSpecification sparePartSpecification){
		this.sparePartId = null;
		this.sparePartSpecification = sparePartSpecification;
	}

	//methods

	//getter methods
	public Long getSparePartId(){
		return this.sparePartId;
	}

	public SparePartSpecification getSparePartSpecification (){
		return this.sparePartSpecification;
	}
}

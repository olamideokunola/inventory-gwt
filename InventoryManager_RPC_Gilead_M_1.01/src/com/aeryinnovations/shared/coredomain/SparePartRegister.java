package com.aeryinnovations.shared.coredomain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.aeryinnovations.shared.CheckSpecification;
import com.aeryinnovations.shared.Util;

import net.sf.gilead.pojo.java5.LightEntity;

@Entity
public class SparePartRegister extends LightEntity implements Serializable {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger rootLogger = Logger.getLogger("");
	//fields
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long sparePartRegisterId;
	
	@Basic
	private SparePartSpecification currentSparePartSpec;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SparePartSpecification> sparePartSpecs; 

 	//constructor
	public SparePartRegister(){}
	
	public SparePartRegister(List<SparePartSpecification> specs){
		this.sparePartSpecs = new ArrayList<SparePartSpecification>();
		this.loadSparePartSpecs(specs);
		this.currentSparePartSpec = null;
	}
	
 //methods

	public void loadSparePartSpecs(List<SparePartSpecification> specs){
		sparePartSpecs = specs;  
  	}
  
//getter methods
  	public SparePartSpecification getCurrentSparePartSpec (){
  		return this.currentSparePartSpec;
  	}
	
	public List<SparePartSpecification> getSparePartSpecifications() {
		return this.sparePartSpecs;
	}
	
	public SparePartSpecification getSparePartSpecification(String id) {
		SparePartSpecification specSearchResult = null;
		for (SparePartSpecification spec : this.getSparePartSpecifications()) {
			if(spec.getSpSpecId().toString().equals(id)) {
				specSearchResult = spec;
			}
		}
		return specSearchResult;
	}

	public Long getSparePartRegisterId() {
		return sparePartRegisterId;
	}

	public void setSparePartRegisterId(Long sparePartRegisterId) {
		this.sparePartRegisterId = sparePartRegisterId;
	}

	public List<SparePartSpecification> getSparePartSpecs() {
		return sparePartSpecs;
	}

	public void setSparePartSpecs(List<SparePartSpecification> sparePartSpecs) {
		this.sparePartSpecs = sparePartSpecs;
	}

	public void setCurrentSparePartSpec(SparePartSpecification currentSparePartSpec) {
		this.currentSparePartSpec = currentSparePartSpec;
	}
	
	
	//methods

	public Set<SparePartSpecification> findSparePartSpecifications(String idSearchStr, String descSearchStr, String typeSearchStr){
		Set<SparePartSpecification> searchResults = new HashSet<SparePartSpecification>();

		if(idSearchStr != null && idSearchStr != "") {
			Long id = Long.valueOf(idSearchStr);
			
			rootLogger.log(Level.INFO, "Long id: " + id);
			
			searchResults.addAll(Util.findUsingCriteria(this.getSparePartSpecifications(), 
			spec -> spec.getSpSpecId().equals(id)));
			
		}
		
		if(descSearchStr != null && descSearchStr != "") {

			rootLogger.log(Level.INFO, "descSearchStr: " + descSearchStr);
		
			searchResults.addAll(Util.findUsingCriteria(this.getSparePartSpecifications(), 
					spec -> Util.regionMatches(spec.getPartDescription(), descSearchStr)));

		}
		
		if(typeSearchStr != null && typeSearchStr != "") {

			rootLogger.log(Level.INFO, "typeSearchStr: " + typeSearchStr);
			
			searchResults.addAll(Util.findUsingCriteria(this.getSparePartSpecifications(),
					spec -> Util.regionMatches(spec.getPartType(), typeSearchStr)));
		}
		
		return searchResults;
		
	}

}



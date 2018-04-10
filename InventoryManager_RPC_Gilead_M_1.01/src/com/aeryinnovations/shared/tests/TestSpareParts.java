package com.aeryinnovations.shared.tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.aeryinnovations.shared.coredomain.*;

public class TestSpareParts {
	
	SparePartRegister spReg = new SparePartRegister();


	@Test
	public void testLoadSparePartSpecs() {
		
		//spReg.getSparePartSpecifications();
		
		assertTrue(spReg.getSparePartSpecifications().size() > 0);
		
		//fail("Not yet implemented");
	}

	
	@Test
	public void testFindSparePartSpecification() {
		//SparePartSpecification spSpec = new SparePartSpecification("Cardan shaft","Shaft","KHS","00123", new BigDecimal("100.0"));

		//spReg.getSparePartSpecifications().add(spSpec);
		//spReg.loadSparePartSpecs(specs);
		assertTrue(spReg.findSparePartSpecifications("1", "Bear", "Bear").size() > 0);
		
	}
}

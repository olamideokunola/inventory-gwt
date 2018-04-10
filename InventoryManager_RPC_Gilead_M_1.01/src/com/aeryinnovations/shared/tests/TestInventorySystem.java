package com.aeryinnovations.shared.tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.aeryinnovations.shared.coredomain.SparePartRegister;
import com.aeryinnovations.shared.coredomain.SparePartSpecification;

public class TestInventorySystem {

	SparePartRegister spReg = new SparePartRegister();
	
	@Test
	public void testGetSparePartSpec() {
		

		//SparePartSpecification spSpec = new SparePartSpecification("Cardan shaft","Shaft","KHS","00123", new BigDecimal("100.0"));
		//spSpec.persist();
			
		assertTrue(spReg.getSparePartSpecification("1") != null);
		
		//fail("Not yet implemented");
	}

}

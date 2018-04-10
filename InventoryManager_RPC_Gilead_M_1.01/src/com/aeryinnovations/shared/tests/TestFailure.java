package com.aeryinnovations.shared.tests;


import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import com.aeryinnovations.shared.coredomain.*;
import com.google.gwt.i18n.client.DateTimeFormat;

import junit.framework.TestCase;

public class TestFailure extends TestCase {

	@Test
	public void testloadEquipmentSpecifications() {
		//set up the test
		EquipmentRegister eqReg = new EquipmentRegister();
		
		//verify total number of equipment
		assertEquals(eqReg.getEquipmentSpecifications().size(),2);
		//fail("Not yet implemented");
	}

	@Test
	public void testloadSparePartsSpecifications() {
		//set up the test
		EquipmentRegister eqReg = new EquipmentRegister();
		
		//verify total number of equipment
		assertEquals(eqReg.getEquipmentSpecifications().size(),2);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testLoadChildLocations() {
		// setup  test
		
		Location loc = new Location("loc01", "loc01 description", "loctype01");
		
		Location childLoc1 = new Location("cloc01", "cloc01 description", "loctype01");
		Location childLoc2 = new Location("cloc02", "cloc02 description", "loctype01");
		
		loc.getChildLocations().add(childLoc1);
		loc.getChildLocations().add(childLoc2);
		
		loc.loadChildLocations();
		
		assertEquals(loc.getChildLocations().size(), 2);
		
	}

	@Test
	public void testCreateStockIssues() {
		//set up a new stock issue
		Date dt = new Date();
		dt = DateTimeFormat.getFormat("dd/mm/yyyy").parse("01/01/2017");
	
		StockIssue si = new StockIssue(dt, "Testing Issue 1");
		
		//add some line items
		BigDecimal price = new BigDecimal("10.50");
		price.setScale(2, BigDecimal.ROUND_HALF_UP);
		SparePartSpecification spec = new SparePartSpecification("Part 1 Description" , "partType01" , "manufacturer01", "pn001", price);
		SparePart sp1 = new SparePart(spec);
		spec = new SparePartSpecification("Part 2 Description" , "partType01" , "manufacturer01", "pn001", price);
		SparePart sp2 = new SparePart(spec);
		
		Location loc = new Location();
		Equipment eqmt = new Equipment();
		//si.createStockIssueLineItem(sp, loc, eqmt, qty, SIVNumber);
		si.createStockIssueLineItem(sp1, loc, eqmt, 1, "002");
		
		//ask for number of line items and verify the value
	}
	
}

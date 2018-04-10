package com.aeryinnovations.shared.tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.aeryinnovations.shared.Util;
import com.aeryinnovations.shared.coredomain.SparePartSpecification;

public class TestUtil {

	@Test
	public void testFindItemsInList() {
		
		List<SparePartSpecification> specList = new ArrayList<SparePartSpecification>();
		
		specList.add(new SparePartSpecification("SpareDescr1","test","SKF","001", new BigDecimal("10")));
		specList.add(new SparePartSpecification("SpareDescr2","test","SKF","002", new BigDecimal("20")));
		
		Map<String, String> searchStrMap = new HashMap<String, String>();
		searchStrMap.put("descr", "spare");
		searchStrMap.put("spareType", "test");
		
		//assertTrue(Util.findItemsInList(specList, searchStrMap).size() > 0);
		
		//fail("Not yet implemented");
	}

}

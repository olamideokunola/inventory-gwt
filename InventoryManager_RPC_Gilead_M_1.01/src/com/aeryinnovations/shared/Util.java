package com.aeryinnovations.shared;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import com.aeryinnovations.shared.coredomain.SparePartSpecification;

public class Util {
	public static List<SparePartSpecification> findUsingCriteria(List<SparePartSpecification> specs, Predicate<SparePartSpecification> tester) {
		List<SparePartSpecification> searchResults = new ArrayList<SparePartSpecification>();
		for(SparePartSpecification spec : specs) {
			if(tester.test(spec)) {
				searchResults.add(spec);
			}
		}
		return searchResults;
	}
	
	public static boolean regionMatches(String searchMe, String findMe) {	
		int searchMeLength = searchMe.length();
        int findMeLength = findMe.length();
        boolean foundIt = false;
        
        for (int i = 0; 
             i <= (searchMeLength - findMeLength);
             i++) {
           if (searchMe.regionMatches(true, i, findMe, 0, findMeLength)) {
              foundIt = true;
              break;
           }
        }
        
		return foundIt;
	}
}

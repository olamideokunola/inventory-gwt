package com.aeryinnovations.shared;

import com.aeryinnovations.shared.coredomain.SparePartSpecification;

public interface CheckSpecification {
	boolean test(SparePartSpecification spec, String criteria);
}

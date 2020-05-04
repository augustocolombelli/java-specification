package common.specification.impl;

import java.util.Collections;

import common.specification.Specification;
import common.specification.Specifications;

public class SpecificationsDefault implements Specifications {

	public <T> SpecificationValidatorDefault<T> of(Specification<T> specification) {
		return new SpecificationValidatorDefault<T>(Collections.singletonList(specification));
	}

	public <T> SpecificationValidatorDefault<T> of(Specification<T>... specifications) {
		return new SpecificationValidatorDefault<T>(specifications);
	}

}
package common.specification.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import common.specification.Specification;
import common.specification.SpecificationValidator;
import common.specification.Validation;

/**
 * Standard Validation Specification implementation of the used in Use
 * Cases. All validations are translated in a format that can used in 
 * basic use cases.
 *
 * 
 * @param <T> is the entity that is necessary to validate.
 */
public class SpecificationValidatorDefault<T> implements SpecificationValidator<T> {

	private List<Specification<T>> specifications;

	public SpecificationValidatorDefault(Specification<T>... specifications) {
		this.specifications = Arrays.asList(specifications);
	}

	public SpecificationValidatorDefault(List<Specification<T>> specification) {
		this.specifications = specification;
	}

	public void validate(T target) {
		List<SpecificError> errors = getErrors(target);
		if (errors.size() > 0) {
			throw new SpecificBusinessException(errors);
		}
	}

	private List<SpecificError> getErrors(T target) {
		List<SpecificError> errors = new ArrayList<>();
		for (Specification<T> specification : this.specifications) {
			List<Validation> validations = specification.validate(target).getAllValidations();
			if(validations != null && !validations.isEmpty()) {
				for(Validation validation : validations) {
					errors.add(new SpecificError(validation.getMessageTemplate(), validation.getMessageParameters()));
			
				}
			}
		}
		return errors;
	}

}
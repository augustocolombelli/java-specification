package common.specification.impl;

import java.util.List;

public class SpecificBusinessException extends RuntimeException {

	private List<SpecificError> errors;

	public SpecificBusinessException(List<SpecificError> errors) {
		this.errors = errors;
	}

	public List<SpecificError> getErrors() {
		return errors;
	}

}

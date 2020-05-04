package common.specification;

/**
 * Abstract class that must be inherited in simple validations based on
 * Specifications.
 * 
 * @param <T> the entity that will be applied for validation.
 */
public abstract class ValidationBase<T> implements Specification<T> {

	public Validations validate(T target) {
		Validations errors = new Validations();
		if (!isSatisfied(target)) {
			errors.addValidation(new Validation(getMessageTemplate(), getMessageParameters(target)));
		}
		return errors;
	}

	/**
	 * Default message parameters when not have defined parameters.
	 * 
	 * @param target 
	 * @return a list of empty object that is the parameters.
	 */
	protected Object[] getMessageParameters(T target) {
		return new Object[] {};
	}

	public abstract String getMessageTemplate();

	public abstract boolean isSatisfied(T target);

}
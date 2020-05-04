package common.specification;

/**
 * Execute validation of all validations at the end of the process.
 */
public interface SpecificationValidator<T> {

	void validate(T target);

}

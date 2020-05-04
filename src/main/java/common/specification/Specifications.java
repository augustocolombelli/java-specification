package common.specification;

/**
 * Options to execute the specifications validations. It can be executed only
 * one or also have the result of several specifications in a single execution.
 */
public interface Specifications {

	<T> SpecificationValidator<T> of(Specification<T> specification);

	<T> SpecificationValidator<T> of(Specification<T>... specifications);

}

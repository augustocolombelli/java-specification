package common.specification;

/**
 * Contract that must be implemented for each validation validated by the
 * Specification.
 * 
 * @param <T> the entity that Specification is applied.
 */
public interface Specification<T> {

	Validations validate(T target);

}
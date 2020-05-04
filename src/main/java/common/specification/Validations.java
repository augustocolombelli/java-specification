package common.specification;

import java.util.ArrayList;
import java.util.List;

/**
 * List with all object validations that have not passed validation.
 */
public class Validations {

	private List<Validation> listOfValidations;

	/**
	 * @return all validations that was added in a list of validations.
	 */
	public List<Validation> getAllValidations() {
		return listOfValidations;
	}

	/**
	 * Add a Validation in a list of validations.
	 * 
	 * @param validation
	 */
	public void addValidation(Validation validation) {
		if (listOfValidations == null) {
			listOfValidations = new ArrayList<Validation>();
		}
		this.listOfValidations.add(validation);
	}

}

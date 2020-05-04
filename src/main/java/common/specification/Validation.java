package common.specification;

/**
 * Entity that represents a validation contexts. It is a generic class used in
 * domain application, for to remove coupling with different entry points.
 * 
 * This object can converted in a infrastructure layer to represent error in
 * different contexts.
 */
public class Validation {

	private String message;
	private Object[] messageParameters;

	/**
	 * @param messageTemplate is the message of validation.
	 * @param messageParams   is the parameters that can be used in message.
	 */
	public Validation(String messageTemplate, Object[] messageParameters) {
		this.message = messageTemplate;
		this.messageParameters = messageParameters;
	}

	public String getMessageTemplate() {
		return message;
	}

	public Object[] getMessageParameters() {
		return messageParameters;
	}

}

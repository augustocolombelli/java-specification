package common.specification.impl;

public class SpecificError {

	private String message;
	private Object[] messageParameters;

	public SpecificError(String message, Object[] messageParameters) {
		this.message = message;
		this.messageParameters = messageParameters;
	}
	
	public String getMessage() {
		return message;
	}

	public Object[] getMessageParameters() {
		return messageParameters;
	}
	
}

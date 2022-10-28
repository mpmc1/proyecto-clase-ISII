package com.mipresupuesto.personalbudget.crosscuting.exceptions;
import static com.mipresupuesto.personalbudget.crosscuting.utils.UtilObject.getUtilObject;
import static com.mipresupuesto.personalbudget.crosscuting.utils.UtilText.trim;

public class GeneralException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -349723082969698830L;
	
	private String userMessage;
	private String technicalMessage;
	private Exception rootException;
	
	public static GeneralException build(String technicalMessage) {
		return new GeneralException(null, technicalMessage, null);
	}
	
	public static GeneralException build(String technicalMessage, Exception rootException) {
		return new GeneralException(null, technicalMessage, rootException);
	}
	
	
	protected GeneralException(String userMessage, String technicalMessage, Exception rootException) {
		super();
		setUserMessage(userMessage);
		setTechnicalMessage(technicalMessage);
		setRootException(rootException);
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getUserMessage() {
		return userMessage;
	}
	public String getTechnicalMessage() {
		return technicalMessage;
	}
	public Exception getRootException() {
		return rootException;
	}
	private void setUserMessage(String userMessage) {
		this.userMessage = trim(userMessage);
	}
	private void setTechnicalMessage(String technicalMessage) {
		this.technicalMessage = trim(technicalMessage);
	}
	private void setRootException(Exception rootException) {
		this.rootException = getUtilObject().getDefault(rootException,
				new Exception());
	}
	

}

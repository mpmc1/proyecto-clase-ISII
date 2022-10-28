package com.mipresupuesto.personalbudget.crosscuting.exceptions;

import static com.mipresupuesto.personalbudget.crosscuting.utils.UtilObject.getUtilObject;

import com.mipresupuesto.personalbudget.crosscuting.exceptions.enumeration.ExceptionLocation;
import com.mipresupuesto.personalbudget.crosscuting.exceptions.enumeration.ExceptionType;

public class BudgetException extends GeneralException {

	private BudgetException(String userMessage, String technicalMessage, Exception rootException, ExceptionType type,
			ExceptionLocation location) {
		super(userMessage, technicalMessage, rootException); 
		setType(type);
		setLocation(location);
	}

	public static BudgetException buildUserException(String userMessage) {
		return new BudgetException(userMessage, userMessage, null, ExceptionType.BUSINESS, null);
	}

	public static BudgetException buildTechnicalException(String technicalMessage) {
		return new BudgetException(null, technicalMessage, null, ExceptionType.TECHNICAL, null);
	}

	public static BudgetException buildTechnicalException(String technicalMessage, Exception rootException, ExceptionLocation location) {
		return new BudgetException(null, technicalMessage, rootException, ExceptionType.TECHNICAL, location);
	}
	
	public static BudgetException buildTechnicalDataException(String technicalMessage) {
		return new BudgetException(null, technicalMessage, null, ExceptionType.TECHNICAL, ExceptionLocation.DATA);
	}
	
	public static BudgetException buildTechnicalBussinessLogicException(String technicalMessage) {
		return new BudgetException(null, technicalMessage, null, ExceptionType.TECHNICAL, ExceptionLocation.BUSINESS_LOGIC);
	}
	
	public static BudgetException buildBussinessLogicException(String businessMessage) {
		return new BudgetException(businessMessage, null, null, ExceptionType.BUSINESS, ExceptionLocation.BUSINESS_LOGIC);
	}
	
	public static BudgetException buildTechnicalDataException(String technicalMessage, Exception rootException) {
		return new BudgetException(null, technicalMessage, rootException, ExceptionType.TECHNICAL, ExceptionLocation.DATA);
	}

	public static BudgetException build(String userMessage, String technicalMessage) {
		return new BudgetException(userMessage, technicalMessage, null, null, null);
	}

	public static BudgetException build(String userMessage, String technicalMessage, Exception rootException) {
		return new BudgetException(userMessage, technicalMessage, rootException, null, null);
	}

	private static final long serialVersionUID = 625249639280789375L;

	private ExceptionType type;
	private ExceptionLocation location;

	private void setType(ExceptionType type) {
		this.type = getUtilObject().getDefault(type, ExceptionType.GENERAL);
	}

	private void setLocation(ExceptionLocation location) {
		this.location = location;
	}
	
	public ExceptionLocation getLocation() {
		return location;
	}

	public ExceptionType getType() {
		return type;
	}

}

package mygss.framework.WebAutomation.exception;

public class APIException extends RuntimeException{

	private int errorCode;
	APIException() {
		
	}
	
	public APIException(String message) {
		super(message);
	}
	
	public APIException(Throwable cause) {
		super(cause);
	}
	public APIException(String message, Throwable cause) { 
		super(message, cause);
	}
	public APIException(int errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}
	public int getEprorCode(){
		return this.errorCode;
	}

}

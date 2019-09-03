package kh.java.exception;

public class UserFileNotFoundException extends Exception {
	public UserFileNotFoundException() {
		
	}
	public UserFileNotFoundException(String message) {
		super(message);
	}
	public UserFileNotFoundException(Throwable cause) {
		super(cause);
	}
	public UserFileNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}

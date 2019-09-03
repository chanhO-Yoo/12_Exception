package kh.java.exception;

/*
 * 커스텀 예외클래스 작성
 * 1. checkedException(예외 처리 강제화) : extends Exception
 * 2. uncheckedException : extends RuntimeException
 * 
 * 존재하는 jdk예외들보다 의미전달을 명확히 하기 위해
 * 커스텀 예외클래스를 작성한다.
 * 
 * 기존의 예외를 먼저 처리한 후 커스텀 예외객체를 다시 만들어 넘긴다.
 * 
 */
public class UnderAgeException extends RuntimeException{
	//constructor
	public UnderAgeException() {
		
	}
	public UnderAgeException(String message) {
		super(message);
	}
	public UnderAgeException(Throwable cause) {
		super(cause);
	}
	public UnderAgeException(String message, Throwable cause) {
		super(message,cause);
	}

}

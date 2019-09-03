package kh.java.error;

public class ErrorTest {
	public static void main(String[] args) {
		ErrorTest e = new ErrorTest();
//		e.test1();
//		e.test2();
	}
	
	//OuOofMemoryError : jvm이 할당받은 메모리 공간을 모두 소진
	public void test1() {
		long[] arr = new long[Integer.MAX_VALUE];
		
	}
	
	//StackOverflowError
	public void test2() {
		System.out.println("안녕");
		test2();
	}
}

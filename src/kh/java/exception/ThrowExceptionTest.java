package kh.java.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;

/*
 * 예외 던지기
 * 
 * 예외처리(try ... catch)하지 않고,
 * 메서드 호출부로 예외를 던지기
 * 
 * 예외 처리의 흐름
 *  1) 예외가 최초로 던져진 곳에서 예외처리 하기 : 최초 메서드 호출한 곳에서 알 수 없음.
 *  2) 최초 예외 처리 후 다시 예외 던지기
 *  3) 예외 처리를 하지 않고 예외 던지기
 *  
 * 예외 처리의 원칙
 *  - 예외처리는 최초 메서드를 호출한 쪽에서 한다.
 *  - 최초 메서드를 호출한 쪽에서 프로그램 제어권을 가지고 있어야 한다.
 * 
 */

public class ThrowExceptionTest {
	public static void main(String[] args) {
		ThrowExceptionTest t = new ThrowExceptionTest();
		try {
			t.test1();
			System.out.println("해당 파일을 가지고 정상적인 업무수행.");
		} catch(Exception e) {
//			System.out.println("해당 파일을 찾을 수 없습니다.");
			e.printStackTrace();
		}
		System.out.println("정상 종료 되었습니다.");
	}
	
	public void test1() throws FileNotFoundException, UserFileNotFoundException {
		System.out.println("--------- a start ---------");
//		try {
//			test2();
//		} catch(FileNotFoundException e)) {
//			
//		}
		
		test2();
		System.out.println("---------- a end ----------");
	}
	
	/*
	 * 메서드 바디에서 던져진 예외가 checked라면,
	 * 메서드 선언부에 throws절을 반드시 작성해야 한다.
	 * 
	 */
	
	public void test2() throws FileNotFoundException, UserFileNotFoundException {
		System.out.println("--------- b start ---------");
		
		// 1. uncheckedException : 예외처리 강제화 없음
//		try {
//			Scanner sc = new Scanner(System.in);
//			System.out.print("정수 입력 : ");
//			int num = sc.nextInt();
//			System.out.println("num = "+num);
//		} catch(InputMismatchException e) {
//			System.out.println("정수를 입력하세요.");
//		}
		
		// 2. checkedException : 예외처리 강제화
		// FileReader의 생성자 메서드는 
		// FileNotFoundException(checked)를 유발한다.
		// 예외처리 반드시 해야한다. 아니면 컴파일 오류 발생.
		try {
			FileReader fr = new FileReader("test.txt");
		} catch(FileNotFoundException e) {
			throw new UserFileNotFoundException("파일이 존재하지 않습니다.", e);
//			System.out.println("파일이 존재하지 않습니다.");
//			throw e; //처리한 예외를 다시 던진다.
		}
		
		FileReader fr = new FileReader("test.txt");
		
		
		System.out.println("---------- b end ----------");
	}
}

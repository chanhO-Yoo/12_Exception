package kh.java.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {
	
	private Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		ExceptionTest e = new ExceptionTest();
//		e.test1();
		
//		e.test2();
		
//		e.test3(null);
		
//		e.test4();
		
		e.test5();
		System.out.println("프로그램이 정상 종료 되었습니다.");
	}
	
	public void test1() {
		try {
			System.out.print("정수를 입력하세요 : ");
			int num = sc.nextInt();
			System.out.println("100을 "+num+"으로 나눈 몫 : "+(100/num));
		} catch(ArithmeticException e) {
			System.out.println("0은 입력하실수 없습니다.");
			
			//예외 관련 스택추적
//			e.printStackTrace();
			//예외 메시지만 출력
			System.out.println(e.getMessage());
		} catch(InputMismatchException e) {
			System.out.println("정수만 입력하실 수 있습니다.");
			sc.next();//버퍼 비우기용 : 처음 입력한 값이 버퍼에 저장되어 있다.
		}
	}
	
	public void test2() {
		System.out.println(1);
		try {
			System.out.println(2);
			System.out.println(100/0); // ArithmeticException 발생
			System.out.println(3);
		} catch(ArithmeticException e) {
			System.out.println(4);
		}
		System.out.println(5);
	}
	
	public void test3(String s) {
		try {
			//1. uncheckedException : 예외처리 강제화 없음, RuntimeException의 후손
			int a[] = new int[3];
			System.out.println(a[10]);
			
			System.out.println(s.hashCode());
			
			//2. checkedException : 예외처리 강제화, RuntimeException의 후손 아님
			try {
				new FileReader("abc.txt");
			} catch(FileNotFoundException e) {
				
			}
			
		} catch(NullPointerException e) {
			System.out.println(e.getMessage());
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) { // 다형성에 따라서 부모 자식 관계일 경우 부모가 밑에 오게 작성
			System.out.println("Exception이 발생했습니다.");
		}
	}
	
	// @실습문제 : 
	// 사용자로부터 2개의 정수를 입력받아 합을 출력
	// 반복적으로 처리되도록 구현
	// 사용자 부정입력에 대해서는 예외 처리할 것.
	public void test4() {
		char input = 'y';
		while(input=='y') {
			try {
					System.out.print("1번째 정수를 입력하세요 : ");
					int input1st = sc.nextInt();
					System.out.print("2번째 정수를 입력하세요 : ");
					int input2nd = sc.nextInt();
				
					System.out.println("두 정수의 합은 "+(input1st+input2nd)+"입니다.");
					
					System.out.print("다시 입력하시겠습니까? (Y/N) : ");
					input = sc.next().toLowerCase().charAt(0);
				
			} catch(InputMismatchException e) {
				System.out.println("정수를 입력하세요.");
				sc.next();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//finally : 예외 발생 여부와 상관없이 무조건 실행될 구문
	//try ... cathc문 마지막에 사용
	//사용한 자원 반납등을 위해 finally 사용
	public void test5() {
		System.out.println(1);
		try {
			System.out.println(2);
//			System.out.println(100/0); // ArithmeticException
			System.out.println(3);
			
			return; //현재 메서드를 호출한 곳으로 돌아감, finally는 작동하고 넘어간다
		} catch(Exception e) {
			System.out.println(4);
		} finally {
			System.out.println(5);
		}
		System.out.println(6);
		
	}
}

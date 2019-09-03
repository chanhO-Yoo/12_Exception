package kh.java.exception;

import java.util.Scanner;

public class GameTest {
	public static void main(String[] args) {
		GameTest g = new GameTest();
		g.start();
		System.out.println("프로그램이 정상 종료되었습니다.");
	}
	
	public void start() {
		try {
			checkAge();
			System.out.println("게임을 시작합니다.");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public void checkAge() /*throws Exception*/ {
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		
		if(age < 20) {
			throw new UnderAgeException("적정연령이 아닙니다 - "+age);
//			throw new Exception("적정연령이 아닙니다."); //checkedException
		}
	}
}

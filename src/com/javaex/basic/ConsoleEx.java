package com.javaex.basic;

import java.util.Scanner;

public class ConsoleEx {

	public static void main(String[] args) {
		consoleOutputEx();
		consoleInputEx();
	}
	
	public static void consoleOutputEx() {
		// System.out : 표준 출력
		// System.err : 표준 에러
		//		print : 개행 안함
		//		println : 개행
		//		printf : formating 출력 -> String에서 정리
		
		System.out.print("Hello ");		// 개행 안함
		System.out.println("Java");		// 개행 함
		
		// 이스케이프 문자
		System.out.println("Hello\nJava");	// \n: 개행 문자
		System.out.println("Hello\tJava");	// \t: 탭문자
		
		String message = "Hello, \"Java\"";	// \": 따옴표
		System.out.println(message);
		
		// 윈도우의 경우, 경로 구분자가 \
		String filename = "C:\\myfolder\\myfile.txt";	// \\ -> \
		System.out.println(filename);
	}
	
	public static void consoleInputEx() {
		Scanner scanner = new Scanner(System.in);	// 표준 입력을 입력 소스로 설정
		
		// 이름과 나이를 입력 받아서 출력
		System.out.print("이름은? ");
		String name = scanner.next();	// 문자열 입력
		System.out.print("나이는? ");
		int age = scanner.nextInt();	// 정수 입력
		
		System.out.println("이름은 " + name + "나이는 " + age);
		
		// 시스템은 반드시 닫아 줄 것
		scanner.close();
	}
}

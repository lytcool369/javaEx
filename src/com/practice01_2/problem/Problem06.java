package com.practice01_2.problem;

import java.util.Scanner;

public class Problem06 {

	public static void main(String[] args) {
		// [문제] 다음과 같은 프로그램을 작성하세요 
		// a. 입력 받은 숫자가 홀수인 경우에는, 입력 값까지 홀수의 합을 출력합니다.
		// - 예) 입력이 7 이면 16을 출력 ( 1 + 3 + 5 + 7 = 16 )
		// b. 입력 받은 숫자가 짝수인 경우에는, 입력 값까지 짝수의 합을 출력합니다.
		//  - 예) 입력이 10 이면 30을 출력 ( 2 + 4 + 6 + 8 + 10 = 30 ) 
		Scanner scanner = new Scanner(System.in);
		int num = 0;
		int result = 0;
		
		System.out.println("숫자를 입력하세요");
		num = scanner.nextInt();
		
		if (num % 2 == 1) {
			for (int i = 1; i <= num; i += 2) {
				result += i;
			}
		} else {
			for (int j = 2; j <= num; j += 2) {
				result += j;
			}
		}
		System.out.println("결과값: " + result);
	}

}

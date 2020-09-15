package com.practice01_1.problem;

import java.util.Scanner;

public class Problem05 {
	
	public static void main(String[] args) {
		// [문제] 정수 다섯개를 입력받아 가장 큰 수를 출력하세요.
		Scanner scanner = new Scanner(System.in);
		int[] num = new int[5];
		int result = 0;
		
		System.out.println("숫자를 입력하세요");
		
		for (int i = 0; i < 5; i++) {
			System.out.print("숫자: ");
			num[i] = scanner.nextInt();
			
			if (i >= 1 && num[i] > num[i - 1]) {
				result = num[i];
			}
		}
		System.out.println("최대값은 " + result + "입니다.");
	}
}

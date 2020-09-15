package com.practice01_1.problem;

import java.util.Scanner;

public class Problem02 {

	public static void main(String[] args) {
		// [문제] 숫자를 입력받아 아래와 같이 출력하세요 
		// 입력한 숫자의 개수만큼의 라인수, 피라미드 모양
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요");
		int num = scanner.nextInt();
		
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= i; j++ ) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}

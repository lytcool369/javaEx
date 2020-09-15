package com.practice01_1.problem;

public class Problem04 {

	public static void main(String[] args) {
		// [문제] 다음과 같이 출력하세요 
		// 대각선으로 숫자가 같고, 사각형 모양으로 숫자 19까지 출력
		for (int i = 1; i <= 10; i++) {
			for (int j = i; j < i + 10; j++) {
				System.out.print(j + "\t");
			}
			System.out.println();
		}

	}

}

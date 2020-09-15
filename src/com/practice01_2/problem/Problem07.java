package com.practice01_2.problem;

import java.util.Scanner;

public class Problem07 {

	public static void main(String[] args) {
		// [문제] 아래와 같이 숫자 맞추기 프로그램을 작성하세요
		/*	숨겨진 숫자를 맞추는 게임입니다.
			프로그램이 실행되면 1~100 사이의 숫자가 결정됩니다.
			사용자가 입력한 숫자가 결정된 숫자보다 높으면 “더 낮게” 출력
			사용자가 입력한 숫자가 결정된 숫자보다 낮으면 “더 높게” 출력 되며
			정답을 맞춘경우 “맞았습니다.” 출력됩니다.
			게임을 반복하기 위해 y/n이라 묻고 n인 경우 종료됩니다.
			(y 인경우 다시 게임이 시작됩니다.) */
		Scanner scanner = new Scanner(System.in);
		int num = (int) (Math.random() * 100 + 1);
		int select = 0;
		String over = "n";
		
		System.out.println("======================================");
		System.out.println("	   [숫자맞추기게임 시작]				");
		System.out.println("======================================");
		
		while (true) {
			System.out.print(">>");
			select = scanner.nextInt();
			
			if (select == num) {
				System.out.println("맞았습니다.");
				System.out.print("게임을 종료하시겠습니까?(y/n) >>");
				over = scanner.next();
				
				if (over.equals("y")) {
					break;
				} else if (over.equals("n")) {
					num = (int) (Math.random() * 100 + 1);
				} else {
					System.out.println("잘못된 입력입니다. 게임을 종료합니다.");
					break;
				}
			} else if (select > num) {
				System.out.println("더 낮게");
			} else {
				System.out.println("더 높게");
			}
		}
		
		System.out.println("======================================");
		System.out.println("	   [숫자맞추기게임 종료]				");
		System.out.println("======================================");
	}
}

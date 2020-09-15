package com.javaex.oop.staticmember;

public class SingletonApp {

	public static void main(String[] args) {
//		Singleton s1 = new Singleton();		// 오류: 생성자가 private
		Singleton s1 = Singleton.getInsSingleton();
		Singleton s2 = Singleton.getInsSingleton();
		
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
		
		System.out.println("s1 == s2 ? " + (s1 == s2));		// 두 객체는 동일 객체임
															// 여러 곳에서 하나의 자원을 관리하기 위해 사용
		
		s1.getScores()[5] = 80;
		System.out.println("s2[5] == " + s2.getScores()[5]);
	}
}

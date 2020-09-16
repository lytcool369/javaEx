package com.javaex.api.objectclass.v2;

public class LangClassTest {

	public static void main(String[] args) {
		Point p1 = new Point(10, 20);
		System.out.println("p1: " + p1);
		
		Point p2 = p1.getClone();	// p1을 복제 -> p2 를 생성
		System.out.println("p2: " + p2);
		System.out.println("p1 == p2 ? " + (p1 == p2));
		
		p2.setX(30);
		p2.setY(40);
		
		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
	}

}

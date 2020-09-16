package com.javaex.api.objectclass.v3;

public class LangClassTest {

	public static void main(String[] args) {
		Point p1 = new Point(10, 20);
		Point p2 = new Point(10, 20);
		
		System.out.println("p1 == p2 ? " + (p1 == p2));
		System.out.println("p1.equals(p2) ? " + p1.equals(p2));
	}

}

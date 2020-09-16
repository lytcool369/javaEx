package com.javaex.oop.point.v4;

public class PointApp {

	public static void main(String[] args) {
		ColorPoint cp1 = new ColorPoint(10, 20, "red");
		cp1.draw();
		System.out.println("\n");
		
		ColorPoint cp2 = new ColorPoint(20, 50);
		cp2.draw();
		System.out.println("");
		
		cp1.draw(true);
		cp1.draw(false);
		System.out.println("");
		
		cp2.draw(true);
		cp2.draw(false);
		System.out.println("");
	}
}

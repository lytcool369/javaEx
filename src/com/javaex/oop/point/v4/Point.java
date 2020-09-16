package com.javaex.oop.point.v4;

// v3. 매서드 오버로딩
//		같은 이름, 같은 리턴 타입을 가진다.
//		하지만 인수의 갯수, 순서로 구별되는 매서드
public class Point {
	// 필드
	protected int x;	// 자식 클래스에는 허용
	protected int y;
	
	// 생성자
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		
		System.out.println("Point의 생성자 호출");
	}
	
	// Getter / Setter
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	// 매서드
	public void draw() {
		System.out.printf("점[x=%d, y=%d]을 그렸습니다.%n", x, y);
	}
	
	// 매서드 오버로딩
	public void draw(boolean bDraw) {
		String message = String.format("점[x=%d, y=%d]을", x, y);
//		if (bDraw) {
//			message += " 그렸습니다!";
//		} else {
//			message += " 지웠습니다!";
//		}
		message += bDraw ? " 그렸습니다!": " 지웠습니다!";
		
		System.out.println(message);
	}
}

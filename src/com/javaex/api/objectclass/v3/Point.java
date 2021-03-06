package com.javaex.api.objectclass.v3;

// Object 클래스
// v3. 얕은 복제
public class Point {
	// 필드
	protected int x;	// 자식 클래스에는 허용
	protected int y;
	
	// 생성자
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
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

		message += bDraw ? " 그렸습니다!": " 지웠습니다!";
		
		System.out.println(message);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point other = (Point)obj;
			
			return x == other.x && y == other.y;
		}
		return super.equals(obj);
	}
}

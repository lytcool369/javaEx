package com.javaex.oop.point.v4;

// v4. Point 클래스를 상속받은 자식 클래스
public class ColorPoint extends Point{
	private String color;
	
	// 생성자
	public ColorPoint(int x, int y) {
		// 명시하지 않으면 javac가 부모의 기본 생성자를 임의로 추가
		super(x, y);
		System.out.println(this.getClass().getSimpleName() + "의 생성자(x, y)");
	}

	public ColorPoint(int x, int y, String color) {
		this(x, y);
		this.color = color;
		System.out.println(this.getClass().getSimpleName() + "의 생성자(x, y, color)");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	// 부모 Point는 draw 메서드를 가지고 있다
	@Override
	public void draw() {
		if (color != null) {
			// Error: x, y는 Point(부모)의 private
//			System.out.printf("색깔점[x=%d, y=%d, color=%s]을 그렸습니다", x, y, color);
			
			// 1. getter 이용 접근 (private 접근 가능)
//			System.out.printf("색깔점[x=%d, y=%d, color=%s]을 그렸습니다", super.getX(), super.getY(), color);
			
			// 2. 부모 클래스의 자료를 protected(자식 클래스는 허용)
			System.out.printf("색깔점[x=%d, y=%d, color=%s]을 그렸습니다", x, y, color);
		} else {
			super.draw();
		}
	}

	@Override
	public void draw(boolean bDraw) {
		// 연습 : Point 클래스의 draw(boolean) 메서드를 오버라이드 해 봅시다
		if (color != null) {
			String message = String.format("점[x=%d, y=%d, color=%s]을", x, y, color);
//			if (bDraw) {
//				message += " 그렸습니다!";
//			} else {
//				message += " 지웠습니다!";
//			}
			message += bDraw ? " 그렸습니다!": " 지웠습니다!";
			
			System.out.println(message);
		} else {
			super.draw(bDraw);
		}
	}
}

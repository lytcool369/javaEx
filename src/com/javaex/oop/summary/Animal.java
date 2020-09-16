package com.javaex.oop.summary;

// 설계도로서의 의미
// 추상 클래스 -> new로 인스턴스화 할 수 없다.
// 추상 클래스는 일반 메서드, 추상 메서드를 모두 가질 수 있다.
public abstract class Animal {
	// Field
	protected String name;
	
	// 생성자
	public Animal(String name) {
		this.name = name;
	}
	
	// 메서드
	public void eat() {
		System.out.println(name + "는(은) 먹고 있습니다.");
	}
	
	// 메서드
	public void walk() {
		System.out.println(name + "는(은) 산책합니다.");
	}
	
	// 추상 메서드
	public abstract void say();
}

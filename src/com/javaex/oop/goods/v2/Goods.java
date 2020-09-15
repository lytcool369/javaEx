package com.javaex.oop.goods.v2;

// v2. 정보 은닉
public class Goods {
	// Fields
	private String name;
	private int price;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		// this -> 현재 인스턴트 그 자체
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void showInfo() {
		System.out.println("상품명: " + name);
		System.out.println("가격: " + price);
	}
}
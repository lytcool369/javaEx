package com.javaex.api.collection.generic.v1;

public class BoxApp {

	public static void main(String[] args) {
		// Box 만들고, 데이터 세팅
		Box<Integer> intBox = new Box<>();	// <>: 한쪽에 타입을 지정해주면, 다른한쪽은 명시하지 않아도 된다.
		intBox.setContent(2020);
//		intBox.setContent("Java");	// Integer 타입이 아니므로, 컴파일 단계에서 체크되어 에러
		
		// 값을 꺼내오기
		int retVal = intBox.getContent();
		System.out.println("내용물: " + retVal);
		
		Box<String> strBox = new Box<>();
		strBox.setContent("Java");

		// Generic을 이용하면 안전하고, 캐스팅이 필요없어 편리
		String content = strBox.getContent();
		System.out.println("strBox의 내용물: " + content);
	}
}

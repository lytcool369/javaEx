package com.javaex.api.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListEx {

	public static void main(String[] args) {
		// List -> interfave
		// LinkedList -> 실제 클래스
		List<String> lst1 = new LinkedList<>();		// 삽입, 삭제가 자유로움
		List<String> lst2 = new ArrayList<>();		// 삽입, 삭제 시에 성능이 조금 떨어질 수 있다. (삽입.삭제 시, 밀거나 당기기 때문)
		listTest(lst2);
	}
	
	private static void listTest(List<String> lst) {
		// 객체의 추가: add
		lst.add("Java");
		lst.add("C");
		lst.add("C++");
		lst.add("Python");
		
		System.out.println("lst: " + lst);
		
		// 삽입
		lst.add(2, "C#");
		
		// 값의 중복을 허용
		lst.add("Java");
		System.out.println("lst: " + lst);
		
		// 객체 삭제
		lst.remove(2);			// 인덱스로 삭제
		lst.remove("Java");		// 객체 삭제
		System.out.println("lst: " + lst);
		
		// List, Set에서는  Interator를 사용
		Iterator<String> it = lst.iterator();
		
		while (it.hasNext()) {
			// 뒤에 더 있으면
			String item = it.next();
			System.out.println("item: " + item);
		}
		
		// 비우기
		lst.clear();
		System.out.println("lst: " + lst);
	}

}

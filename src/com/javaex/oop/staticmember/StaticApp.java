package com.javaex.oop.staticmember;

public class StaticApp {

	public static void main(String[] args) {
		StaticEx s1 = new StaticEx();
		// static 영역은 인스턴스화 하지 않아도 접근 가능
		System.out.println("참조 카운트: " + StaticEx.refCount);
		System.out.println();
		
		StaticEx s2 = new StaticEx();
		System.out.println("참조 카운트: " + StaticEx.refCount);
		System.out.println();
		
		s1 = null;	// 참조 해제
		System.out.println("s1 참조 해제");
		System.out.println("참조 카운트: " + StaticEx.refCount);
		System.out.println();
		
		// 갈비지 컬렉터가 수집해준다
		System.gc();	// 갈비지 컬렉터 강제 수행 (가급적 사용 X, 스테틱을 배우기 위해 사용함)
		try {
			Thread.sleep(3000);		// 3초 대기
			System.out.println("참조 카운트: " + StaticEx.refCount);
		} catch (Exception e) {
			
		}
	}
}

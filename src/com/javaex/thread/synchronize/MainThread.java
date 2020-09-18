package com.javaex.thread.synchronize;

public class MainThread {

	public static void main(String[] args) {
		SharedMemory memory = new SharedMemory();
		
		// 첫 번째 쓰레드
		User user1 = new User("홍길동", memory, 100);
		User user2 = new User("임꺽정", memory, 50);
		
		user1.start();
		user2.start();
		
		// 서브 쓰레드의 제어를 위해서
		// 서브 쓰레드의 흐름을 메인쓰레드에 연결
		try {
			user1.join();
			user2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("MainThread 종료");
	}
}

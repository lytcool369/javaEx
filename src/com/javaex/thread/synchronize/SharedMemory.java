package com.javaex.thread.synchronize;

// 여러 쓰레드가 공용으로 사용할 객체
public class SharedMemory {
	// 필드
	private int memory;

	public int getMemory() {
		return memory;
	}
	
	// synchronized 키워드를 메서드에 사용하면
	// 다른 객체가 사용 중에는 Lock이 걸린다
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(1000);		// 1초 대기
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ": " + this.memory);
	}
}

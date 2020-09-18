package com.javaex.io;

import java.io.File;
import java.io.IOException;

public class FileClassEx {
	private static String rootPath = System.getProperty("user.dir") + "\\files\\";
	
	// File 객체는 IO 작업을 수행하지는 않음 -> Stream이 처리
	public static void main(String[] args) {
		// 파일 객체
		File root = new File(rootPath);		// 파일 정보 클래스
		
		// 파일 존재 여부를 확인
		System.out.println(rootPath + ": " + root.exists());
		
		printInfo(root);
		
		// 디렉토리 생성
		if(!root.exists()) {
			root.mkdirs();
		}
		
		// 디렉토리 내에 파일 생성
		File myFile = new File(rootPath + "myFile.txt");	// 파일이 생성되지는 않음
		if(!myFile.exists()) {
			try {
				myFile.createNewFile();		// 파일 생성
			} catch(IOException e) {
				System.err.println("파일 생성 실패");
			}
		}
		
		printInfo(root);	// myFile.txt 가 생긴 것을 확인
		
		// 파일 지우기
		myFile.delete();	// 파일 삭제
		printInfo(root);	// myFile.txt 가 지워진 것을 확인
	}
	
	private static void printInfo(File f) {
		System.out.println("=================== printInfo =======================");
		
		if(f.isDirectory()) {	// f가 디렉토리일 때,
			System.out.println("Directory: " + f.getName());
			
			// 목록 출력
			File[] files = f.listFiles();
			
			for(File file:files) {
				System.out.print(file.isDirectory() ? "[d]": "[f]");
				System.out.println(file.getName());
			}
		} else {
			System.out.println("File: " + f.getName());
		}
	}
}

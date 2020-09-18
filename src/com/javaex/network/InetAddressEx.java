package com.javaex.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressEx {

	public static void main(String[] args) {
		try {
			// 내 아이피 확인
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("Local IP Address: " + local.getHostAddress());
			
			// Google.com 의 IP확인
//			String domain = "www.google.com";
			String domain = "www.naver.com";
			InetAddress[] adres = InetAddress.getAllByName(domain);
			
			for (InetAddress remote: adres) {
				System.out.println(domain + " IP Address: " + remote.getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}

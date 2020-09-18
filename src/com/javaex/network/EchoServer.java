package com.javaex.network;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) {
		// 서버 소켓
		ServerSocket serverSocket = null;
		
		try {
			// 바인드: 주소 연결
			serverSocket = new ServerSocket();
			InetSocketAddress local = new InetSocketAddress("127.0.0.1", 10000);
			serverSocket.bind(local);
			
			System.out.println("<서버 시작>");
			System.out.println("[서버]: 연결을 기다립니다.");
			
			while (true) {
				// 대기 및 통신용 소켓 얻어오기
				Socket socket = serverSocket.accept();	// 대기 상태
				
				// 서버 쓰레드 생성
				Thread thread = new ServerThread(socket);
				thread.start();
			}

			
/*			 -- 쓰레드 담당 코드(시작)
			// 클라이언트 접속 시 처리
			InetSocketAddress socketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			
			System.out.println("[서버: 클라이언트가 연결되었습니다.]");
			System.out.println("접속 클라이언트 정보: " + socketAddress.getAddress()
													+ ": " + socketAddress.getPort());
			
			// 메시지 수신
			InputStream is = socket.getInputStream();
			Reader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			// 출력용 Stream 파이프
			OutputStream os = socket.getOutputStream();
			Writer osw = new OutputStreamWriter(os, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			
			// 메시지 읽고 Echo Back
			while(true) {
				String msg = br.readLine();
				
				if (msg == null) {
					// 접속 종료
					System.out.println("[서버: 클라이언트 접속이 종료되었습니다.)");
					break;
				}
				
				System.out.println("[서버: 전송된 메시지] " + msg);
				// Echo Back
				System.out.println("[서버: Echo Back]");
				bw.write("[Echo Message] " + msg);
				bw.newLine();
				bw.flush();
			}
			
			bw.close();
			br.close();
			
			System.out.println("<서버가 종료되었습니다.>");
			 -- 쓰레드 담당 코드(끝) */

			
		} catch (IOException e ) {
			e.printStackTrace();
		} finally {
			// 소켓 닫기
			try {
				serverSocket.close();
			} catch (IOException e) {
				
			}
		}
	}
}

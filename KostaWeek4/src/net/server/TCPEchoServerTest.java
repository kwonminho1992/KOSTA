package net.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

//Server
public class TCPEchoServerTest {

	public static void main(String[] args) {
		int port = 5432; // port번호 설정
		ServerSocket ss = null; // server의 socket 생성
		String clientIP = null;
		try {
			// 1. port 열기
			ss = new ServerSocket(port);
			// 2. client를 기다리기
			while (true) { // client를 하나만 받지 않고 계속 받기 (서버는 계속 활성화상태)
				Socket s = null; // client의 socket
				DataInputStream dis = null;
				DataOutputStream dos = null;
				try {
					s = ss.accept(); // client와 server 연결
					InetAddress client = s.getInetAddress();
					clientIP = client.getHostAddress(); // client의 ip주소 알아내기
					dis = new DataInputStream(s.getInputStream()); // client에서 보낸 데이터를 읽기위한 stream 생성
					dos = new DataOutputStream(s.getOutputStream()); //client에게 메시지 보내기
					String recievedData = "";
					do {
						recievedData = dis.readUTF(); // client에서 보낸 메시지 받기
						System.out.println(recievedData + " from client " + clientIP);
						dos.writeUTF(recievedData); // client에게서 받은 메시지 다시 client로 보내기
					} while (!recievedData.equals("quit")); // client가 quit를 입력하기 전까지 계속 메시지를 받기
					
				//client와 연결과 관련된 예외처리
				} catch (SocketException e) { // client가 quit 입력으로 연결을 끊은 것이 아니라, 강제종료시킨 경우
					// 예외 메시지 불필요 
				} catch (IOException e) {
					// 예외 메시지 불필요
				} finally {
					if (s != null) {
						try {
							s.close(); // client socket 닫기
						} catch (IOException e) {
							// 예외 메시지 불필요
						}
					}
					System.out.print(clientIP != null? clientIP: "클라이언트");
					System.out.println("와의 연결을 종료합니다.");
				}
			}
		//server socket 객체 생성 시의 예외처리
		} catch (BindException e) { // * 같은 port번호를 같은 프로토콜로 두번 사용하면 java.net.BindException이 발생
			System.out.println("ERROR : " + port + " port가 이미 사용중입니다.");
		} catch (SocketException e) { // client가 quit 입력으로 연결을 끊은 것이 아니라, 강제종료시킨 경우
			// 예외 메시지 불필요 
		} catch (IOException e) {
			// 예외 메시지 불필요
		} finally {
			if (ss != null) {
				try {
					ss.close(); // server socket 닫기
				} catch (IOException e) {
					// 예외 메시지 불필요
				}
			}
		}
	}
}

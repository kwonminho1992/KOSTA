package net.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

//Client
public class TCPClientTest {

	public static void main(String[] args) {
		String serverIP = "192.168.0.16"; //127.0.0.1 - 네트워크가 끊겨도 나혼자는 쓸 수 있는 ip
		int serverPort = 1004; // server's port number
		Socket s = null; // client용 socket 생성
		Scanner scanner = new Scanner(System.in);
		DataOutputStream dos = null;
		try {
			s = new Socket(serverIP, serverPort);
			dos = new DataOutputStream(s.getOutputStream()); // client의 데이터 보내기용 stream 생성 
			String str = "";
			do {
				str = scanner.nextLine();
				dos.writeUTF(str); // server쪽으로 메시지 보내기
			}
			while (!str.equals("quit")); // quit를 입력하기 전까지 계속 server쪽으로 메시지 보내기
			
		} catch (UnknownHostException e) { // host이름 or IP주소가 잘못되었을때 발생하는 예외 ex. 127.0.0..1
			System.out.println("ERROR : IP주소 호스트명이 잘못되었습니다.");
		} catch (ConnectException e) { // 연결이 잘 안됬을 경우 (ex. 부적절한 port번호) 
			System.out.println("ERROR : 서버와의 연결이 되지 않습니다.");
		} catch (SocketException e) { // ConnectException의 부모 Exception이므로 ConnectException의 뒤에 위치 
			System.out.println("ERROR : 소켓이 끊겼습니다. 서버에 장애가 있는지 확인하세요");
		} catch (IOException e) {
			// 예외 메시지 불필요
		} finally {
			System.out.println("Server와의 연결을 종료합니다.");
		}
	}
}

package net.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//// TCPMultiClientTest 따라 치기 연습


//서버로부터 데이터를 읽는 스레드
class ReadThread extends Thread {
	//field
	Socket socket = null;
	DataInputStream dis = null;
	public ReadThread (Socket socket) throws IOException {
		this.socket = socket; // 클라이언트의 소켓 사용
		dis = new DataInputStream(socket.getInputStream());
	}
	
	public void run() {
		String data = "";
		try {
			while (!(data = dis.readUTF()).equals("quit")) {
				System.out.println(data + "from SERVER");
			}
		} catch (IOException e) {
			System.out.println("IOException (read)");					
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					System.out.println("IOException (read close)");	
				}
			}
		}
	}
}

public class TCPMultiClientStudy {

	public static void main(String[] args) {
		String IPOfServer = "127.0.0.1"; //서버로 접속할 내 IP주소
		int port = 5432; // 서버의 포트번호
		Socket socket = null; // 클라이언트 측의 소켓
		Scanner scanner = new Scanner(System.in);
		DataOutputStream dos = null;
		
		try {
			socket = new Socket(IPOfServer, port); // 소켓 생성
			dos = new DataOutputStream(socket.getOutputStream());
			//읽기thread
			//서버에서 메시지 받기
			ReadThread t = new ReadThread(socket);
			t.start();
			
			//서버로 메시지보내기
			String str = "";
			while (!(str = scanner.nextLine()).equals("quit")) {
				str = scanner.nextLine();
				dos.writeUTF(str); // 서버로 메시지 보내기
			}
			
			
		} catch (UnknownHostException e) {
			System.out.println("UnknownHostException in client");
				
		} catch (IOException e) {
			System.out.println("IOException in client");
		} finally {
			if (socket != null) { // NullPointerException 피하기
				try {
					socket.close();
				} catch (IOException e) {
					System.out.println("IOException in client (close)");
				}
			}
			System.out.println("서버와의 연결 종료");
		}
	}
}

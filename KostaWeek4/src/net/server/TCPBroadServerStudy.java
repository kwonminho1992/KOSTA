package net.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

// TCPBroadServerTest 따라 치기 연습


class BroadThread extends Thread {
	Socket clientSocket = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;
	List<BroadThread> threads; // thread들을 모아놓는 리스트
	InetAddress clientIP = null;
	String IPAddress = null;
	
	public BroadThread(Socket clientSocket, List<BroadThread> threads) throws IOException {
		this.clientSocket = clientSocket;
		this.threads = threads;
		clientIP = clientSocket.getInetAddress(); // IP address
		IPAddress = clientIP.getHostAddress();
		dis = new DataInputStream(clientSocket.getInputStream());
		dos = new DataOutputStream(clientSocket.getOutputStream());
		broadcasting(IPAddress + " 가 접속하였습니다");
	}
	
	public void broadcasting(String message) {
		for (int i = 0; i < threads.size(); i++) {
			BroadThread thread = threads.get(i);
			try {
				thread.dos.writeUTF(IPAddress + ">" + message);
			} catch (IOException e) {
				System.out.println("IOException (broadcasting)");
			}
		}
	}
	
	public void run () {
		String data = "";
		try {
			while (!(data = dis.readUTF()).equals("quit")) { // 클라이언트로부터 데이터 읽기
				//broadcast
				broadcasting(data);
				System.out.println(IPAddress + " > " + data);
			}
		} catch (EOFException e) {
			System.out.println("EOFException (thread)");
		} catch (IOException e) {
			System.out.println("IOException (thread)");
		} finally {
			if (clientSocket != null) {
				threads.remove(this); // 다 사용한 스레드는 리스트에서 제거
				try {
					clientSocket.close();
				} catch (IOException e) {
					System.out.println("IOException (thread close)");
				}
			}
			broadcasting(IPAddress + " 가 종료했습니다.");
		}
	}
	
}


//Server
public class TCPBroadServerStudy {

	public static void main(String[] args) {
		int port = 5432; // 포트번호
		ServerSocket serverSocket = null;
		List<BroadThread> threads = new Vector<BroadThread>(); // vector는 동기화처리가 되어 있어서 안전
		try {
			serverSocket = new ServerSocket(port); // 서버용 소켓 생성

			
			while (true) {
				try {
					Socket clientSocket = serverSocket.accept(); // 서버와 클라이언트 소켓 연결
					
					//thread 스타트
					BroadThread thread = new BroadThread(clientSocket, threads);
					threads.add(thread); // list에 스레드 추가
					thread.start();
				} catch (IOException e) {
					System.out.println("IOException (run thread)");
				}
			}
				
		} catch (SecurityException e) { // 예외는 알아낼때마다 더 자세하게 추가한다
			System.out.println("SecurityException");
		} catch (IOException e) {
			System.out.println("IOException ");
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					System.out.println("IOException (close server)");
				}
			}
		}
		
		
	}
}

package thread;

import java.util.Scanner;

class Stop extends Thread {
	//field
	int max;
	int count;
	//constructor
	public Stop() {
		count = 0;
		max = 1000;
	}
	//Thread 실행 메서드
	public void run() {
		for (; count < max; count++) {
			System.out.println("Running " + count); // count가 max에 도달할때까지 running이란 메시지 출력
			try {
				Thread.sleep(1000); // 1초간 텀을 주기
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Stop");
	}
}


public class StopTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stop stop = new Stop();
		stop.start(); // thread 시작
		
		Scanner scanner = new Scanner(System.in);
		stop.max = scanner.nextInt(); // 키보드로 값을 입력하면 그 값에 맞춰 thread가 멈춤 (ex. 10입력시 10에서 종료)
	}

}

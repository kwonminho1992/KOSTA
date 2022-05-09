package thread;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadTest {

	public static void main(String[] args) {
		// main thread 생성
		Thread currentThread = Thread.currentThread();
		String ctName = currentThread.getName();
		System.out.println("현재 사용중인 Thread의 이름 : " + ctName); // main thread
//		//방법1 : Thread class 상속
		First zero = new First();
		First one = new First();
		First two = new First();
		//first.run(); // run() method는 thread가 할일을 정해줌
		zero.start(); // start() method로 새로운 thread (zero)를 생성 후, 할일을 실행시킴
		//* run() method를 직접 호출하면 새로운 thread가 생성되지 않고, main thread의 일을 수행하므로, start() method를 통해 간접적으로 호출해야한다
		one.start(); // start() method로 새로운 thread (one)를 생성 후, 할일을 실행시킴
		two.start(); // start() method로 새로운 thread (two)를 생성 후, 할일을 실행시킴
		System.out.println("Finish"); // thread의 cpu점유는 JVM과 CPU가 결정함 (개발자가 컨트롤 할 수 있는 범위 밖)
		
		//방법2 : Runnable interface로 구현
		Second second = new Second();
		Thread three = new Thread(second); // second 객체를 인자로 하여 three (Thread) 객체 생성
		Thread four = new Thread(second); // second 객체를 인자로 하여 four (Thread) 객체 생성
		Thread five = new Thread(second); // second 객체를 인자로 하여 five (Thread) 객체 생성
		three.start(); // start() method로 새로운 thread (four)를 생성 후, 할일을 실행시킴
		four.start();
		five.start();
	}


}

class First extends Thread { // Thread class를 상속받으면 thread로 생성가능	
	@Override
	public void run() {//run() meathod를 overriding 해서 thread가 할일을 정해줘야함
		for (int i = 1; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName() + "- i = " + i);
		}
	}
}

class Second implements Runnable { // Runnable interface를 상속받으면 thread로 생성가능	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd(EEE) HH:mm:ss");
	@Override
	public void run() {//run() meathod를 overriding 해서 thread가 할일을 정해줘야함
		for (int i = 0; i < 50; i++) {
			Date date = new Date();
			String formatStr = sdf.format(date); 
			System.out.println(Thread.currentThread().getName() + " : " + formatStr);
			try {
				Thread.sleep(1000L); // 1초간 휴식
			} catch (InterruptedException e) { 
				e.printStackTrace(); // 예외종류, 내용, 발생위치 모두 출력
			}
		}
	}
}
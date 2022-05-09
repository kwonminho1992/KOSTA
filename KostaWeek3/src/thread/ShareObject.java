package thread;

public class ShareObject {
	public static void main(String[] args) {

		Share s = new Share(7); // Share type의 객체 s 생성
		s.toString();
		Pop pop = new Pop(s); // Pop type의 객체 pop 생성 (필드에 Share type의 s가 변수로 들어감)
		System.out.println("hashcod (pop) = " + pop.hashCode());
		Push push = new Push(s); // Pop type의 객체 push 생성 (필드에 Share type의 s가 변수로 들어감)
		System.out.println("hashcod (push) = " + push.hashCode());
		System.out.println("hashcod (s) = " + s.hashCode());		
		System.out.println("hashcod (pop.s) = " + pop.s.hashCode());
		System.out.println("hashcod (push.s) = " + push.s.hashCode());
		pop.start();
		push.start();
	
	}
}

class Share extends Thread {
	//field
	int i;
	//constructor
	public Share (int i) {
		this.i = i;
		System.out.println(i);
	}
	
	public void push() { //필드값 i 1증가
		synchronized (this) { // 임계영역의 설정(동기화처리)
			notify(); // push()가 실행되면 wait set에 있는 pop()을 깨워서 활동가능(Runnable)상태로 만듦
			// *만약에 복수의 thread가 wait set 상태에 있는 경우, wait set은 queue 구조이므로 첫번째 인덱스 부터 깨운다.
			System.out.print("before push : i = " + this.i);
			this.i++;
			System.out.println(" / after push : i = " + this.i);
		}	
	}
	
	public void pop() { //필드값 i 1감소
		synchronized (this) { // 임계영역의 설정(동기화처리)
			if (i == 0) {
				try {
					wait(); // pop()을 wait set으로 넣기 (wait set에 들어간 thread는 일시정지 상태가 됨)
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.print("before pop : i = " + this.i);
			this.i--;
			System.out.println(" / after pop : i = " + this.i);
		}	
	}
}
//생성자에 파라미터로 share 객체를 넣으면, push 객체의 값은 share 객체을 참조함
class Push extends Thread {
	//field
	Share s;
	//constructor
	Push (Share s) {
		this.s = s;
	}
	
	@Override
	public void run() { // 객체 s의 push() method 10회 호출
		for (int i = 0; i < 10; i++) {			
			s.push();// 객체 s의 필드값 i를 1 증가시킴
		}
	}
}

//생성자에 파라미터로 share 객체를 넣으면, pop 객체의 값은 share 객체을 참조함
class Pop extends Thread{
	//field
	Share s;
	//constructor
	Pop (Share s) { // 객체 s의 pop() method 10회 호출
		this.s = s;
	}
	
	@Override
	public void run() { // 객체 s의 pup() method 10회 호출
		for (int i = 0; i < 10; i++) {
			s.pop();// 객체 s의 필드값 i를 1 감소시킴
		}
	}
}


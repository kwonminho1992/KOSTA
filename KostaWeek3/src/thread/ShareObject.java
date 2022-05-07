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
		synchronized (this) { // 동기화처리
			System.out.print("before push : i = " + this.i);
			this.i++;
			System.out.println(" / after push : i = " + this.i);
		}	
	}
	
	public void pop() { //필드값 i 1감소
		synchronized (this) { // 동기화처리
			System.out.print("before push : i = " + this.i);
			this.i--;
			System.out.println(" / after push : i = " + this.i);
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


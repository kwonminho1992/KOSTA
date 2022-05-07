package thread;

class Join extends Thread {
	int begin, end;
	int sum;
	
	public Join(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}
	
	@Override
	public void run() {
		for (int i = begin; i <= end; i++) {
			sum += i;
		}
	}
}

public class JoinTest {

	public static void main(String[] args) {
		Join j1 = new Join(1, 10000);
		j1.start();
		try {
			j1.join(); //j1 thread가 끝나기 전까지 이 method를 호출하는 main thread는 실행을 중단함
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(j1.begin + "부터 " + j1.end + "의 합은 " + j1.sum);;
	}

}

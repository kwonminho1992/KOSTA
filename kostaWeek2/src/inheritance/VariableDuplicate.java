package inheritance;

class PP {
	int ppv;
	String sv;
}

class P extends PP {
	int pv;
}

class C extends P {
	int cv;
	int sv; // *상속의 깊이가 깊어질수록 변수 이름의 중복이 일어날 가능성이 높아진다.
	
	public void c() { // PP class의 sv변수를 출력
		System.out.println(super.sv);
	}
}

public class VariableDuplicate {
	public static void main(String[] args) {
		C c = new C();
		//memory : object c in stack | ppv, sv, pv, cv, sv in heap
		
		System.out.println(c.sv); // 0 (부모클래스의 변수이름과 자식클래스의 변수이름이 중복될 시, 자식클래스의 것이 우선
		c.c(); // 조부모 클래스(PP)의 sv 변수를 가져오는 method
	}
}


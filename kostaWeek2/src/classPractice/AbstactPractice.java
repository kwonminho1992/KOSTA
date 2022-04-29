package classpractice;

public class AbstactPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

abstract class B { //부모 class
	abstract void m (); // BChild class에서 반드시 overriding해야함 (안하면 compile error)

}
class BChild extends B { //자식 class
	void m () {
	}
} 
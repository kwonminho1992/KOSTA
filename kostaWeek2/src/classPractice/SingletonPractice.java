package classPractice;

/**
 * singleton class
 */
class Singleton {
	// 미리 객체를 1개 만들고, 그 이상으로는 객체 생성을 금지시킴
	// Spring framework 에서 많이 사용되는 개념

	// object declaration
	private static Singleton singleton = new Singleton();

	// constructor
	private Singleton() {
		}

	// user can refer the object by getInstance method
	public static Singleton getInstance() {
		return singleton;
	}
}

/**
 * main class
 */
public class SingletonPractice {
	static public void main(String[] args) {
		//declare object
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1 == s2); // true (s1 and s2 refer same memory)
	}

}

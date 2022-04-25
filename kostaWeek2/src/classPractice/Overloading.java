package classPractice;

public class Overloading {

	public static void main(String[] args) {
		// Example of overload
		// println method has string type, number type, boolean type version
		// 3 meathods has same function (print the value), but different data types 
		System.out.println("ABC");
		System.out.println(1+2);
		System.out.println(1>3);
		
		//there are plus method that 3 parameters version and 2 parameters version
		plus(1, 2, 3); // 6 ( 1 + 2 + 3)
		plus(1, 2); // 3 (1 + 2)
		plus(1.2, 3.4); // 4.6 (1.2 + 3.4)
	}
	
	public static void plus (int a, int b, int c) {
		System.out.println(a + b + c);
	}
	
	public static void plus (int a, int b) {
		System.out.println(a + b);
	}
	
	public static void plus (double a, double b) {
		System.out.println(a + b);
	}
}

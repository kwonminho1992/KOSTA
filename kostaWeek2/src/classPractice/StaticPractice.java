package classpractice;

/**
 * usage of static
 * @author kwon minho
 *
 */
public class StaticPractice {

	public static void main(String[] args) {
		// static practice
		StaticClass staticClass1 = new StaticClass();
		StaticClass staticClass2 = new StaticClass();
		System.out.println("staticClass1.iv : " + staticClass1.iv); // print instance variable
		System.out.println("StaticClass.sv : " + StaticClass.sv); // print static variable
		
		staticClass1.iv = "instatnce variable of staticClass1";
		staticClass1.sv = "constant variable of staticClass1";
		System.out.println("staticClass2.iv : " + staticClass2.iv); // change of instance variable doesn't effect on other objects
		System.out.println("staticClass2.sv : " + staticClass2.sv); // change of static variable effects on other objects
		
		staticClass1.m(); //run instance method
		StaticClass.sm(); //run static method
	}

}

class StaticClass {
	String iv = "instance variable"; // instance variable
	static String sv = "static variable"; //static variable
	public void m() { // instance method
		System.out.println("non-static method");
		System.out.println("sv : " + sv);
	}
	public static void sm() { // static method
		System.out.println("static method");
		System.out.println("sv : " + StaticClass.sv);
		//System.out.println("this.iv : " + this.iv); //cannot use non-static variable&method in static method
		//System.out.println("iv : " + iv);
		//m();
	}
}


//memory
//stack : staticClass, staticClass2, sv
//heap : iv, m, sm (of staticClass) / iv, m, sm(of staticClass2)
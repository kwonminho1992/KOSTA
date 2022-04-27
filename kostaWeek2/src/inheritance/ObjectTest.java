package inheritance;


class A extends Object{ //Object class를 상속함
	//field
	int i;
	//constructor
	public A (int i) { // default value = 3
		this.i = i;
	}
	public void print() {
		System.out.println("멤버변수 i의 값은 " + this.i + " 입니다");
	}
	public String toString() { // Object class의 toString() method를 override
		return "멤버변수 i의 값은 " + this.i + " 입니다";
	}
}


/**
 * 자바의 최상위 클래스인 java.lang.Object 클래스에 대해 알아보자
 * hashCode(), toString(), equals() 등의 메서드를 가지고 있음
 * @author asus
 *
 */
public class ObjectTest {
	
	public static void toStirngTest (Object object) { // print toString()의 값
		System.out.println(object.toString());
	}

	public static void main(String[] args) {
		// create objects
		Object object1 = new Object();
		Object object2 = new Object();
		Object object3 = object1;
		
		//hashcode : 해당 객체에 대한 정보를 저장한 일련번호
		System.out.println("hashcode()");
		System.out.println(object1.hashCode());
		System.out.println(object2.hashCode());
		System.out.println(object3.hashCode()); // object1, object3의 hashcode값이 같음 (같은 값을 참조하므로..) 
		System.out.println();
		//toString : hashcode를 16진수로 변환한 값을 출력
		System.out.println("toString()");
		System.out.println(object1.toString()); 
		System.out.println(object2.toString());
		System.out.println(object3.toString());
		System.out.println();
		//equals : 비교대상이 서로 같은가 아닌가를 출력 (true or false)
		System.out.println("equals()");
		System.out.println(object1.equals(object2)); // false
		System.out.println(object1.equals(object3)); // true
		System.out.println();
		//Object의 하위클래스 : Date, String, StringBuilder
		String string1 = new String("abcd");
		System.out.println("toString (String class)");
		System.out.println(string1.toString()); // Object(부모)클래스의 toString와 다름 (부모 클래스를 overriding함)
		
		StringBuilder sb1 = new StringBuilder("a");
		StringBuilder sb2 = new StringBuilder("a");
		System.out.println(sb1.equals(sb2)); // false, StringBuilder에는 equals() method가 없어서 객체의 hash값을 서로 비교함
		
		
		//method overriding 실습
		System.out.println("method overriding 실습");
		A a1 = new A(3);
		A a2 = new A(5);
		a1.print(); //멤버변수 i의 값은 3입니다.
		System.out.println(a1.toString()); //멤버변수 i의 값은 3입니다. / Object class의 toString() method를 override
		toStirngTest(a2);//멤버변수 i의 값은 5입니다. (A class의 toString() method가 실행됨)
		toStirngTest(object3);//java.lang.Object@15db9742 (Object class의 toString() method가 실행됨)
	}

}

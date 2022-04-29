package inheritance;


class A extends Object{ //Object class를 상속함
	//field
	private int i;
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
	
	@Override // equals() method는 Object class의 equals() method를 overriding한 method라고 complier에게 알리는 역할 
	//(코드에 overriding 규칙에 위배되는 부분이 있으면 에러를 띄움) 
	public boolean equals (Object object) { // Object class의 equals() method를 overriding하여 만든 A class의 equals() method
		if (object instanceof A) { // instanceof 연선자 : 매개변수 object가 A type인가 아닌가를 검사
			//object가 A type이라면, 매개변수가 부모 클래스의 매개변수 타입과 같아야해서 매개변수를 Object type으로 설정함
			A a = (A) object; //downcasting (Object type을 A type으로 강제 형변환) *자식 객체가 부모타입으로 upcasting된 후에만 자식타입으로 다시 downcasting이 가능
			//부모객체가 자식타입으로 바로 downcasting하는것은 불가능 (ClassCastException 발생)
			if (this.i == a.i) { //this.i == a1.i, a.i == a2.i
				return true;
			}
		}
		return false;
		
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
	
	public static void equalsTest (Object obj1, Object obj2) { // A type의 객체들은 Object type으로 upcasting되어 연산됨
		System.out.println(obj1.equals(obj2)); // Object class의 equals() method : 같은 메모리에 저장되어있는가 아닌가를 확인
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
		
		System.out.println();
		//method overriding 실습
		System.out.println("method overriding 실습");
		A a1 = new A(3);
		A a2 = new A(3);
		a1.print(); //멤버변수 i의 값은 3입니다.
		System.out.println(a1.toString()); //멤버변수 i의 값은 3입니다. / Object class의 toString() method를 override
		toStirngTest(a2);//멤버변수 i의 값은 3입니다. (A class의 toString() method가 실행됨) -> 다형성
		toStirngTest(object3);//java.lang.Object@15db9742 (Object class의 toString() method가 실행됨) -> 다형성
		
		// upcasting 실습
		System.out.println();
		equalsTest(object1, object3); //true
		equalsTest(a1, a2); //true // a1, a2는 객체의 메모리값이 아닌 field 값을 비교하는 메서드를 만들어야함
		equalsTest(a1, object3); // a1 - upcasting
		equalsTest(object2, a2); // a2 - upcasting
	}

}

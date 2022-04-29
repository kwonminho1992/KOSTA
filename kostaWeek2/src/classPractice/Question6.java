package classpractice;
//이것이 자바다 7. 상속 340p 6번문제
class Parent {
	//field
	private String nation;
	//constructor (매개변수 없음)
	public Parent() {
		this ("대한민국"); // this 생성자(또 다른 생성자를 호출시키는 기능)를 통해 Parent(String nation) 생성자도 호출
		System.out.println("Parent");
	}
	//constructor (매개변수 있음)
	public Parent(String nation) {
		//super(); 이 생략되어있음 (Object class)
		this.nation = nation;
		System.out.println("Parent(string)");
	}
}

class Child extends Parent {
	//field
	private String name;
	//constructor (매개변수 없음)
	public Child() {
		this("홍길동"); // this 생성자(또 다른 생성자를 호출시키는 기능)를 통해 Child(String name) 생성자도 호출
		System.out.println("Child");
	}
	//constructor (매개변수 있음)
	public Child(String name) {
		//super(); 이 생략되어있음
		this.name = name;
		System.out.println("Child(string)");
	}
	
}

public class Question6 {
	public static void main(String[] args) {
		Child child = new Child();
		
	}
}

//처리순서 : child 객체 생성 -> Child() 생성자 -> Child(String name) 생성자 -> Parent() 생성자 -> Parent(String nation) 생성자 -> Object() 생성자
//출력순서 : 처리순서의 역순
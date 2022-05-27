package inheritance;
abstract class Geometry { // 부모클래스
	//field
	protected double area;
	//constructor
	public Geometry () {
	}
	//면적값 리턴
	public double getArea () {
		return area;
	}
	
	public void print () { // method overriding(재정의) : 부모클래스, 자식클래스의 메서드의 이름이 같은 것, 자식클래스의 메서드가 실행될 것임
		System.out.println("이것은 도형입니다");
	}
	
	abstract void calcArea (); // abstract method : 자식 클래스에서 반드시 overriding 해야함 
}

class Circle extends Geometry { // 자식클래스
	//field
	private int radius;
	//constructor
	public Circle (int radius) {
		this.radius = radius;
	} 
	//반지름 값 출력 메서드
	public void print () {
		super.print(); // 부모 클래스의 print method의 내용 실행
		System.out.println("반지름이 " + radius + "인 원 입니다.");
	}
	
	//원의 면적 값 계산
	public void calcArea () {
		super.area = radius * radius * Math.PI;
	}
}

class Rectangle extends Geometry { // 자식클래스
	//field
	private int width;
	private int height;
	//constructor
	public Rectangle (int width, int height) { // 직사각형용
		this.width = width;
		this.height = height;
	}
	public Rectangle (int length) { // 정사각형용
		this (length, length);
	}
	//가로, 세로 값 출력 메서드
	public void print () {
		super.print(); // 부모 클래스의 print method의 내용 실행
		if (width == height) { // 정사각형
			System.out.println("가로 & 세로의 길이가 " + height + "인 정사각형 입니다.");
		} else { // 직사각형
			System.out.println("가로 길이가 " + width + ", 세로 길이가 " + height + "인 직사각형 입니다.");
		}
	}
	
	//사각형의 면적 값 계산
	public void calcArea () {
		super.area = width * height;
	}
}

class Triangle extends Geometry { // 자식클래스
	//field
	private int base;
	private int height;
	//constructor
	public Triangle (int base, int height) {
		this.base = base;
		this.height = height;
	}
	//가로, 세로 값 출력 메서드
	public void print () {
		super.print(); // 부모 클래스의 print method의 내용 실행
		System.out.println("가로 길이가 " + base + ", 세로 길이가 " + height + "인 삼각형 입니다.");
		
	}
	
	//사각형의 면적 값 계산
	public void calcArea () {
		super.area = (base * height) / 2.0;
	}
}

//메인 클래스 (실행부)
public class Shape {

	// 반환받은 면적값을 출력
	public static void printArea(Geometry geometry) {
		// Circle, Rectangle 타입을 Geometry 타입으로 적용 (upcasting), Geometry 타입을 Circle/Rectangle 타입으로 강제 형변환(downcasting) 
		geometry.print(); //가로, 세로 or 반지름 길이 출력
		System.out.println("넓이 : " + geometry.getArea()); // 넒이 출력
	}
	
	public static void main(String[] args) {
		// shape calculation with inheritance

		Geometry[] arr = new Geometry[4]; // Circle, Rectangle이 담기는 배열 생성
		arr[0] = new Circle(5);
		arr[1] = new Rectangle(3,4);
		arr[2] = new Rectangle(5);
		arr[3] = new Triangle(5, 1);
		
		for (int i = 0; i < arr.length; i++) {
			arr[i].calcArea(); // 넓이 계산
			printArea(arr[i]); // 가로, 세로 or 반지름 길이 출력 & 넓이 출력
		}
		
//		Circle circle = new Circle(5); // 반지름이 5인 원 생성
//		Rectangle rectangle1 = new Rectangle(3, 4); // 가로가 3, 세로가 4인 직사각형 생성
//		Rectangle rectangle2 = new Rectangle(5); // 길이가 5인 정사각형 생성
//		
//		circle.print(); // 원의 반지름 길이 출력
//		circle.calcArea(); // 원의 면적 계산
//		printArea(circle); // 면적값을 반환받고, 출력
//		
//		rectangle1.print(); // 직사각형의 반지름 길이 출력
//		rectangle1.calcArea(); // 직사각형의 면적 계산
//		printArea(rectangle1); // 면적값을 반환받고, 출력
//		
//		rectangle2.print(); // 정사각형의 반지름 길이 출력
//		rectangle2.calcArea(); // 정사각형의 면적 계산
//		printArea(rectangle2); // 면적값을 반환받고, 출력
//	}
		
	
	}
}

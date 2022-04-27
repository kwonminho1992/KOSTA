package inheritance;
/**
 * 
 * @author kwon minho
 *
 */
public class Child extends Parent { //Child class can inherit Parent class by 'extends'
	//field
	private String c1;
	//constructor
	public Child(String c1) {
		super ("Parent's variable", 10000); // constructors from Parent class
		this.c1 = c1;
	}
	public Child() { // *매개변수가 없는 생성자를 만드는 습관을 들일것 (코드의 재사용성 증가를 위해)
	}
	//method
	public void cm() {
		System.out.println("method of child");
		//System.out.println("p1 : " + super.p1); // 자식클래스는 부모클래스의 private 변수, 메서드 등은 접근할 수 없다 (상속 받을 수만 있음)
	}
	public String getC1() {
		return c1;
	}
	public void setC1(String c1) {
		this.c1 = c1;
	}
}

/**
 * 사원에 대한 정보를 저장하는 프로그램
 */
package constructor;

/**
 * 사원 클래스
 * @author 권민호
 * @version 1.0
 *
 */
public class Employee {
	// Employee
	String no; // 사번
	String name; // 이름
	int salary; // 급여
	/**
	 * 생성자 (constructor)
	 * @param no : 사번
	 * @param name : 이름
	 * @param salary : 급여
	 */		
	public Employee() { //constructor1
		System.out.println("생성자 0개 호출");
	}
	
	public Employee(String no, String name) { //constructor2 : this constructor
		this (no, name, 2000);
	}
	
	public Employee(String no, String name, int salary) { //constructor3 : overload
		System.out.println("생성자 3개 호출");
		this.no = no;
		this.name = name;
		this.salary = salary;
	}

}

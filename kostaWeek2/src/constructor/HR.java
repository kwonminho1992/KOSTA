/**
 * 사원에 대한 정보를 저장하는 프로그램
 */
package constructor;

/**
 * HR 클래스 (main class)
 * @author 권민호
 * @version 1.0
 *
 */
public class HR {

	public static void main(String[] args) {
		// create objects
		
		Employee e1 = new Employee(); //constructor 1 사용
		e1.no = "2201";
		e1.name = "Steve Jobs";
		e1.salary = 2000;
		
		Employee e2 = new Employee("2301", "Elon Musk", 2500); //constructor 2 사용
		
		Employee e3 = new Employee("2401", "Bill Gates", 3000);

	}
	
	
		//메모리
		//stack : e1, e2, e3
		//heap : e1.no ="2201", e1.name="Steve Jobs", e1.salary=2000; 
		//       e2.no ="2301", e2.name="Elon Musk", e2.salary=2500;
		//       e3.no ="2401", e3.name="Bill Gates", e3.salary=2000;	
}

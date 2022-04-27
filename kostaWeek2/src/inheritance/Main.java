package inheritance;
//class for running the program
public class Main {
	public static void main(String[] args) {
		//declare parent object and deal with variables, method of Parent
		Parent parent = new Parent("Parent's variable", 10000);
		parent.pm();
		
		//declare child object and deal with variables, method of Child & Parent class
		Child child = new Child("Child's variable");
//		child.c1 = "Child's variable";
		System.out.println("child.p1 : " + child.getP1() +"\nchild.c1 : " + child.getC1() + "\nchild.money : " + child.getMoney());
		child.cm();
		child.pm();
	}
}

// memory
// parent object in stack -> p1, money, pm() in heap (from Parent class)
// child object in stack -> p1, money, pm(), c1, cm() in heap  (from Child class)
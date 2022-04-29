package classpractice;

public class Memory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 10;
		iManage(i); // 10
		int j = iManage(i); // i : 10 -> 99
		System.out.println("j : " + j); // 99
		
		int[] arr = { 10, 20, 30 };
		iManage(arr); // arr[0] : 10 -> 99;
		System.out.println(arr[0]); // 99
		
	}
	public static int iManage (int i) {
		System.out.println("i : " + i);
		i = 99;
		return i;
	}
	
	public static void iManage (int[] arr) { // method overloading
		arr[0] = 99;
	}
	
	
	// stack area :
	// - main method (args, i = 10, arr) 
	// - iManage method (i = 99, arr(= main's arr))
	
	// heap area : 
	// - main method ( {10, 20, 30} )
	// 
	
}

import java.util.Scanner;

/**
Practice of Java loops
*/
public class Loop {
    /**
    Main method is a method to act as entry point when class runs
    */
	public static void main(String[] args) {
		//while loop
//		int num = 1;
//		int count = 0;
//		while (count < 4) {
//			System.out.println(num);
//			num += 2;
//			count++;
//		}
		
		
//		//for loop
//		//Fibonacci 1, 1, 2, 3, 5, 8, 13, 21, 34
//		int bb = 1; // before before
//		int b = 1; // before
//		int current = 0;
//		
//		for (int i = 0; i < 9; i++) {
//			bb = b; // before -> before before
//			b = current; // current -> before
//			current = bb + b; // current = before before + before
//			System.out.println("order : " + (i + 1) + " / number " + current);			
//		}
//		
//		for (int bb2 = 1, b2 = 0, cnt = 0; cnt < 9; cnt++) {
//			int current2 = bb2 + b2; 
//			System.out.println("order : " + (cnt + 1) + " / number " + current2);
//			bb2 = b2; // before before -> before
//			b2 = current2; // before -> current
//		}
		
		System.out.println();
		
//		//Print rotto 6 numbers 
//		int [] lotto = new int [6]; 
//		for (int i = 0; i < lotto.length; i++) { //create 6 lotto lots
//			int rand = (int) (Math.random() * 45) + 1; // create number (1 <= rand <= 45)
//			for (int j = 0; j < i; j++) { // check overlaps 
//				if (lotto[j] == rand) {
//					i--; //if there is a overlap, re-operate lotto[i]
//					break; // syntax : only break the second for loop 
//				}
//			}			
//			lotto[i] = rand;
//		}
//		for (int i = 0; i < lotto.length; i++) {
//			System.out.println((i + 1) + " : " + lotto[i]);
//		}
//
//		
//		// do - while	
//		int n;
//		do {
//			n = (int) (Math.random() * 5);
//			System.out.println(n);
//		} while ( ! (n == 4) );
//		

		
	}
}
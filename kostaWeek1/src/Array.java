import java.util.Scanner;

/**
Practice of Java Arrays
*/
public class Array {
    /**
    Main method is a method to act as entry point when class runs
    */
	public static void main(String[] args) {
//		// Array
//		Scanner scanner = new Scanner(System.in);
//		int [] score = new int [6];
//		int totalScore = 0;
//		for (int i = 0; i < score.length; i++) {
//			System.out.println("input score of " + (i+1) + " : ");
//			score[i] = scanner.nextInt(); 
//			totalScore += score[i];
//		}
//		System.out.println("Sum : " + totalScore); // sum		
//		System.out.println("Average : " + (double) totalScore / score.length); // average
		
//		//Array 2
//		String [] zodiacSigns = {"monkey", "chicken", "dog", "pig", "mouse", "cow", 
//				"tiger", "rabbit", "dragon", "snake", "horse", "sheep"};
//		int year = 2022;
//		System.out.println(zodiacSigns[year % zodiacSigns.length]);
	
//		//Array 3 - how many times 1, 2, 3, ... 10 appears?
//		int [] numbers = {1, 10, 3, 3, 1, 2, 7, 1, 6, 9}; // range : 1~10
//		
//		for (int i = 1; i <= 10; i++) { // check each number (1,2,3...10)
//			int count = 0;
//			for (int j = 0; j < numbers.length; j++) { // check how many times the number does appear?
//				if (numbers[j] == i) {
//					count++;
//				} else {
//				}
//			}
//			System.out.println(i + " is appeared " + count + " times"); // result
//		}
	
//		//Array 4 - find min or max
//		int [] nums1 = { 9, 3, 1, 4, 5 }; 
//		int min = nums1[0]; // set the variable 'min'
//		for (int i = 0; i < nums1.length; i++) {
//			// compare each index with current min. 
//			//if current index is lesser than min, change the min variable
//			if (nums1[i] < min) {
//				min = nums1[i];
//			}
//		}
//		System.out.println("min : " + min);
		
		//Array5 : multi dimensional array
//		int [][] arr = new int [3][4];
//		int count = 0;
//		for (int i = 0; i < arr.length; i++) { // 1st dimension
//			for (int j = 0; j < arr[i].length; j++) { // 2nd dimension
//				arr[i][j] = (i + 1) + (j * arr.length); // input value into the array
//				System.out.print("[" + arr[i][j] + "]");
//			}
//			System.out.println("");
//		}
		
		//Array5 : multi dimensional array version 2
//		int[][] arr = new int[3][4];
//		int count = 1;
//		for (int i = 0; i < arr.length; i++) { // 1st dimension
//			for (int j = 0; j < arr[i].length; j++) { // 2nd dimension
//				arr[i][j] = count++; // input value into the array
//				System.out.print(arr[i][j] + " | ");
//			}
//			System.out.println("\n---------------");
//		}
		
		//Array5 : multi dimensional array A = 65
//		char [][] arr = new char [3][4];
//		for (int i = 0; i < arr.length; i++) { // 1st dimension
//			for (int j = 0; j < arr[i].length; j++) { // 2nd dimension
//				arr[i][j] = (char) ((i * arr[i].length) + (j + 65)); // input value into the array
//				System.out.print("[" + arr[i][j] + "]");
//			}
//			System.out.println("");
//		}

		//Array5 : multi dimensional array : 5 students, 3 subjects
//		int [][] scores = { {9, 8, 5}, {10, 3, 5}, {7, 10, 8}, {3, 2, 1}, {5, 6, 7} };
//		String [] subjects = {"Korean", "English", "Math"};
//		for (int i = 0; i < scores.length; i++) { // sum & avg of each student 
//			int sum = 0;
//			for (int j = 0; j < scores[i].length; j++) {
//				sum += scores[i][j];
//			}
//			float avg = (float) Math.round((float) sum/scores[i].length * 100) / 100;
//			System.out.println("student" + (i + 1) + " - " + 
//			sum + "(sum), " + avg + "(avg)");
//		}
//		for (int i = 0; i < scores[i].length; i++) { // sum & avg of each subject
//			int sum = 0;
//			for (int j = 0; j < scores.length; j++) {
//				sum += scores[j][i];
//			}
//			float avg = (float) Math.round((float) sum/scores.length * 100) / 100;
//			System.out.println(subjects[i] + " - " + 
//			sum + "(sum), " + avg + "(avg)");		}
		
		//Array5 : multi dimensional array version 3
		//state default array
		int[][] arr = new int[4][6];
		int count = 1;
		for (int i = 0; i < arr.length; i++) { // 1st dimension
			for (int j = 0; j < arr[i].length; j++) { // 2nd dimension
				arr[i][j] = count++; // input value into the array
				//System.out.print("[" + arr[i][j] + "]");
			}
			//System.out.println("");
		}
		// rotated array (90)
		int[][] arrRotate90 = new int[arr[0].length][arr.length];
		int lastValueOfCol = arr.length - 1; // arrRotate90's column = arr's row
		int lastValueOfRow = arr[0].length - 1;// arrRotate90's row = arr's column
		for (int i = 0; i < arrRotate90.length; i++) { // 1st dimension
			for (int j = 0; j < arrRotate90[i].length; j++) { // 2nd dimension
				arrRotate90[i][j] = arr[lastValueOfCol - j][i];
				System.out.print("[" + arrRotate90[i][j] + "]");
			}
			System.out.println("");
		}
				
	}
}

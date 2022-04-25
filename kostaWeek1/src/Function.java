import java.util.Calendar;
import java.util.Scanner;

public class Function {

	public static void main(String[] args) {
		// zodiac function (exist input & output)
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input your birth year");
		int year = scanner.nextInt();
		System.out.println(zodiac(year));
		
		//checkOddOrEven function (exist input only)
		checkOddOrEven(year);
		
		//showCurrentTime (exist output only)
		System.out.println(showCurrentTime());
		
		//createFile (no input, output)
		createFile();
	}

	public static String zodiac (int year) {		
		String[] zodiacSign;
		zodiacSign = new String[] { "monkey", "chicken", "dog", "pig", "mouse", "cow", "tiger", 
				"rabbit", "dragon", "snake", "horse", "sheep" };
		int ganzi = year % zodiacSign.length;
		return zodiacSign[ganzi];
	}
	
	public static void checkOddOrEven (int i) {
		System.out.println(i % 2 == 1? "odd" : "even");
	}
	
	public static String showCurrentTime() {
		Calendar calendar = Calendar.getInstance();
		switch (calendar.get(Calendar.AM_PM)) {
		case java.util.Calendar.AM:
			return "AM";
		case java.util.Calendar.PM:
			return "PM";
		default:
			return "x";
		}
	}
	
	public static void createFile() {
		System.out.println("creating file...");
	}
}

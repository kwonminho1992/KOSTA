/**
Practice of Java conditions
*/
public class Condition {
    /**
    Main method is a method to act as entry point when class runs
    */
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);        
	/*
        //if condition (score)
        System.out.println("Input your score : ");
        int score = sc.nextInt(); //get user's input
        if (score >= 60) { //if score >= 60
            System.out.println("Pass!");
            if (score >= 90) { // if score >= 60 and >= 90
                System.out.println("Grade A!");
            } else if (score >= 70) { // if score >= 60 and >= 70, < 90
                System.out.println("Grade B!");
            } else { // if score >= 60 and < 70
                System.out.println("Grade C!");
            } 
        } else { // if score < 60
	    System.out.println("Fail...");
	}   
	
	//if condition (calculate ages)
        int year = 2022;
        System.out.println("Input your birth year : ");
        int birthYear = sc.nextInt();
        int age = year - birthYear;
        if (age < 7) {
            System.out.println("toddler");
        } else if (age <= 13) {   
            System.out.println("child");
        } else if (age <= 19) {   
            System.out.println("adolescence");
        } else {   
            System.out.println("adult");
        }
	//if condition (12 zodiac names)
	System.out.println("Input your birth year : ");
        int birthYear = sc.nextInt();
	int remain = birthYear % 12;
	if (remain == 0) {
	    System.out.println("Monkey");
	} else if (remain == 1) {
	    System.out.println("Chicken");
	} else if (remain == 2) {
	    System.out.println("Dog");
	} else if (remain == 3) {
	    System.out.println("Pig");
	} else if (remain == 4) {
	    System.out.println("Mouse");
	} else if (remain == 5) {
	    System.out.println("Cow");
	} else if (remain == 6) {
	    System.out.println("Tiger");
	} else if (remain == 7) {
	    System.out.println("Rabbit");
	} else if (remain == 8) {
	    System.out.println("Dragon");
	} else if (remain == 9) {
	    System.out.println("Snake");
	} else if (remain == 10) {
	    System.out.println("Horse");
	} else {
	    System.out.println("Sheep");
	} 
	//switch condition (calculate ages)
	System.out.println("Input your birth year : ");
        int birthYear = sc.nextInt();
	int remain = birthYear % 12;
	switch (remain) {
	case 0:
	    System.out.println("Monkey");
	    break;
	case 1:
	    System.out.println("Chicken");
	    break;
	case 2:
	    System.out.println("Dog");
	    break;
	case 3:
	    System.out.println("Pig");
	    break;
	case 4:
	    System.out.println("Mouse");
	    break;
	case 5:
	    System.out.println("Cow");
	    break;
	case 6:
	    System.out.println("Tiger");
	    break;
	case 7:
	    System.out.println("Rabbit");
	    break;
	case 8:
	    System.out.println("Dragon");
	    break;
	case 9:
	    System.out.println("Snake");
	    break;
	case 10:
	    System.out.println("Horse");
	    break;
	case 11:
	    System.out.println("Sheep");
	    break;
	default:
	    System.out.println("error");
	}
	*/
	// rock scissor paper game
	// 1 : scissor, 2 : rock, 3 : paper
	System.out.println("1 : " + (char) 9996 + " / 2 : rock / 3 : paper");
	int computer = (int) (Math.random() * 2147483647);
	computer %= 3;
	computer += 1;
	int user = sc.nextInt();
	if (user >= 1 && user < 4) {
	    if (computer == user) {
	        System.out.println("Draw");	
	    } else if ((user - computer % 3) == 1) {
		System.out.println("You win");
	    } else {
		System.out.println("You lose");
	    }
	} else {
	    System.out.println("ERROR. You must input only 0, 1, or 2");
	}
	switch (computer) {
	    case 1:
		System.out.println("Computer : scissor");
		break;
	    case 2:
		System.out.println("Computer : rock");
		break;
	    case 3:
		System.out.println("Computer : paper");
		break;
	    default:
		System.out.println("Computer : wrong value");
	}
	switch (user) {
	    case 1:
		System.out.println("User : scissor");
		break;
	    case 2:
		System.out.println("User : rock");
		break;
	    case 3:
		System.out.println("User : paper");
		break;
	    default:
		System.out.println("User : wrong input");
	}
    }
}




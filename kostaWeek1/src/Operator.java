/**
Practice of Java operators
*/
public class Operator {
    /**
    Main method is a method to act as entry point when class runs
    */
    public static void main(String[] args) {        
        //arithmetic operator
        int a, b, c;
        a = 10;
        b = 3;
        c = a + b;
	System.out.println("a(10) + b(3) = " + c);
        c = a % b;
	System.out.println("a(10) % b(3) = " + c);

        short s1, s2, s3;
        s1 = 10;
        s2 = 3;
        s3 = (short) (s1 + s2); // datatype less than 4 byte cannot participate in operation
	System.out.println("s1(10) + s2(3) = " + s3);

        float f;
        a = 10;
        b = 3;
        f = a + b; 
	System.out.println("a(10) + b(3) by float type = " + f);
        f = (float) a / b; 
	System.out.println("a(10) / b(3) by float type = " + f);

        //assignment operator
        a += 10;
	System.out.println("a(10) += 10 = " + a);

        //comparison operator
        a = 10;
	System.out.println("a(10) % 2 == 0 : " + (a % 2 == 0));
	System.out.println("a(10) % 2 == 1 : " + (a % 2 == 1));
	System.out.println("a(10) > b(3) : " + (a > b));

        //logical operator
	System.out.println("true && true : " + (true && true));
	System.out.println("true && false : " + (true && false));
	System.out.println("a(10) > b(3) : " + (a > b));

        //unary operator
        a = 10;
        a++;
	System.out.println("a(10)++ : " + (a++));
        a = 13;
        b = ++a;
	System.out.println("++a(13) : " + b);
        
        byte b1;
        b1 = 127;
        b1++;
        System.out.println("b1 : " + b1);

        //ternary operator
        a = 11;
	System.out.println("a(11) % 2 == 0 ? \"even\" : \"odd\" : ");
	System.out.println(a % 2 == 0 ? "even" : "odd");
    }
}
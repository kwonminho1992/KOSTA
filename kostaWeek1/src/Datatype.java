/**
Practice of Java datatypes 
*/
public class Datatype {
    /**
    Main method is a method to act as entry point when class runs
    */
    public static void main(String[] args) {        
        //byte type
        byte b;
        b = 1;
        System.out.println(b);

        //convert data type (natural number -> natural number)
        short sh;
        sh = b;
        System.out.println(sh);

        //real number
        float f;
        f = 1234.567F;
        System.out.println(f);

        //long
        long lon;
        lon = 123456789123456789L;
        System.out.println(lon);

        //convert data type (natural number -> real number)
        sh = 1234;
        f = sh;
        System.out.println(sh);
        System.out.println(f);

        //convert data type (real number -> natural number)
        sh = (short) f;
        System.out.println(sh);
        b = (byte) f;
        System.out.println(b);

        //char type
        char c = 'A';
        int i = c; //automatically convert data type
        System.out.println("int i - " + i);

        //boolean type
        boolean bool;
        bool = true;
        System.out.println(bool);
    }
}
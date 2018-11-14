package bookLibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ConsoleInput {

    private ConsoleInput() {      //prevents to make an instance
    }

    public static String readString() {
        String s = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean flag;

        do {
            flag = true;
            try {

                s = in.readLine();

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                System.exit(1);       //exit if some error
            }
            //    System.out.println(s);
        } while (!flag);
        return s;
    }

    public static int readInt() {
        String s = "";
        int n = 0;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

       
        boolean flag;

        do {
            flag = true;

            try {

                s = in.readLine();

            } catch (IOException ex) {
                //Logger.getLogger(Read_Line.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
                System.exit(1);
            }
            //    System.out.println(s);
            try {

                n = Integer.parseInt(s);
            } catch (Exception exc) {
                System.out.println(exc.getMessage());
                flag = false;
            }
        } while (!flag);
        return n;
    }
    
    public static short readShort() {
        String s = "";
        short n = 0;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

       
        boolean flag;

        do {
            flag = true;

            try {

                s = in.readLine();

            } catch (IOException ex) {
                //Logger.getLogger(Read_Line.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
                System.exit(1);
            }
            //    System.out.println(s);
            try {

                n = Short.valueOf(s);
            } catch (Exception exc) {
                System.out.println(exc.getMessage());
                flag = false;
            }
        } while (!flag);
        return n;
    }

    public static double readDouble() {
        double n = 0;
        String s = "";

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        boolean flag;

        do {
            flag = true;

            try {

                s = in.readLine();

            } catch (IOException ex) {
                //Logger.getLogger(Read_Line.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
                System.exit(1);       //exit if some error
            }
            //    System.out.println(s);
            try {

                n = Double.parseDouble(s);
            } catch (Exception exc) {
                System.out.println(exc.getMessage());
                flag = false;
            }
        } while (!flag);

        return n;
    }

    public static char readChar() {

        String s = "";
        char c = ' ';
        System.out.println(c);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        boolean flag;

        do {
            flag = true;

            try {

                s = in.readLine();

            } catch (IOException ex) {
                //Logger.getLogger(Read_Line.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
                System.exit(1);
            }
            //    System.out.println(s);
            try {

                if (s.length() > 1) {
                    flag = false;
                } else {
                    c = s.charAt(0);
                }
            } catch (Exception exc) {
                System.out.println(exc.getMessage());
                flag = false;
            }
        } while (!flag);

        return c;
    }

}

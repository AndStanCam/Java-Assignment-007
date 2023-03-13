package src;

import java.util.Scanner;


/**
 * @author Trevor Hartman
 * @author Ander Stanley-Camba
 * @since 2023-03-12
 * @version 1.0
 */
public class MyMath {


    // Note that it is not required for num1 > num2 or vice versa from the user's perspective
    public static int gcf(int num1, int num2) {
        int fac = 0;

        // If you follow the Euclid's GCF flowchart, it seems to expect that b < a . This enforces that
        if (num2 > num1) {
            int tmp = num1;
            num1 = num2;
            num2 = tmp;


        }

        // This is exactly what the Euclid's GCF flowchart indicated
        while (num2 != 0) {
            if (num1 > num2) {
                fac = num2;
                num2 = num1 % num2;
                num1 = fac;
            }
            else {
                num2 = num2 % num1;

            }
        }

        return fac;
    }



    public static void main(String[] args) {

        // I considered making all of this its own method to keep main() clean, but it felt redundant
        Scanner sc = new Scanner(System.in);
        int inp1 = 0;
        int inp2 = 0;

        System.out.println("~~Greatest Common Factor finder~~\n\nWelcome! Please enter two numbers to find their GCF!\n1st Number: ");

        try {
            inp1 = Integer.parseInt(sc.nextLine());
            System.out.println("2nd Number: ");
            inp2 = Integer.parseInt(sc.nextLine());

            System.out.printf("The greatest common factor between %d and %d is: %d", inp1, inp2,  gcf(inp1, inp2));
        }
        catch (Exception e) {
            System.err.println("Error: Not a valid input!\nexiting program...");
        }


    }
}

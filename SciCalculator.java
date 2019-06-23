import java.text.DecimalFormat; //GitHub edit!
import java.util.Scanner;
public class SciCalculator {
    public static void main(String[] args) {
        double firstOp;
        double secondOp; //These first two variables are set as doubles to allow for calculations with decimals
        int operation; //Variable value will be determined by user input and used to decide which calculation to perform
        double resultCurrent = 0.0;
        int calculations = 0;
        double total = 0.0;
        double average;
        DecimalFormat decimalFormat;
        decimalFormat = new DecimalFormat("#.##"); //DecimalFormat is used to control how many decimals are outputted when calculating averages

        Scanner scnr = new Scanner(System.in);
        while(true) {
            System.out.println("Current Result: " + resultCurrent);
            System.out.println("\nCalculator Menu\n---------------\n0. Exit Program\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Exponentiation\n6. Logarithm\n7. Display Average");
            //The above line prints the calculator menu, listing all options
            System.out.println("\nEnter Menu Selection: ");
            operation = scnr.nextInt();

            while (operation < 0 || operation > 7 || operation == 7) {  //Checks for any scenarios in which the menu selection would be reprinted

                if (operation == 7 && calculations == 0) {
                    System.out.println("\nError: No calculations yet to average!\n");
                }
                else if (operation == 7) {
                    average = total/calculations;
                    System.out.println("\nSum of calculations: " + decimalFormat.format(total));
                    System.out.println("Number of calculations: " + calculations);  //Lines 31-34 print all information regarding the average of prior calculations
                    System.out.println("Average of calculations: " + decimalFormat.format(average) + "\n");
                }
                else {
                    System.out.println("Error: Invalid selection!\n");
                }
                System.out.println("Enter Menu Selection: ");  //Once against asking for a menu selection
                operation = scnr.nextInt();
            }

            if(operation == 0) {
                System.out.println("\nThanks for using this calculator. Goodbye!");
                System.exit(0); //Exits program
            }

            System.out.println("Enter first operand: ");
            firstOp = scnr.nextDouble();
            System.out.println("Enter second operand: ");
            secondOp = scnr.nextDouble(); //Lines 50-53 take user inputs as values for first and second operands

            if (operation == 1) {
                resultCurrent = firstOp + secondOp; //Addition
            }
            else if (operation == 2) {
                resultCurrent = firstOp - secondOp; //Subtraction
            }
            else if (operation == 3) {
                resultCurrent = firstOp * secondOp; //Multiplication
            }
            else if (operation == 4) {
                resultCurrent = firstOp / secondOp; //Division
            }
            else if (operation == 5) {
                resultCurrent = Math.pow(firstOp, secondOp); //Exponentiation
            }
            else if (operation == 6) {
                resultCurrent = Math.log(secondOp) / Math.log(firstOp); //Logarithms
            }
            calculations += 1; //Keeps track of total number of calculations
            total += resultCurrent; //Keeps track of the sum of all calculations
        }
    }
}

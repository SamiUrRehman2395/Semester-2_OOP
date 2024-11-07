package Interfaces;

public class TryCatchFinally {
    public static void main(String[] args) {
        System.out.println("Program started.");
        try {
            System.out.println("Inside first try block.");
            int[] numbers = {1, 2, 3};
            System.out.println("Accessing out-of-bounds element: " + numbers[5]);  // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException.");
        } finally {
            System.out.println("First finally block executed.");
        }

        try {
            System.out.println("Inside second try block.");
            int result = 10 / 0;  // ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException.");
        } finally {
            System.out.println("Second finally block executed.");
        }

        System.out.println("Program ended.");
    }
}


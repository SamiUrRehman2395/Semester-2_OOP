package Interfaces;

public class NestedTryCatch {
    public static void main(String[] args) {
        System.out.println("Start of main try block.");
        try {
            System.out.println("Inside outer try block.");
            try {
                System.out.println("Inside inner try block.");
                int num = Integer.parseInt("XYZ");  // NumberFormatException
            } catch (NumberFormatException e) {
                System.out.println("Caught NumberFormatException in inner catch.");
            } finally {
                System.out.println("Inner finally block executed.");
            }
            System.out.println("Back to outer try block.");
        } catch (Exception e) {
            System.out.println("Caught Exception in outer catch.");
        } finally {
            System.out.println("Outer finally block executed.");
        }
        System.out.println("End of program.");
    }
}


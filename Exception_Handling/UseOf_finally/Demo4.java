package Exception_Handling.UseOf_finally;

public class Demo4 {
    public static void main(String[] args) {

        System.out.println(divide(10,0));

    }

    public static int divide(int a, int b) {
        try{
            System.out.println("Inside Try Block");
            return a/b;
        }
        catch(Exception e){
            System.out.println(e);
            return -1;
        }
        finally{
            System.out.println("Inside Finally Block");
        }

    }
}

/*
first try will print, exception after that
then finally will print and then -1
 */


/*

In Java, the finally keyword is used in conjunction with try and catch blocks to ensure
that a specific block of code is executed regardless of whether an exception is thrown or handled.
The finally block is particularly useful for resource management tasks like closing files,
releasing network connections, or cleaning up other resources that must be done even if an exception occurs.
 */
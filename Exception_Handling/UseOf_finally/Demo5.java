package Exception_Handling.UseOf_finally;

public class Demo5 {
    public static void main(String[] args) {
        try{
            System.out.println("Inside Try Block");
            int result = 10/0;
        }catch(ArithmeticException e){
            System.out.println(e);

        }
        finally{
            System.out.println("Inside Finally Block");
        }
    }
}

/*
First try block will print
then exception and then finally
 */
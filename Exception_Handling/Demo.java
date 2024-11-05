package Exception_Handling;

public class Demo {
    public static void main(String[] args) {
        int[] numerator = {20, 6, 30, 100};
        int[] denominator = {5, 4, 0, 2};

       // for (int i = 0; i < numerator.length; i++) {
        for (int i = 0; i < 6; i++) {

            //Handling Index out of bound exception
            try{
                System.out.println(divide(numerator[i], denominator[i]));
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e);
            }
        }

        System.out.println("Results.");
    }

    public static int divide(int a, int b){
        // Handling arithmetic exception

        try{
            return a/b;
        }
        catch(ArithmeticException e){
            System.out.print(e);
            return 0;
        }

    }

}

/*
Exception is an event that disrupts the normal flow of program.
It is an object which is thrown at run time.
 */

/*
We can have multiple catch blocks
 */

//public class Demo {
//    public static void main(String[] args) {
//        int[] numerator = {20, 6, 30, 100};
//        int[] denominator = {5, 4, 0, 2};
//
//        // for (int i = 0; i < numerator.length; i++) {
//        for (int i = 0; i < 6; i++) {
//
//            //Handling Index out of bound exception
//            try{
//                System.out.println(divide(numerator[i], denominator[i]));
//            } catch (IndexOutOfBoundsException e) {
//                System.out.println(e);
//            }
//            catch(NullPointerException e){
//                System.out.println(e);
//            }
//            catch(ArithmeticException e){
//                System.out.println(e);
//            }
//        }
//
//        System.out.println("Results.");
//    }
//
//    public static int divide(int a, int b){
//        // Handling arithmetic exception
//
//        try{
//            return a/b;
//        }
//        catch(ArithmeticException | ArrayIndexOutOfBoundsException | NullPointerException e){
//            System.out.print(e);
//            return 0;
//        }
//// This is another way in which we've collapsed catch blocks.
//
//    }
//
//}


/*
If we take parent type (Exception) the, we dont need to write multiple type of exceptions,
it will handle exception of anytime by itself.
 */

//public class Demo {
//    public static void main(String[] args) {
//        int[] numerator = {20, 6, 30, 100};
//        int[] denominator = {5, 4, 0, 2};
//
//        // for (int i = 0; i < numerator.length; i++) {
//        for (int i = 0; i < 6; i++) {
//
//            //Handling Index out of bound exception
//            try{
//                System.out.println(divide(numerator[i], denominator[i]));
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//        }
//
//        System.out.println("Results.");
//    }
//
//    public static int divide(int a, int b){
//        // Handling arithmetic exception
//
//        try{
//            return a/b;
//        }
//        catch(Exception e){
//            System.out.print(e);
//            return 0;
//        }
//
//    }
//
//}
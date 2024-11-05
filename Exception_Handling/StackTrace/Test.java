package Exception_Handling.StackTrace;

public class Test {
    public static void main(String[] args) {

        try{
            level1();
        }

//        catch(Exception o){
//            StackTraceElement[] st = o.getStackTrace();
//            for(StackTraceElement ste : st){
//                System.out.println(ste);
//            }

        catch (Exception o){
            o.printStackTrace();
        }


        }


    public static void level3(){
        int[] arr = new int[3];
        arr[5] = 10;
    }

    public static void level2(){
        level3();
    }

    public static void level1(){
        level2();
    }


}

/*
NullPointer, ArrayIndexOutOfBound, Arithmetic
these all are unchecked exceptions,
compiler will not give error at compile time.
 */
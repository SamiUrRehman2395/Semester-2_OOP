package Exception_Handling.throw_throws;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Demo3 {
    public static void main(String[] args)  {

        //method();

    }


    //    public static void method() throws FileNotFoundException {
//        throw new Exception();
//        }
//        gives red line, because can't have parent type as throw while throwing child class



//    public static void method(){
//        throw new Exception();
//    }
//    gives red line because parent class "Exception" contains both unchecked and checked exceptions


//    public static void method(){
//        throw new ArithmeticException();
//    }

    //not giving red line because Arithmetic exception is unchecked

}


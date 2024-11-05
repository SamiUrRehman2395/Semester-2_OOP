package Exception_Handling.throw_throws;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) throws FileNotFoundException {

        level2();

        System.out.println("Hello World");
    }

    public static void level2() throws FileNotFoundException {
        level1();
    }

    public static void level1() throws FileNotFoundException {
        try{

            FileReader fileReader = new FileReader("a.txt");
        }
        catch(FileNotFoundException e){
            System.out.println("File Not Found");
            throw new FileNotFoundException("OOPS");
        }


    }
}

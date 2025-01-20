import java.util.ArrayList;

public class Demo2 {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println(list.get(0));
       // list.remove(0);
        boolean c = list.contains("C");
        System.out.println(c);



    }
}

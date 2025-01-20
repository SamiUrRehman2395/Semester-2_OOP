package generics;

public class Main {
    public static void main(String[] args) {

        Integer[] in = {1,2,3,4};

        Box<Integer> b1 = new Box<>();
        b1.setItem(25);

        System.out.println(b1.getItem());

        Box<String> s1 = new Box<>();
        s1.setItem("A");
        System.out.println(s1.getItem());
    }
}

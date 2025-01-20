public class Demo1 {
    public static void main(String[] args) {

        String s1 = "Hello";
        String s2 = "World";
        String s3 = s2;
        String s4 = "Hello";

        if(s3==s2 && s1==s4){
            System.out.println("True");
            System.out.println(s3);
            System.out.println(s2);
            System.out.println();
            System.out.println(s1);
            System.out.println(s4);
        }
        else{
            System.out.println("False");
        }


    }
}

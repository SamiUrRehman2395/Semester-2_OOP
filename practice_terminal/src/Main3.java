class Parent {
    static int staticNum = 50;
    int instanceNum = 100;
}

class Child extends Parent {
    static int staticNum = 150;
    int instanceNum = 200;

    void show() {
        System.out.println("Child staticNum: " + staticNum);
        System.out.println("Parent staticNum: " + Parent.staticNum);
        System.out.println("Child instanceNum: " + instanceNum);
        System.out.println("Parent instanceNum: " + super.instanceNum);
    }
}

public class Main3 {
    public static void main(String[] args) {
        Child obj = new Child();
        obj.show();
    }
}

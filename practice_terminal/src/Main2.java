class Base {
    static {
        System.out.println("Base: Static Block");
    }

    {
        System.out.println("Base: Instance Block");
    }

    Base() {
        System.out.println("Base: Constructor");
    }

    static int baseStaticVar = initializeBaseStaticVar();

    int baseInstanceVar = initializeBaseInstanceVar();

    static int initializeBaseStaticVar() {
        System.out.println("Base: Static Variable Initialized");
        return 100;
    }

    int initializeBaseInstanceVar() {
        System.out.println("Base: Instance Variable Initialized");
        return 200;
    }

    public static void baseStaticMethod() {
        System.out.println("Base: Static Method");
    }
}

class Derived extends Base {
    static {
        System.out.println("Derived: Static Block");
    }

    {
        System.out.println("Derived: Instance Block");
    }

    Derived() {
        System.out.println("Derived: Constructor");
    }

    static int derivedStaticVar = initializeDerivedStaticVar();

    int derivedInstanceVar = initializeDerivedInstanceVar();

    static int initializeDerivedStaticVar() {
        System.out.println("Derived: Static Variable Initialized");
        return 300;
    }

    int initializeDerivedInstanceVar() {
        System.out.println("Derived: Instance Variable Initialized");
        return 400;
    }

    public static void derivedStaticMethod() {
        System.out.println("Derived: Static Method");
    }
}

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Main Method Started");
        Derived.derivedStaticMethod();
        System.out.println("Creating Derived Object");
        Derived obj = new Derived();
        System.out.println("Main Method Ended");
}
}

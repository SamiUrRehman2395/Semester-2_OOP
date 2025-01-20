class Other {


    public static void staticMethod()
    {
        System.out.println("static Method called");
    }

    static int x = initializeStaticVar();
     // static variable
    int y=initializeNonStaticVar();


    Other()
    {
        System.out.println("Contructor called");
    }

    static
    {
        System.out.println("Static block Called.");
    }


    {
        System.out.println("non static block");
    }


    public static int initializeStaticVar()
    {
        System.out.println("static variable initialized ");
        return 20;
    }
    public int initializeNonStaticVar()
    {
        System.out.println("non static variable initialized ");
        return 20;
    }



    public void nonstatic()
    {
        System.out.println("non static method");
    }






}
class main
{
    public static void main(String[] args) {
        System.out.println("main called");
        Other.staticMethod();
        Other o1=new Other();

}
}
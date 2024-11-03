package Interfaces;

public class Test {
    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.eat();
        dog.sleep();

        Cat cat = new Cat();
        cat.makingNoice(); //default method called

        System.out.println(Dog.MAX_AGE);
        System.out.println(Animal.MAX_AGE);

        Animal.drinking(); //static method called
    }
}

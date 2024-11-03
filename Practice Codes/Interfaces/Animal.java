package Interfaces;

interface Animal {

    int MAX_AGE = 5; //public static final

    void eat(); //public abstract by default
    void sleep();

    default void makingNoice(){
        this.eat();
        this.sleep();
        System.out.println("Making noice");
    }

    static void drinking(){
        System.out.println("Animal is Drinking");
    }
}




/*
Interfaces

to achieve multiple inheritance, and pure abstraction
blue print for class
only abstract method
static constants
inteface is public static final

methods in interface are abstract by defaut, no need to write absract wtih them
public too
 */
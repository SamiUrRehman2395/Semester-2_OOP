class Shape {
    public static void calculateArea() {
        System.out.println("Calculating area of unknown shape.");
    }

    public void area(double radius) {
        System.out.println("Shape area: " + (Math.PI * radius * radius));
    }

    public void area(double length, double width) {
        System.out.println("Shape area: " + (length * width));
    }

    public void display() {
        System.out.println("Displaying Shape");
    }
}

class Circle extends Shape {
    public static void calculateArea() {
        System.out.println("Calculating area of Circle (Static method).");
    }

    @Override
    public void area(double radius) {
        System.out.println("Circle area: " + (Math.PI * radius * radius));
    }

    @Override
    public void display() {
        System.out.println("Displaying Circle");
    }
}

class Rectangle extends Shape {
    public static void calculateArea() {
        System.out.println("Calculating area of Rectangle (Static method).");
    }

    @Override
    public void area(double length, double width) {
        System.out.println("Rectangle area: " + (length * width));
    }

    @Override
    public void display() {
        System.out.println("Displaying Rectangle");
    }
}

class Square extends Rectangle {
    public static void calculateArea() {
        System.out.println("Calculating area of Square (Static method).");
    }

    @Override
    public void area(double length, double width) {
        System.out.println("Square area: " + (length * width));
    }

    @Override
    public void display() {
        System.out.println("Displaying Square");
    }
}

public class ShapeTest {
    public static void main(String[] args) {
        Shape shape = new Shape();
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Square square = new Square();

        // Static method calls
        Shape.calculateArea();      // Calls Shape's static method
        Circle.calculateArea();     // Calls Circle's static method
        Rectangle.calculateArea();  // Calls Rectangle's static method
        Square.calculateArea();     // Calls Square's static method

        System.out.println("\n--- Dynamic Dispatch ---");

        // Dynamic method dispatch
        Shape myShape = new Circle();
        myShape.display();  // Calls Circle's display method due to dynamic dispatch
        myShape.area(5.0);  // Calls Circle's area method due to dynamic dispatch

        Shape myRectangle = new Rectangle();
        myRectangle.display();  // Calls Rectangle's display method due to dynamic dispatch
        myRectangle.area(4.0, 6.0);  // Calls Rectangle's area method due to dynamic dispatch

        Shape mySquare = new Square();
        mySquare.display();  // Calls Square's display method due to dynamic dispatch
        mySquare.area(4.0, 4.0);  // Calls Square's area method due to dynamic dispatch

        // Overloading
        System.out.println("\n--- Method Overloading ---");
        shape.area(3.0);          // Calls Shape's area method for circle
        shape.area(4.0, 5.0);     // Calls Shape's area method for rectangle
    }
}

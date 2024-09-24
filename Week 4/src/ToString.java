class Laptop{
    private String brand;
    private String model;
    private int price;


    public Laptop(String brand, String model, int price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';

    }
}


public class ToString {
    public static void main(String[] args) {

        Laptop obj1 = new Laptop("Lenovo", "X1 Yoga", 85000);

        System.out.println(obj1);
    }
}

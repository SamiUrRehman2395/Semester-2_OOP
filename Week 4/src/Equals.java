class Laptop2{
    private String brand;
    private String model;
    private int price;


    public Laptop2(String brand, String model, int price) {
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


     public boolean equals(Laptop that){

          this.model.equals(that.model) && this.price == that.price
                  return true;
     }

public class Equals {
    public static void main(String[] args) {

    }
}

class Pizza{
    private String name;
    private int price;

    Pizza(String name){
        setName(name);
    }

    Pizza(String name, int price){
        this(name);
        //or we can do this
        //setName(name);
        setPrice(price);

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

public class Constructors {
    public static void main(String[] args) {

        Pizza pizza = new Pizza("Pizza", 2199);

        Pizza pizza2 = new Pizza("Pizza");

        System.out.println(pizza.getName());
        System.out.println(pizza.getPrice());
    }
}

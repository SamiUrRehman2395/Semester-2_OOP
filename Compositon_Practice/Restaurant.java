class Dish{
    private String name;
    private int price;

    public void setName(String name) {this.name = name;}
    public void setPrice(int price) { this.price = price; }
    public String getName() { return name; }
    public int getPrice() { return price; }

    public void display() {
        System.out.println("Item Name: " + name);
        System.out.println("Price: " + price);
    }
}

class Menu{
    private String name;
    private Dish burger;
    private Dish pizza;

    public void setName(String name) {this.name = name;}
    public void setBurger(Dish burger) {this.burger = burger;}
    public void setPizza(Dish pizza) { this.pizza = pizza; }

    public String getName() {return name;}
    public Dish getBurger() { return burger; }
    public Dish getPizza() { return pizza; }

    public void displayInfo() {
        System.out.println("Restaurant Name: " + name);
        burger.display();
        pizza.display();
    }
}

public class Restaurant {
    public static void main(String[] args) {

        Menu menu = new Menu();

        menu.setName("Hungry Cafe");

        Dish dish1 = new Dish();
        dish1.setName("Smashed Beef Burger");
        dish1.setPrice(1010);

        Dish dish2 = new Dish();
        dish2.setName("Chicken Fajita Pizza");
        dish2.setPrice(2199);

        menu.setBurger(dish1);
        menu.setPizza(dish2);

        menu.displayInfo();


    }
}

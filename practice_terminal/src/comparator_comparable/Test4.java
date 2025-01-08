package comparator_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test4 {
    public static void main(String[] args) {


        List<Product> list = new ArrayList<Product>();
        list.add(new Product(1,"Pizza", 2199));
        list.add(new Product(4,"Burger", 749));
        list.add(new Product(3,"Sandwich", 549));
        list.add(new Product(2,"Wrap", 699));

        Collections.sort(list);
        System.out.println(list);
    }
}

class Product implements Comparable<Product>{



    int id;
    String name;
    int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "comparator_comparable.Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Product that) {
        if(this.id > that.id){
            return 1;
        }
        else{
            return -1;
        }

    }
}
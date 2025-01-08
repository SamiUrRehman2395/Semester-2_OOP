package comparator_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test5 {
    public static void main(String[] args) {

        Comparator<Players> com = (Players p1, Players p2)-> p1.jersey>p2.jersey?1:-1;

        List<Players> list = new ArrayList<Players>();

        list.add(new Players("Martin Guptill","New Zealand",31));
        list.add(new Players("Mitchell Starc","Australia",56));
        list.add(new Players("Ben Stokes","England",55));
        list.add(new Players("AB Deviliers","South Africa",17));

        Collections.sort(list, com);

        System.out.println(list);
    }
}

class Players{
    String name;
    String country;
    int jersey;

    public Players(String name, String country, int jersey) {
        this.name = name;
        this.country = country;
        this.jersey = jersey;
    }

    @Override
    public String toString() {
        return "comparator_comparable.Players{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", jersey=" + jersey +
                '}';
    }
}
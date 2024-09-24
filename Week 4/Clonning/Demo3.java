class Address{
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public Address clone() {
        return new Address(street, city);
    }
}

class Person{
    private String name;

    private Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

//    public Person clone() {
//        return new Person(name, address); //shallow copy
//    }

    public Person clone() {
        return new Person(name, address.clone()); //deep copy
    }
}



public class Demo3 {
    public static void main(String[] args) {

        Person p1 = new Person("John", new Address("123 Main St", "New York"));

        System.out.println("Original Person: " + p1);

        Person p2 = p1.clone();

        System.out.println("Cloned Person: " + p2);

        p2.getAddress().setCity("Los Angeles");
        p2.getAddress().setStreet("456 Park Ave");

        System.out.println("\nAfter modifying the cloned person's address:");
        System.out.println("Original Person: " + p1);
        System.out.println("Cloned Person: " + p2);

    }
}

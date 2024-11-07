package Interface_Practice;

public abstract class Vehicle {
    protected String name;


    public Vehicle(String name) {
        this.name = name;
    }

    public void FourWheeler() {
        System.out.println("FourWheel Vehicle");
    }

    public String getName() {
        return name;
    }
}

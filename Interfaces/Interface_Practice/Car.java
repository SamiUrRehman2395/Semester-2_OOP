package Interface_Practice;

public class Car extends Vehicle implements Accelerator, Brake, Clutch{
    @Override
    public void functionalities() {
        System.out.println("Car functionalities");
    }

    public Car(String name) {
        super(name);
    }

    @Override
    public void accelerate() {
        System.out.println("Car accelerate");
    }

    @Override
    public void applyBrake() {
        System.out.println("Apply Brake");
    }

    @Override
    public void pressClutch() {
        System.out.println("Pressed clutch");
    }

    public void sunRoof(){
        System.out.println("SunRoof is opening");
    }
}

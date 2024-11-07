package Interface_Practice;

public class Bus extends Vehicle implements Accelerator, Brake, Clutch{
    @Override
    public void functionalities() {
        System.out.println("Bus functionalities");
    }

    public Bus(String name) {
        super(name);
    }

    @Override
    public void accelerate() {
        System.out.println("Bus accelerate");
    }

    @Override
    public void applyBrake() {
        System.out.println("Bus apply brake");
    }

    @Override
    public void pressClutch() {
        System.out.println("Bus press clutch");
    }
}

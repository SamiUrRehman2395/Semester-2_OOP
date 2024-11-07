package Interface_Practice;

public class Test {
    public static void main(String[] args) {

        Vehicle v = new Car("Mercedes");

        ((Brake)v).applyBrake();

        ((Car)v).accelerate();
        ((Car)v).pressClutch();

        Car c = new Car("Mercedes");
        c.pressClutch();
        c.accelerate();
        c.applyBrake();

        Accelerator a = new Car("Mercedes");
        a.accelerate();

        System.out.println(((Car)a).getName());

        ((Car)a).pressClutch();

        ((Car)a).applyBrake();

        Clutch c2 = new Car("Mercedes");
        c2.pressClutch();

        ((Car)c2).sunRoof();

        Brake b = new Car("Mercedes");
        b.applyBrake();

        ((Vehicle)b).FourWheeler();
        ((Car)b).FourWheeler();


        if(b instanceof Vehicle){
            Car obj = (Car)b;
            obj.functionalities();
            obj.FourWheeler();
        }

        //_________________________________________________________________________

        Vehicle v2 = new Bus("High Roof VH8");
//        ((Bus)v2).accelerate();
//        ((Bus)v2).pressClutch();
//        ((Bus)v2).applyBrake();
//
//        System.out.println(v2.getName());
//
//        v2.FourWheeler();

        if(v2 instanceof Bus){
            Bus obj = ((Bus)v2);
            obj.accelerate();
            return;
        }
        System.out.println("Not an instance of Bus");
    }
}

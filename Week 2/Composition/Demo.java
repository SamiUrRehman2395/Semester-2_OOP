public class Demo{
    public static void main(String args[]){

        ServiceStation s = new ServiceStation();
        s.setStationName("City Auto Service");
  
        Car a = new Car();
        a.setModel("Hyundai Sonata");
        a.setOwner("Mr. James");
        a.setService("Oil Change");

        Car b = new Car();
        b.setModel("Suzuki Swift");
        b.setOwner("Mr. Anderson");
        b.setService("Brakes Inspection");

        s.setCar1(a);
        s.setCar2(b);

        s.displayInfo();

    }



}
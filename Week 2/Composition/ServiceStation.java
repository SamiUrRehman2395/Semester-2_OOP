public class ServiceStation{
    private String stationName;
    private Car car1;
    private Car car2;

    public void setStationName(String sn){
        stationName = sn;
    }
    public void setCar1(Car c1){
        car1 = c1;
    }
    public void setCar2(Car c2){
        car2 = c2;
    }
    public String getStationName(){
        return stationName;
    }
    public Car getCar1(){
        return car1;
    }
    public Car getCar2(){
        return car2;
    }


    public void displayInfo(){
        System.out.println("Serivce Station Name: "+stationName);
        car1.display();
        car2.display();
    }




}
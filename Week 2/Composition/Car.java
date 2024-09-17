public class Car{
    private String model;
    private String owner;
    private String service;

    public void setModel(String model){
        this.model=model;
    }
    public void setOwner(String owner){
        this.owner=owner;
    }
    public void setService(String service){
        this.service=service;
    }
    public String getModel(){
        return model;
    }
    public String getOwner(){
        return owner;
    }
    public String getService(){
        return service;
    }

    public void display(){
        System.out.println("Car Model: "+model);
        System.out.println("Car Owner: "+owner);
        System.out.println("Service Type: "+service);
    }

}
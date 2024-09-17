public class Employee{
   
    private int id;
    private String name;

    Address postalAddress;

    String streetAddress;


    public Employee(int id, String name){

          this.id = id;
          this.name = name;
    }


    public void setId(int id){

          this.id = id;
    }
    public void setName(String name){

          this.name = name;
    }
     public int getId(){

          this.name = name;
    }
     public String getName(){

          this.name = name;
    }


     public void setPostalAddress(Address postalAddress){
          
           this.postalAddress = postalAddress;
    }
     public Address getPostalAddress(){
          
           return postalAddress;
    }



}
class Owner{

      private String name;
      private String email;

      Owner(){
         
          name = "No Name";
          email = "No Email";
      }

      Owner(String name, String email){

          this.name = name;
          this.email = email;
      }

      public void setName(String name){

          this.name = name;
      }

      public void setEmail(String email){

          this.email = email;
      }

      public String getName(){

          return name;
      }

      public String getEmail(){

          return email;
      }



	// copy constructor
	Owner(Owner a){
		name= a.getName();
		email=a.getEmail();

	}


      public void display(){

          System.out.println("Name: "+name);

          System.out.println("Email: "+email);
      }



}




class Bike{

      private String brand;
      private String model;

      private Owner owner;

      Bike(){
         
          brand = "No Brand";
          model = "No Model";

          owner = new Owner();
      }

      Bike(String brand, String model, Owner owner){

          this.brand = brand;
          this.model = model;

          this.owner = owner;
      }

      public void setBrand(String brand){

          this.brand = brand;
      }

      public void setModel(String model){

          this.model = model;
      }

      public String getBrand(){

          return brand;
      }

      public String getModel(){

          return model;
      }

      public Owner getOwner(){

          return owner;
      }

      public void setOwner(Owner owner){

          this.owner = owner;
      }



	Bike(Bike bike){

		this.model = bike.getModel();
		this.brand = bike.getBrand();
		this.owner = new Owner(bike.getOwner());

		
	}




      public void display(){

          System.out.println("Brand: "+brand);

          System.out.println("Model: "+model);

          owner.display();
      }




}



public class CopyConstructor{
    public static void main(String[]args){

        Owner a1 = new Owner();
        a1.display();

// it will call constructor with no argument



        Owner a2 = new Owner("Sami", "sami@gmail.com");

    //    a2.setEmail("sami@yahoo.mail");

        a2.display();

    //    a2.setEmail("sami@yahoo.mail");

// it will call display of ownwer class to display name and email of owner

        Owner temp = a2;
        temp.display(); //this is the replica of a2, if we change the value of a2, it will change temp too

    // temp = a2 , both have same address, so its not a copy

        temp.setEmail("Sp24-Bse-086");
        
        a2.display();
    // changing the temp, will change a2 as well

       System.out.println("********************");



		Owner a3= new Owner(a2);

		temp.setName("Sami Ur Rehman");
		
		a2.display();

		System.out.println();
		temp.display();

		System.out.println(a2);
		System.out.println(a3);
//both has different address



                a3.display(); 
// because we make copy constructor object 'a3' before setting name to "Sami ur Rehman"
// so it will print "sami", because they copy has been made before updating the name



           System.out.println(" \n"+ "**************\n" +" ");

          

             Bike b1 = new Bike("BMW", "S-1000RR", new Owner("Sami", "sami@hotmail.com"));
             b1.display();

           System.out.println(" \n"+ "**************\n" +" ");

        //       Bike b2 = new Bike(b1.getBrand(), b1.getModel(), b1.getOwner());
        //       b2.display();

           System.out.println(" \n"+ "**************\n" +" ");

        //     Bike b2 = new Bike(b1.getBrand(), b1.getModel(), new Owner(b1.getOwner()));
         //      b2.display();




           System.out.println(" \n"+ "**************\n" +" ");




               	Bike b2= new Bike(b1);
		b1.setModel("M-1000 R");
		//b1.setOwner(new Owner());

		b1.getOwner().setEmail("sami@yahoomail.com");

		System.out.println("===========");
		b1.display();
                
 
		System.out.println("===========");               

		b2.display();

   }

}
class Rectangle{

    int width = 2;
    int length = 2;

    int calArea(){

      return width*length;
     }

     int calPerimeter(){
       
      return (length+width)*2;

     }


}

public class Driver{
     
    public static void main(String[]args){

    
    Rectangle r = new Rectangle();

    r.calArea();
    r.calPerimeter();


}



}
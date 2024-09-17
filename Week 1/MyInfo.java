public class MyInfo{


  public static void main(String[]args){

     String name = "Sami Ur Rehman";
     String reg  = "SP24-BSE-086";
     char section = 'B';
     float cgpa = 3.1f;


     System.out.printf("%-15s : %s\n ", "Registration No", reg);
     System.out.printf("Name: %-8s\n", name);
     System.out.printf("Section: %-8c\n", section);
     System.out.printf("CGPA: %-8f\n", cgpa);
     

}

}
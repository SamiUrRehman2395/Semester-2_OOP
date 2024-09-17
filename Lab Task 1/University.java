public class University{

   private String UniName;
   private Campus ISB;
   private Campus LHR;

   public void setUniName(String un){

       UniName = un;
  }
  public String getUniName(){

       return UniName;
  }

  public void setIsb(Campus isb){

       ISB = isb;
  }
  public void setLhr(Campus lhr){

       LHR = lhr;
  }
  public Campus getIsb(){

       return ISB;
  }
  public Campus getLhr(){

       return LHR;
  }

  public void displayUni(){
  System.out.println("University Name: " + uni.getName());
  c.Display();

  }
  

}
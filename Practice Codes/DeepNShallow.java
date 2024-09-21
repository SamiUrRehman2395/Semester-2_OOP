
class Event{
    
    private String eventName;

    public Event(Event e){
        this.eventName = e.getEventName();

    }

     Event(String eventName){
        this.eventName = eventName;

    }
    Event(){
        this.eventName = eventName;

    }

    public void setEventName(String eventName){
       this.eventName = eventName;



    }
    public String getEventName(){
       return eventName;
    }




}

class Artist{

    private String artistName;
    private String artistCountry;
    private int artistAge;



// copy constructor
   Artist (Artist ab){
       this.artistName = ab.getArtistName();
       this.artistCountry = ab.getArtistCountry();
       this.artistAge = ab.getArtistAge();

   }


   Artist(String artistName){
        this.artistName = artistName;

   }

   Artist(String artistName, String artistCountry){
        this.artistName = artistName;
        this.artistCountry = artistCountry;

   }

   Artist(String artistName, String artistCountry, int artistAge ){
        this.artistName = artistName;
        this.artistCountry = artistCountry;
        this.artistAge = artistAge;

   }

   Artist(){
      artistName = "Unknown";
   }

/*   Artist(){
        artistName = "Unknown";
	artistCountry = "Unknown";
	artistAge = 0;
   }
*/


    public void setArtistAge(int artistAge){
      
       this.artistAge = artistAge;

    }


    public int getArtistAge(){
      
       return artistAge;

    }

    public void setArtistCountry(String artistCountry){
      
       this.artistCountry = artistCountry;

    }


    public String getArtistCountry(){
      
       return artistCountry;

    }

    public void setArtistName(String artistName){
      
       this.artistName = artistName;

    }

    public String getArtistName(){
      
       return artistName;

    }



 /* 

      public void displayArtist(){

           System.out.println("Artist Name: "+artistName);

 
     }

*/


}








class ArtWork{

      private String title;
      private int year;

      private Artist artist;
      
      private Event event;



      public ArtWork shallowCopy(ArtWork sh){

             ArtWork art1 = new ArtWork(sh.getTitle(), sh.getYear(), sh.getArtist(), sh.getEvent());

             return art1;

      }

      public ArtWork deepCopy(ArtWork dp){

            ArtWork art2 = new ArtWork(dp.getTitle(), dp.getYear(), new Artist(dp.getArtist().getArtistName(),dp.getArtist().getArtistCountry(),dp.getArtist().getArtistAge()), new Event(dp.getEvent().getEventName()));

        //  ArtWork art2 = new ArtWork(dp.getTitle(), dp.getYear(), new Artist(dp.getArtist()), new Event(dp.getEvent()));

            return art2;
      }

   
/* 

      // copy construtor


       ArtWork(ArtWork aw){

             this.title = aw.getTitle();
             this.year = aw.getYear();

      //     this.artist = aw.getArtist();  // for shallow copy

             this.artist = new Artist(aw.getArtist());   // deep copy
   }


*/





   ArtWork(String title, int year){

     this.title = title;
     this.year = year;

     this.artist = new Artist("Unknown Artist", "Unknown", 0);
     this.event = new Event("No Name");


   }


   ArtWork(String title, int year, Artist artist, Event event){

        this.title = title;
        this.year = year;
        this.artist = artist;
        this.event = event;


   }

   public void setTitle(String title){

         this.title = title;

   }

   public void setYear(int year){

         this.year = year;

   }

   public void setArtist(Artist artist){

         this.artist = artist;

   }

   public String getTitle(){

         return title;

   }

   public int getYear(){

         return year;

   }

   public Artist getArtist(){

         return artist;

   }





   public void setEvent(Event event){

         this.event = event;

   }

   public Event getEvent(){

         return event;

   }



   public void displayArtWork(){


      System.out.println("Event Name: "+event.getEventName());
      //System.out.println("*********************************");
      System.out.println("Title: "+title);
      System.out.println("Year: "+year);
      System.out.println("Artist Name: "+artist.getArtistName());
      System.out.println("Artist Country: "+artist.getArtistCountry());
      System.out.println("Artist Age: "+artist.getArtistAge());

   }



}




public class DeepNShallow{

    public static void main(String[]args){


       //Artist a1 = new Artist();

       ArtWork w1 = new ArtWork("Title Of Work", 2010 , new Artist("Josh Philips", "Australia", 32), new Event("The Event Name"));

       ArtWork w2 = new ArtWork("Title Of Work", 2010);

      System.out.println("____________________________________");
      System.out.println("With Unknown Artist");
      System.out.println("____________________________________");
      w2.displayArtWork();

      System.out.println("______________________________________");
      System.out.println("For Shallow Copy (Before Modification)");
      System.out.println("______________________________________");

      System.out.println("Original :- \n");
      w1.displayArtWork();




     ArtWork w3 = w1.shallowCopy(w1);
     System.out.println("\nShallow Copy:- \n");
     w3.displayArtWork();

     



     System.out.println("____________________________________");
     System.out.println("After Modification ");
     System.out.println("____________________________________");



       w1.getArtist().setArtistName("Alex Carey");
       w1.getArtist().setArtistAge(35);
       w1.getEvent().setEventName("The new Event Name 1");

       System.out.println("Original :- \n");
       w1.displayArtWork();

       System.out.println("\nShallow Copy:- \n");
       w3.displayArtWork();

    



      System.out.println("____________________________________");
      System.out.println("For Deep Copy (Before Modification)");
      System.out.println("____________________________________");



       System.out.println("Original :- \n");
       w1.displayArtWork();


       System.out.println("\nDeep Copy\n");

       ArtWork w4 = w1.deepCopy(w1);
  
       w4.displayArtWork();




       System.out.println("____________________________________");
       System.out.println("After Modification");
       System.out.println("____________________________________");

       w1.getArtist().setArtistName("Jason Gillispe");
       w1.getArtist().setArtistAge(47);
       w1.getEvent().setEventName("The new Event Name 2");


       System.out.println("\nOriginal:- \n"); 
       w1.displayArtWork(); 

       System.out.println("\nDeep Copy\n");
       w4.displayArtWork();



    }


}
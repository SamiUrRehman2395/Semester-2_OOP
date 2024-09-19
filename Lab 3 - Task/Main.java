class Artist{
    private String artistName;



// copy constructor
   Artist (Artist ab){
       this.artistName = ab.getArtistName();

   }


   Artist(String artistName){
        this.artistName = artistName;

   }
   Artist(){
      artistName = "Unknown";
   }


    public void setArtistName(String artistName){
      
       this.artistName = artistName;

   }

    public String getArtistName(){
      
       return artistName;

   }



 /*   public void displayArtist(){

    System.out.println("Artist Name: "+artistName);


    }
*/


}



class ArtWork{

   private String title;
   private int year;

   private Artist artist;




//copy constructor.

   ArtWork(ArtWork aw){

       this.title = aw.getTitle();
       this.year = aw.getYear();

      // this.artist = aw.getArtist();  // for shallow copy

       this.artist = new Artist(aw.getArtist());   // deep copy
   }





   ArtWork(String title, int year){

     this.title = title;
     this.year = year;

     this.artist = new Artist("Unknown Artist");




   }
   ArtWork(String title, int year, Artist artist){

        this.title = title;
        this.year = year;
        this.artist = artist;


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

   public void displayArtWork(){
     
      System.out.println("Title: "+title);
      System.out.println("Year: "+year);
      System.out.println("Artist Name: "+artist.getArtistName());

   }



}



public class Main{

    public static void main(String[]args){


       //Artist a1 = new Artist();

       ArtWork w1 = new ArtWork("Title Of Work", 2010 , new Artist("Josh Philips"));

       ArtWork w2 = new ArtWork("Title Of Work", 2010);


       System.out.println("original :- \n");
      w1.displayArtWork();

 System.out.println("\nwith unknown artist \n");
      w2.displayArtWork();


     ArtWork w3 = new ArtWork(w1);
    System.out.println("\ncopy:- \n");
     w3.displayArtWork();

     System.out.println("__________________________");

     System.out.println("After deep copy and changing original ");


       w1.getArtist().setArtistName("Alex Carey");
 System.out.println("original :- \n");
       w1.displayArtWork();
    
     System.out.println(" ");
     System.out.println("copy:- \n");
       w3.displayArtWork();




  ArtWork w5 = new ArtWork("Title Of Work", 2010 , new Artist("Josh Philips"));

  ArtWork w6 = new ArtWork(w5);


    }





}
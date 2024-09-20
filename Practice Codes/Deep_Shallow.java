class Actor{
      private String actorName;
     
      public void setActorName(String actorName){

this.actorName = actorName;

}

public String getActorName(){

        return actorName;
}

Actor(){

    actorName = "unknown";
}

Actor(String actorName){
      this.actorName = actorName;
}

Actor(Actor a){

this.actorName = a.getActorName();
}

}

class Movie{

private String movieName;
private int releaseYear;

private Actor actor;

public Movie shallowCopy(Movie m){

Movie m1 = new Movie(m.getMovieName(), m.getReleaseYear(), m.getActor());

return m1;
}

public Movie deepCopy(Movie n){

Movie m2 = new Movie(n.getMovieName(), n.getReleaseYear(), new Actor(n.getActor().getActorName()));

return m2;
}

Movie(String movieName, int releaseYear, Actor actor){

this.movieName = movieName;
this.releaseYear = releaseYear;
this.actor = actor;

}

public void setMovieName(String movieName){

this.movieName = movieName;
}

public void setReleaseYear(int releaseYear){

this.releaseYear = releaseYear;
}

public void setActor(Actor actor){

this.actor = actor;
}

public String getMovieName(){

return movieName;
}

public int getReleaseYear(){

return releaseYear;
}

public Actor getActor(){

return actor;
}

public void display(){

System.out.println("Actor Name: "+ actor.getActorName());

System.out.println("Movie: "+movieName);


System.out.println("Release Year: "+releaseYear);

}

}

public class Deep_Shallow{

public static void main(String []args){

Movie movie1 = new Movie("Shiddat", 2021, new Actor("Radhika Madan"));
System.out.println("\n-----------------\n");
movie1.display();


Movie movie2 = movie1.shallowCopy(movie1);

Movie movie3 = movie1.deepCopy(movie1);

movie1.getActor().setActorName("Sunny Kaushal");

System.out.println("\n-----------------\n");
System.out.println("\nShallow Copy and Original \n");
movie2.display();
System.out.println("\n\n");
movie1.display();

System.out.println("\n-----------------\n");
System.out.println("\nDeep Copy and Original \n");
movie3.display();
System.out.println("\n\n");
movie1.display();

}

}


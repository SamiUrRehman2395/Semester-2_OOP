class Author {
    private String name;
    private String email;


    Author() {
        this.name = "Unknown Author";
        this.email = "Unknown Email";
    }


    Author(String name, String email) {
        this.name = name;
        this.email = email;
    }


    Author(Author author) {
        this.name = author.name;
        this.email = author.email;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }


    public void display() {
        System.out.println("Author Name: " + name);
        System.out.println("Author Email: " + email);
    }
}

class Book {
    private String title;
    private String genre;
    private double price;
    private Author author;


    Book() {
        this.title = "Unknown Title";
        this.genre = "Unknown Genre";
        this.price = 0.0;
        this.author = new Author();
    }


    Book(String title, String genre, double price, Author author) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.author = author;
    }


    Book(Book book) {
        this.title = book.title;
        this.genre = book.genre;
        this.price = book.price;
        this.author = new Author(book.author); // Deep copy of Author
    }


    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }


    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Genre: " + genre);
        System.out.println("Price: " + price);
        author.display();
    }
}

public class Library_Management_System {
    public static void main(String[] args) {
        // Create an author and book
        Author author1 = new Author("Jane Austen", "jane_austen@hotmail.com");
        Book book1 = new Book("Love and Prejudice", "Love", 15.00, author1);

 
        System.out.println("Original Book:");
        book1.display();

        // Create a copy of the book using the copy constructor
        Book book2 = new Book(book1);

        // Modify the copy's author details
        book2.getAuthor().setName("Mirza Asad Ullah Khan Ghalib");
        book2.getAuthor().setEmail("mirza.ghalib@yahoomail.com");

        book2.setTitle("Deewan-e-Ghalib");
        book2.setGenre("Poetry");

  
        System.out.println("\nModified Copy:");
        book2.display();


        System.out.println("\nOriginal Book After Modification to Copy:");
        book1.display();
    }
}


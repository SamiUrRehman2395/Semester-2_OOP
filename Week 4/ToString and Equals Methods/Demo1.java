class Book{
    private String title;
    private String author;
    private int price;


    public Book(String author, String title, int price) {
        this.author = author;
        this.title = title;
        this.price = price;
    }

    public boolean equals(Object o){
        Book that = (Book)o;

        return this.author.equals(that.author) && this.title.equals(that.title);
    }


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}

public class Demo1 {
    public static void main(String[] args) {

        Book b1 = new Book("John Doe", "Java Basics", 300);
//        System.out.println(b1);
        System.out.println(b1.toString());

        Book b2 = new Book("John Doe", "Java Basics", 400);
        System.out.println(b2.toString());

        boolean result = b1.equals(b2);
        System.out.println(result);
    }
}

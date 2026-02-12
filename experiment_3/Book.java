package experiment_3;
import java.time.*;
public class Book {
    public String name;
    public String author;
    public double price;
    public String publisherName;
    public String genre;
    public String ISBN;
    public LocalDate dateOfPublication;
    public Book(){
        name="unknown";
        author="unknown";
        publisherName="unspecified";
        genre="uncategorized";
        
        dateOfPublication=LocalDate.parse("2020-01-01");
    }
    public Book(String n,String a,double p,String isbn){
        name=n;
        author=a;
        price=p;
        ISBN=isbn;
    }
    public Book(String n,String a,String g,double p){
        name=n;
        author=a;
        genre=g;
        price=p;
    }
    public Book(Book b){
        name=b.name;
        author=b.author;
        price=b.price;
        publisherName=b.publisherName;
        genre=b.genre;
        ISBN=b.ISBN;
        dateOfPublication=b.dateOfPublication;
    }
}

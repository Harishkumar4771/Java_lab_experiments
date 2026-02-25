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
    public Book(String n,String a,double p,String isbn) throws InvalidPriceException{
        name=n;
        author=a;
        if(p<0){
            throw new InvalidPriceException("Price cannot be negative");
        }
        price=p;
        ISBN=isbn;
    }
    public Book(String n,String a,String g,double p )throws InvalidPriceException, InvalidGenreException{
         if(p<0){
            throw new InvalidPriceException("Price cannot be negative");
        }
        name=n;
        author=a;
        if(!g.equalsIgnoreCase("Fiction") && !g.equalsIgnoreCase("Autobiography") && !g.equalsIgnoreCase("Science") && !g.equalsIgnoreCase("History") && !g.equalsIgnoreCase("Life changer")){
            throw new InvalidGenreException("Genre must be one of the following: Fiction, Autobiography, Science, History, Life changer");
        }
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

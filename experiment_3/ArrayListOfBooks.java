package experiment_3;
import java.util.ArrayList;
import java.util.Scanner;
public class ArrayListOfBooks {
    public static void main(String args[]){
        Book b1=new Book();
        ArrayList<Book> bList=new ArrayList<Book>();
        bList.add(b1);
        try{
        Book b2=new Book("Eclipse","Stephenie Meyer","Fiction",455.50);
        bList.add(b2);
        Book b3=new Book("Atomic Habits","James Clear",899.99,"HLP12345");
        Book b4=b2;
        b4.name="Psychology of Money";
        b4.author="Morgan Housel";
        Book b5=new Book(b3);
        b5.name="Rich Dad Poor Dad";
        b5.author="Robert Kiyosaki"; 
        bList.add(b4);
        bList.add(b5);}
        catch(InvalidPriceException e){
            System.out.println(e.getMessage());
        }
        catch(InvalidGenreException e){
            System.out.println(e.getMessage());
        }
        bList.forEach(b->{
            System.out.println(b.name);
            System.out.println(b.author);
            System.out.println(b.price);
            System.out.println(b.publisherName);
            System.out.println(b.genre);
            System.out.println(b.ISBN);
            System.out.println(b.dateOfPublication);
        });
        double sum=0;
        int n=bList.size();
        for (Book book : bList) {
            sum+=book.price;
            
        } 
        System.out.println("Average price of books: "+sum/n);
        Scanner sc = new Scanner(System.in);



System.out.println("Enter the name of the genre books: ");
String a = sc.nextLine();

System.out.println("\nBooks in genre: " + a);

bList.stream()
     .filter(b -> b.genre != null && b.genre.equalsIgnoreCase(a))
     .forEach(b -> {
         System.out.println(b.name);
         System.out.println(b.author);
         System.out.println(b.price);
         System.out.println(b.publisherName);
         System.out.println(b.genre);
         System.out.println(b.ISBN);
         System.out.println(b.dateOfPublication);
         System.out.println();
     });

sc.close();
        

    
}}

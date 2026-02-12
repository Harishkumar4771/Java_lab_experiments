package experiment_3;
import java.util.ArrayList;
public class ArrayListOfBooks {
    public static void main(String args[]){
        Book b1=new Book();
        Book b2=new Book("Eclipse","Stephenie Meyer","Fiction",455.50);
        Book b3=new Book("Atomic Habits","James Clear",899.99,"HLP12345");
        Book b4=b2;
        b4.name="Psychology of Money";
        b4.author="Morgan Housel";
        Book b5=new Book(b3);
        b5.name="Rich Dad Poor Dad";
        b5.author="Robert Kiyosaki";
        ArrayList<Book> bList=new ArrayList<Book>();
        bList.add(b1);
        bList.add(b2);
        bList.add(b3);
        bList.add(b4);
        bList.add(b5);
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
        bList.forEach(b->{sum+=(double)b.price;});
        System.out.println("Avg of all book prices: "+(sum/bList.size()));
    
}}

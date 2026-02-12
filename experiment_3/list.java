package experiment_3;
import java.util.ArrayList;
public class list {
    public static void main(String args[]){
        ArrayList<Integer> aList=new ArrayList<Integer>();
        aList.add(100);
        aList.add(200);
        for(int i=0;i<=50;i+=5){
            aList.add(i);
        }    
        System.out.println(aList.size());
        System.out.println(aList);
        for(Integer i:aList){
            System.out.println(i);
        }
        System.out.println(aList.indexOf(25));
        ArrayList<Integer>newList=new ArrayList<Integer>();
        newList.add(10);
        newList.add(20);
        newList.add(30);
        newList.add(100);
        aList.addAll(newList);
        System.out.println(aList);
        aList.lastIndexOf(10);
        aList.forEach(e->{if (e%10==0) System.out.println(e);});
        aList.remove(Integer.valueOf(100));
        aList.remove(5);
        aList.add(5,-30);
        System.out.println(aList);
        ArrayList<String> poem=new ArrayList<String>();
        poem.add("woods");
        poem.add("are");
        poem.add("lovely");
        poem.add("dark");
        poem.add("and");
        poem.add("deep");
        poem.forEach(e->{if (e.startsWith("d")) System.out.println(e);});
}}
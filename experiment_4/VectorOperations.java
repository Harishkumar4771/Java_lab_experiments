package experiment_4;
import java.util.Scanner;
public class VectorOperations {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n;
    System.out.println("How many elements needed in the vector:");
    n=sc.nextInt();
    double[] v1=new double[n];
    double[] v2=new double[n];
    System.out.println("Enter the elements of the first vector:");
    for(int i=0;i<n;i++){
        v1[i]=sc.nextDouble();
    }
    Vector vector1=new Vector(v1);
    System.out.println("Enter the elements of the second vector:");
    for(int i=0;i<n;i++){
        v2[i]=sc.nextDouble();
    }
    Vector vector2=new Vector(v2);
    try{
        Vector sum=vector1.add(vector2);
        System.out.println("Sum of the vectors: ");
        for(int i=0;i<n;i++){
            System.out.print(sum.v[i]+" ");
        }
        System.out.println();
        Vector diff=vector1.subtractor(vector2);
        System.out.println("Difference of the vectors: ");
        for(int i=0;i<n;i++){
            System.out.print(diff.v[i]+" ");
        }
        System.out.println();
        Vector dot=vector1.dot_product(vector2);
        System.out.println("Dot product of the vectors: ");
        for(int i=0;i<n;i++){
            System.out.print(dot.v[i]+" ");
        }
    }catch(VectorException e){
        System.out.println(e.getMessage());
    }
    sc.close();
   
    

}}
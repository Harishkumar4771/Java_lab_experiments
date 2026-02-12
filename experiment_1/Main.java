import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Calculator cal=new Calculator();
        Scanner sc=new Scanner(System.in);
        while(true){
        System.out.println("Enter 1st number:");
        cal.n1=sc.nextInt();
        System.out.println("Enter 2nd number:");
        cal.n2=sc.nextInt();
        System.out.println("What operation do you want to perform(+,-,*,/,%):");
        char op=sc.next().charAt(0);

        switch(op){
            case '+':
                System.out.println("Sum of "+cal.n1+" and "+cal.n2+" is: "+cal.addNums(cal.n1,cal.n2));
                break;
            case '-':
                System.out.println("Difference of "+cal.n1+" and "+cal.n2+" is: "+cal.subNums(cal.n1,cal.n2));
                break;
            case '*':
                System.out.println("Product of "+cal.n1+" and "+cal.n2+" is: "+cal.multiplyNums(cal.n1,cal.n2));
                break;
            case '/':
                System.out.println("Division of "+cal.n1+" and "+cal.n2+" is: "+cal.divideNums(cal.n1,cal.n2));
                break;
            case '%':
                System.out.println("Modulo of "+cal.n1+" and "+cal.n2+" is: "+cal.modularNums(cal.n1,cal.n2));
                break;
            default:
                System.out.println("Invalid choice");          
        }
        System.out.println("Do you want to continue?(y/n):");
        char choice=sc.next().charAt(0);
        if(choice=='n' || choice=='N'){
            break;
        }
        
    }sc.close();
}}
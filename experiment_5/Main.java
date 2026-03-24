package experiment_5;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args){
        try {
            Scanner sc=new Scanner(System.in);
            ArrayList<AccountDetails> accounts = new ArrayList<>();
            
            System.out.println("Enter username for account 1:");
            String username1=sc.nextLine();
            System.out.println("Enter pin for account 1:");
            String pin1=sc.nextLine();
            System.out.println("Enter account number for account 1:");
            String accNo1=sc.nextLine();
            System.out.println("Enter initial balance for account 1:");
            double balance1=sc.nextDouble();
            sc.nextLine(); // consume newline
            
            AccountDetails account1=new AccountDetails(username1, pin1, accNo1, balance1);
            accounts.add(account1);
            
            System.out.println("Enter username:");
            String username=sc.nextLine();
            System.out.println("Enter pin:");
            String pin=sc.nextLine();
            System.out.println("Enter account number:");
            String accNo=sc.nextLine();
            System.out.println("Enter initial balance:");
            double balance=sc.nextDouble();
            sc.nextLine(); // consume newline
            
            AccountDetails newAccount=new AccountDetails(username, pin, accNo, balance);
            accounts.add(newAccount);
            
            System.out.println("Account created successfully!");
            System.out.println("Enter account number to perform transactions:");
            String accNoToFind=sc.nextLine();
            AccountDetails foundAccount=null;
            for(AccountDetails acc:accounts){
                if(acc.getAccNo().equals(accNoToFind)){
                    foundAccount=acc;
                    break;
                }
            }
            if(foundAccount != null) {
                foundAccount.displayDetails();
            } else {
                System.out.println("Account not found.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

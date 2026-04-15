package experiment_6;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Setup a FullTimeEmployee
        FullTimeEmployee ft = new FullTimeEmployee();
        System.out.println("--- Full Time Employee Details ---");
        System.out.print("Enter Name: ");
        ft.name = sc.nextLine();
        System.out.print("Enter Base Salary: ");
        ft.baseSalary = sc.nextDouble();
        System.out.print("Enter Performance Bonus: ");
        ft.perfBonus = sc.nextDouble();
        sc.nextLine(); // Consume newline

        // 2. Setup a ContractEmployee
        ContractEmployee ce = new ContractEmployee();
        System.out.println("\n--- Contract Employee Details ---");
        System.out.print("Enter Name: ");
        ce.name = sc.nextLine();
        System.out.print("Enter Hourly Rate: ");
        ce.hourlyPay = sc.nextDouble();
        System.out.print("Enter Number of Hours: ");
        ce.numberOfHours = sc.nextDouble();
        sc.nextLine(); // Consume newline

        // 3. Setup a Manager
        Manager mg = new Manager();
        System.out.println("\n--- Manager Details ---");
        System.out.print("Enter Name: ");
        mg.name = sc.nextLine();
        System.out.print("Enter Base Salary: ");
        mg.baseSalary = sc.nextDouble();
        System.out.print("Enter Performance Bonus: ");
        mg.perfBonus = sc.nextDouble();
        System.out.print("Enter Education Allowance: ");
        mg.eduAllowance = sc.nextDouble();

        // Display Results
        System.out.println("\n===== CTC Calculations =====");
        System.out.println("Full-Time Employee (" + ft.name + ") CTC: " + ft.calcCTC());
        System.out.println("Contract Employee (" + ce.name + ") CTC: " + ce.calcCTC());
        System.out.println("Manager (" + mg.name + ") CTC: " + mg.calcCTC());

        sc.close();
    }
}
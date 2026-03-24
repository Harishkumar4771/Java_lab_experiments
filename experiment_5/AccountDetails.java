package experiment_5;
public class AccountDetails{
    private String accountNumber;
    private Customer customer;
    protected double balance;

    public String getAccNo() {
        return accountNumber;
    }
    public Customer getCustomer() {
        return customer;
    }
    public double getBalance() {
        return balance;
    }
    public AccountDetails(String username, String pin, String accNo, double balance) throws InvalidBankBalanceException {
        this.accountNumber = accNo;
        this.customer = new Customer(username, pin);
        if (balance < 0) {
            throw new InvalidBankBalanceException("The bank balance cannot be negative");
        }
        this.balance = balance;
    }
    public void displayDetails(){
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Customer Name: " + customer.getCustName());
        System.out.println("Balance: " + balance);
    }
    public void credit(double amount){
        balance=amount+balance;
        System.out.println("The amount: "+amount+" has been credited successfully to you bank account");
        System.out.println("Current bank balance:"+balance);
    }
    public void debit(double amount)throws BankBalanceException{
        if(amount>balance){
            throw new BankBalanceException("Insufficient bank balance.\n Your current bank balance: "+balance);
        }
        balance=balance-amount;
        System.out.println("The amount: "+amount+" has been debited successfully to you bank account");
        System.out.println("Current bank balance:"+balance);
    }
}
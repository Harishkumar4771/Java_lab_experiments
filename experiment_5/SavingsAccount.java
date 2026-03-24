package experiment_5;

public class SavingsAccount extends AccountDetails{
    public double minBalance;

    public SavingsAccount(String username, String pin, String accNo, double balance, double minBalance) throws InvalidBankBalanceException {
        super(username, pin, accNo, balance);
        this.minBalance = minBalance;
    }

    @Override
    public void debit(double amount) throws BankBalanceException{
        if(minBalance>getBalance()){
            throw new MinBalanceException("The balance is lesser than minimum balance: "+minBalance+" The current balance:"+getBalance());
        }
        else if (getBalance()<amount){
            throw new BankBalanceException("Insufficient bank balance.\n Your current bank balance: "+getBalance());
        }
        else{
            balance=balance-amount;
            System.out.println("The amount: "+amount+" has been debited successfully to you bank account");
            System.out.println("Current bank balance:"+balance);
        }
    }
}
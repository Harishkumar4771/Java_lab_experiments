package experiment_5;

public class LoanAccount extends AccountDetails {
    private String loanID;
    private String loanType;
    public double loanAmount;
    public double interest;
    public double time;
    public double balanceAmountLoan;

    public LoanAccount(String username, String pin, String accNo, double balance, String id, String loanType, double loanAmount, double interest, double time) throws InvalidBankBalanceException {
        super(username, pin, accNo, balance);
        this.loanID = id;
        this.loanType = loanType;
        this.loanAmount = loanAmount;
        this.interest = interest;
        this.time = time;
        this.balanceAmountLoan = loanAmount;
    }

    public void payLoan(double pay_amount) throws BankBalanceException {
        if (pay_amount > getBalance()) {
            throw new BankBalanceException("Balance account is lesser\n Current Bank Balance: " + getBalance());
        }

        if (pay_amount >= balanceAmountLoan) {
            debit(balanceAmountLoan);
            balanceAmountLoan = 0;
            System.out.println("Your loan has been fully paid successfully!");
        } else {
            debit(pay_amount);
            balanceAmountLoan -= pay_amount;
            System.out.println(pay_amount + " has been paid to loan");
            System.out.println("Remaining loan debt: " + balanceAmountLoan);
        }
    }

    // Getters and Setters
    public String getLoanID() { return loanID; }
    public void setLoanID(String loanID) { this.loanID = loanID; }
    public String getLoanType() { return loanType; }
    public void setLoanType(String loanType) { this.loanType = loanType; }
}

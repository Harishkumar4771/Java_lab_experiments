package experiment_6;
public class ContractEmployee extends Employee{
    double hourlyPay;
    double numberOfHours;

    @Override
    double calcCTC() {
        return hourlyPay*numberOfHours;
    }
}
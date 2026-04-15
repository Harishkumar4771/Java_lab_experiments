package experiment_6;
public class FullTimeEmployee extends Employee{
    double baseSalary;
    double perfBonus;

    @Override
    double calcCTC() {
        return baseSalary+perfBonus;
    }
}
package experiment_6;
public class Manager extends FullTimeEmployee{
    double eduAllowance;

    @Override
    double calcCTC() {
        return super.calcCTC()+eduAllowance;
    }
}
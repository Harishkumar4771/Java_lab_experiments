package experiment_6;
import java.util.Date;
abstract class Employee{
    public String name;
    private String panNo;
    public Date joinDate;
    public String designation;
    private String empId;

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }
    abstract double calcCTC();
}
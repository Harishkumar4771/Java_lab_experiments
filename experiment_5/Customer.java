package experiment_5;
public class Customer{
    private String custName;
    private String custID;

    public String getCustName() {
        return custName;
    }

    public String getCustID() {
        return custID;
    }
    public Customer(String name,String id){
        this.custName=name;
        this.custID=id;
    }
}
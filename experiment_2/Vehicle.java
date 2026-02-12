public class Vehicle {
    public String brandname;
    public String modelname;
    public String color;
    public double price;
    public boolean auto;
    public int noofwheels;
    public float enginepower;
    private int noofcylinders;
    private String mfgCode;
    public int seats;
    public String fuelType;
    public String getMfgcode(){
        return mfgCode;
    }
    public void setMfgcode(String mCode){
        mfgCode=mCode;
    }
    public int getcyl(){
        return noofcylinders;
    }
    public void setcyl(int cyl){
        noofcylinders=cyl;
    }
    public Vehicle(){
        brandname="Honda";
        modelname="accord";
        price=340000.55;
        color="Blue";
        mfgCode="HON1234";
        noofcylinders=4;
        auto=true;
        noofwheels=4;
        enginepower=3.5f;
        seats=5;
        fuelType="Petrol";
    }
    public Vehicle(String bName,String mName,String c,double p,boolean auto){
        brandname=bName;
        modelname=mName;
        color=c;
        price=p;
        this.auto=auto;
    }
    public Vehicle(String c,double p,boolean a)
    {
        color=c;
        price=p;
        auto=a;
    }
    public Vehicle(Vehicle v){
        brandname=v.brandname;
        modelname=v.modelname;
        price=v.price;
    }
    public void start(){
        System.out.println("Vehicle started!");
    }
    public void drive(int iniSpeed){
        System.out.println("I have started with an initial spee of :"+iniSpeed);
        
    }
    public void stop(){
        System.out.println("Vehicle stopped!");
    }
    public float calculateMileage(float dist,float fuel){
        return dist/fuel;
    }
    public boolean gearType(){
        return auto;
    }
    public float changeSpeed(float curSpeed,float  newSpeed){
        curSpeed=newSpeed;
        return curSpeed;
        
    }
    public double calcTripMileage(float dist,float fuelUsed){
        double mileage=dist/fuelUsed;
        return dist/mileage;
        
    }
}
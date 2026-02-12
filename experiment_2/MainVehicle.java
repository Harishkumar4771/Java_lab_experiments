public class MainVehicle {
     public static void main(String[] args){
        Vehicle v1=new Vehicle();

        //printVehicleDetails(v1);
        Vehicle v2=new Vehicle("Toyota","Camry","White",450000.75,false);
        //printVehicleDetails(v2);
        Vehicle v3=new Vehicle("Black",300000.00,true);
       // printVehicleDetails(v3);
        Vehicle v4=v1;
        v4.color="Red";
        v4.price=69420.67;
        //printVehicleDetails(v4);
        Vehicle[] myVehicles=new Vehicle[]{v1,v2,v3,v4};
        for(Vehicle v:myVehicles){
            printVehicleDetails(v);
            v.start();
            v.drive(10);
            v.changeSpeed(10,30);
            v.calcTripMileage(120,20);
            v.stop(); 
        }

     }
     public static void printVehicleDetails(Vehicle v){
        System.out.println("=========Vehicle Details=========");
        System.out.println("ModelName\tBranName\tColor\t\tPrice\tAutomatic");
        System.out.println(v.modelname+"\t\t"+v.brandname+"\t\t"+v.color+"\t\t"+v.price+" "+v.auto);
     }
}

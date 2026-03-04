package experiment_4;
public class Vector {
    double[] v;
    Vector(double[] v){
        this.v=v;
    }
   void check_dimension(Vector v2) throws VectorException{
        if(v.length!=2 && v.length!=v2.v.length){
            throw new VectorException("Vectors must have the same dimension.It should be either 2 or 3.");
        }
        else if(v.length!=3 && v.length!=v2.v.length){
            throw new VectorException("Vectors must have the same dimension.It should be either 2 or 3.");
        }
   }
     
   Vector add(Vector v2) throws VectorException{
        check_dimension(v2);
        double[] result = new double[v.length];
        for(int i=0;i<v.length;i++){
            result[i]=v[i]+v2.v[i];
        }
        return new Vector(result);
   }
   Vector subtractor(Vector v2) throws VectorException{
         check_dimension(v2);
         double[] result = new double[v.length];
         for(int i=0;i<v.length;i++){
            result[i]=v[i]-v2.v[i];
         }
         return new Vector(result);
   }
   Vector dot_product(Vector v2) throws VectorException{
         check_dimension(v2);
         double[] result = new double[v.length];
         for(int i=0;i<v.length;i++){
            result[i]=v[i]*v2.v[i];
         }
         return new Vector(result);
   }

}

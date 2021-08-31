public class Algorithm2 {
    public static double recursivePow(double base, int exp){
        if(exp==0){
            return 1.0;
        }
        else if(exp%2!=0){
            return base*recursivePow(base*base,(exp-1)/2);
        }
        else{
            return recursivePow(base*base,exp/2);
        }
    }
}

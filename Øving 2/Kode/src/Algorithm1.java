public class Algorithm1 {
    public static double recursivePow(double base, int exp){
        if(exp == 0){
            return 1.0;
        }
        return base*recursivePow(base, exp-1);
    }
}

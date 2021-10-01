import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        final int FULLSIZE = 10000019;
        final int HALFSIZE =5000010;
        final int EIGHTY=8000015;
        final int NINETY=9000017;
        final int NINENTYNINE=9900019;

        int[] fullA = FillArray.fill(FULLSIZE);
        int[] halfA = FillArray.fill(HALFSIZE);
        int[] eightyA = FillArray.fill(EIGHTY);
        int[] ninetyA = FillArray.fill(NINETY);
        int[] ninetynineA = FillArray.fill(NINENTYNINE);




        OpenAddressLinear lin = new OpenAddressLinear();
        OpenAddressQuadratic quad = new OpenAddressQuadratic();
        OpenAddressDouble doub = new OpenAddressDouble();
//        lin.setTable();
//        quad.setTable();
//        doub.setTable();

    }
}

class FillArray{
    static int[] fill(int size){
        int[] arr = new int[size];
        arr[0] = (int) (Math.random()*999) +1;
        for (int i = 1; i<size-1;i++){
            arr[i] = (int) ((Math.random()*999) + 1);
        }

        //shuffler arrayet
        Random rnd = ThreadLocalRandom.current();
        for (int i = arr.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            int a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
        return arr;
    }
}

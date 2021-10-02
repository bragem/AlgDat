import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        final int FULLSIZE = 10000019;
        final int HALFSIZE = 5000010;
        final int EIGHTY = 8000015;
        final int NINETY = 9000017;
        final int NINENTYNINE = 9900019;

        OpenAddressLinear lin = new OpenAddressLinear();
        OpenAddressQuadratic quad = new OpenAddressQuadratic();
        OpenAddressDouble doub = new OpenAddressDouble();

        int[] arr = new int[FULLSIZE];
        arr[0] = (int) (Math.random()*999) +1;
        for (int i = 1; i<FULLSIZE-1;i++){
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


        //50% lineær probing
        int linColl = 0;
        for (int i =0;i<HALFSIZE;i++){
            linColl += quad.add(arr[i]);
        }
        System.out.println(linColl);




    }
}


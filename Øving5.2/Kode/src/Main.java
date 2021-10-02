import java.io.FileFilter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        //bytter mellom høyeste primtall over 10 mill og toerpotens
        final int FULLSIZE = 10000019;
//        final int FULLSIZE = (int) Math.pow(2,24);


        final int PERCENTAGE = (FULLSIZE/100);
        final int HALFSIZE = PERCENTAGE *50;
        final int EIGHTY = PERCENTAGE*80;
        final int NINETY = PERCENTAGE*90;
        final int NINETYNINE = PERCENTAGE*99;

        OpenAddressLinear lin = new OpenAddressLinear();
        OpenAddressQuadratic quad = new OpenAddressQuadratic();
        OpenAddressDouble doub = new OpenAddressDouble();

        int[] arr = new int[FULLSIZE];
        arr[0] = (int) (Math.random()*9999999) +1;
        for (int i = 1; i<FULLSIZE-1;i++){
            arr[i] = (int) ((Math.random()*9999999) + 1);
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


        int linColl = 0;
        long start = System.nanoTime();
        for (int i = 0; i< NINETYNINE; i++){
            linColl += doub.add(arr[i]);
        }
        long end = System.nanoTime();
        long time = (end-start)/1000000;

        System.out.println(linColl);
        System.out.println(time);




    }
}


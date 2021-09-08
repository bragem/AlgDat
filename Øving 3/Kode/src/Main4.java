import java.util.Date;

public class Main4 {
    public static void main(String[] args) {
        //main for å sammenligne tidene algoritmene bruker på 3-gangen

        Date start = new Date();
        int runder = 0;
        double tid;
        Date slutt;

        do{
            int[] arr = new int[33];
            for (int i = 0; i < 33; i++) {
                arr[i] = i*3;
            }
            Algorithm.newQuicksort(arr, 0, arr.length-1);
            slutt = new Date();
            ++runder;
        }
        while(slutt.getTime()-start.getTime()<1000);
        tid = (double) (slutt.getTime()-start.getTime())/runder;
        System.out.println("Millisekund pr runde: " + tid);

        start = new Date();
        runder = 0;
        double tid1;
        Date slutt1;

        do{
            int[] arr = new int[33];
            for (int i = 0; i < 33; i++) {
                arr[i] = i*3;
            }
            Algorithm.quicksort(arr, 0, arr.length-1);
            slutt1 = new Date();
            ++runder;
        }
        while(slutt1.getTime()-start.getTime()<1000);
        tid1 = (double) (slutt1.getTime()-start.getTime())/runder;
        System.out.println("Millisekund pr runde vanlig: " + tid1);
    }
}

import java.util.Date;

public class Main3 {
    public static void main(String[] args) {
        //main for å ta tiden på ny quicksort metode

        Date start = new Date();
        int runder = 0;
        double tid;
        Date slutt;

        do{
            int[] arr = new int[1000000];
            for (int i = 0; i < 1000000; i++) {
                arr[i] = (int) (Math.random() * 100);
            }
            Algorithm.newQuicksort(arr, 0, arr.length-1);
            slutt = new Date();
            ++runder;
        }
        while(slutt.getTime()-start.getTime()<1000);
        tid = (double) (slutt.getTime()-start.getTime())/runder;
        System.out.println("Millisekund pr runde: " + tid);


    }
}

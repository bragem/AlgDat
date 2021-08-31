import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Date start = new Date();
        int runder = 0;
        double tid;
        Date slutt;

        do{
            Algorithm1.recursivePow(2,10000);
            slutt = new Date();
            ++runder;
        }
        while(slutt.getTime()-start.getTime()<1000);
        tid = (double) (slutt.getTime()-start.getTime())/runder;
        System.out.println("Millisekund pr runde: " + tid);
    }
}

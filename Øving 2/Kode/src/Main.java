import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Date start = new Date();
        int runder = 0;
        double tid;
        Date slutt;

        System.out.println(Algorithm1.recursivePow(2,10)==1024.0);
        System.out.println(Algorithm1.recursivePow(3,14)==4782969);
        System.out.println(Algorithm2.recursivePow(2,10)==1024.0);
        System.out.println(Algorithm2.recursivePow(3,14)==4782969);

        do{
            Algorithm1.recursivePow(2,5000);
            slutt = new Date();
            ++runder;
        }
        while(slutt.getTime()-start.getTime()<1000);
        tid = (double) (slutt.getTime()-start.getTime())/runder;
        System.out.println("Millisekund pr runde: " + tid);
    }
}

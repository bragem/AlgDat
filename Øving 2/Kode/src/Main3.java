import java.util.Date;

public class Main3 {
    public static void main(String[] args) {
        //Klasse for tidtaking og verifisering av Javas egen eksponentialfunksjon
        Date start = new Date();
        int runder = 0;
        double tid;
        Date slutt;

        System.out.println(Math.pow(2,10)==1024.0);
        System.out.println(Math.pow(3,14)==4782969);

        do{
            Math.pow(1.001,5000);
            slutt = new Date();
            ++runder;
        }
        while(slutt.getTime()-start.getTime()<1000);
        tid = (double) (slutt.getTime()-start.getTime())/runder;
        System.out.println("Millisekund pr runde: " + tid);
    }
}

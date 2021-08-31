import java.util.Date;

public class Main2 {
    public static void main(String[] args) {
        //Klasse for tidtaking og verifisering av algoritme 2
        Date start = new Date();
        int runder = 0;
        double tid;
        Date slutt;

        System.out.println(Algorithm2.recursivePow(2,10)==1024.0);
        System.out.println(Algorithm2.recursivePow(3,14)==4782969);


        do{
            Algorithm2.recursivePow(1.001,5000);
            slutt = new Date();
            ++runder;
        }
        while(slutt.getTime()-start.getTime()<1000);
        tid = (double) (slutt.getTime()-start.getTime())/runder;
        System.out.println("Millisekund pr runde: " + tid);
    }
}

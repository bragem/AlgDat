
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = RandomNumberListGenerator.fillListWithNumbers(15000, 10,-10);

        List<Integer> testListe = new ArrayList<>();

        testListe.add(-1);
        testListe.add(3);
        testListe.add(-9);
        testListe.add(2);
        testListe.add(2);
        testListe.add(-1);
        testListe.add(2);
        testListe.add(-100);
        testListe.add(-5);
        System.out.println(Algorithm.findDaysWithHighestProfit(testListe));



        Date start = new Date();
        int runder = 0;
        double tid;
        Date slutt;

        do{
            Algorithm.findDaysWithHighestProfit(list);
            slutt = new Date();
            ++runder;
        }
        while(slutt.getTime()-start.getTime()<1000);
        tid = (double) (slutt.getTime()-start.getTime())/runder;
        System.out.println("Millisekund pr runde: " + tid);



    }




}



import java.util.ArrayList;
import java.util.List;

public class Algorithm {

    private Algorithm(){
        throw new IllegalStateException("Utility class");
    }

    public static List<Integer> findDaysWithHighestProfit(List<Integer> list) {
        int buyValue = 0;
        int sellValue;
        int stockValue = 0;
        int change = 0;
        //setter beste dag for kjøp og salg til å være dag 1 og 2
        //for initialiseringens skyld
        int bestBuy = list.get(0);
        int bestSell = list.get(1);
        int difference = bestSell - bestBuy;

        for (int i = 0; i < list.size(); i++) {
            change = change + list.get(i);
            stockValue = stockValue + change;
            sellValue = 0;

            for (int j = i + 1; j < list.size(); j++) {
                sellValue = sellValue + list.get(j);
                int newDiff = sellValue - buyValue;

                if (newDiff > difference) {
                    difference = newDiff;
                    bestBuy = i;
                    bestSell = j;
                }
            }
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(bestBuy+1);
        list1.add(bestSell+1);
        //+1 fordi man starter å telle dager på 1 og ikke 0
        return list1;
    }



}



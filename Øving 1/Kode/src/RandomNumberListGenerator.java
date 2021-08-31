

import java.util.ArrayList;
import java.util.List;

public class RandomNumberListGenerator {

    private RandomNumberListGenerator(){
        throw new IllegalStateException("Utility class");
    }

    public static List<Integer> fillListWithNumbers(int amountOfNumbers, int max, int min){
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<amountOfNumbers;i++){
            int number = (int) ((Math.random() * (max-min))+min);
            list.add(number);
        }
        return list;
    }
}

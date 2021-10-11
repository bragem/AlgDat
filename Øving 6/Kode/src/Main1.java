import java.io.BufferedReader;
import java.io.FileReader;

public class Main1 {
    public static void main(String[] args) {
        Graf graf = new Graf();
        try {
            FileReader fr = new FileReader("./L7g5.txt");
            BufferedReader br = new BufferedReader(fr);
            graf.ny_ugraf(br);
            graf.topologisort();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

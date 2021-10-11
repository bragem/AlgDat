import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {

        Graf graf = new Graf();
        try {
            FileReader fr = new FileReader("./L7g1.txt");
            BufferedReader br = new BufferedReader(fr);
            graf.ny_ugraf(br);
            graf.bfs(graf.node[5]);
            graf.printBFSResults();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

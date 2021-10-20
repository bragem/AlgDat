import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        Graf graf = new Graf();
        try {
            FileReader fr = new FileReader("./flytgraf1.txt");
            BufferedReader br = new BufferedReader(fr);
            graf.ny_vgraf(br);
            System.out.println(graf.getMaxFlow(graf.node[0],graf.node[graf.node.length-1]));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

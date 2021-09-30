import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {


        Hashtabell ht = new Hashtabell(256);


        File f = new File("C:/Users/Brage/Desktop/Skole/Høst 2021/AlgDat/Øving 5/Kode/src/fil.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while((line = br.readLine()) != null){
                Node newNode = new Node(line,0,null);
                ht.add(ht.stringToInt(line), newNode);
            }
            System.out.println(ht.getCollisions());
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

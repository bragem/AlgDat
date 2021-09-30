import java.io.*;

public class Main {
    public static void main(String[] args) {


        Hashtabell ht = new Hashtabell(256);


        File f = new File("./fil.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while((line = br.readLine()) != null){
                Node newNode = new Node(line,0,null);
                ht.add(ht.stringToInt(line), newNode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

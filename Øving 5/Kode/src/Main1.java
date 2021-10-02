import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Hashtabell ht = new Hashtabell(137);


        File f = new File("./navn.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while((line = br.readLine()) != null){
                Node newNode = new Node(line,0,null);
                ht.add(ht.stringToInt(line), newNode);
            }
            System.out.println("Antall kollisjoner: " + ht.getCollisions());
            System.out.println("Lastfaktor: " + (ht.getCollisions()/137.0));
            System.out.println("Antall kollisjoner per person: " + (ht.getCollisions()/118.0));
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Du kan teste selv med flere navn under her, men har testet med mitt navn
        System.out.println(ht.find("Brage Minge"));

//        Scanner myObj = new Scanner(System.in);
//        System.out.println("Finn person i faget:");
//        String name = myObj.nextLine();
//        System.out.println(ht.find(name));




    }
}

import java.io.File;


public class Main1 {
    public static void main(String[] args) {

        try {
            //Dette fungerer ikke om man bruker intellij og
            //den typiske src mappen, men går helt fint om man bare åpner og
            //kjører filen i en vanlig mappe
            File f = new File("./Main.java");
            System.out.println(Algorithm1.BalancedBrackets(f));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

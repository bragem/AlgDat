import java.io.File;


public class Main1 {
    public static void main(String[] args) {

        try {
            File f = new File("./Main.java");
            System.out.println(Algorithm1.BalancedBrackets(f));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

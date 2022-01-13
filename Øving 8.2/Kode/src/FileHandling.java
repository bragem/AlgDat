import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileHandling {
    public static byte[] readBytes(String plassering) {
        try {
            return Files.readAllBytes(Paths.get(plassering));
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    public static void writeBytes(byte[] output, String plassering) {
        try(DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(plassering)))){
            dos.write(output);
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static byte[] listToArray(ArrayList<Byte> out) {
        int length = out.size();
        byte[] result = new byte[length];
        for (int i = 0; i < length; i++) {result[i] = out.get(i);}
        return result;
    }
}

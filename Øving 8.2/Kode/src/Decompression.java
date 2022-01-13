import java.util.ArrayList;

public class Decompression {
    private final int MIN_LENGTH = 3;
    private final String fileIn;
    private final String fileOut;

    public Decompression(String fileIn, String fileOut) {
        this.fileIn = fileIn;
        this.fileOut = fileOut;
    }

//    public void runDecompression() {
//        byte[] readBytes = FileHandling.readBytes(this.fileIn);
//        FileHandling.writeBytes(decompress(readBytes), this.fileOut);
//    }

    public byte[] decompress(byte[] data) {
        ArrayList<Byte> decompressed = new ArrayList<>();
        for (int i = 0, indexOut = 0; i < data.length; i++) {
            byte x = data[i];
            if (x < 0) {
                short distance = (short)((data[i + 1] & 0xff) | ((data[i + 2] & 0xff) << 8));
                int start = indexOut;
                for (int j = start - distance; j < start - distance - x; j++) {
                    decompressed.add(decompressed.get(j));
                    indexOut++;
                }
                i += (MIN_LENGTH - 1);
            }
            else {
                for (int j = i + 1; j <= i + x && j < data.length; j++) {
                    decompressed.add(data[j]);
                    indexOut++;
                }
                i += x;
            }
        }
        return FileHandling.listToArray(decompressed);
    }

}

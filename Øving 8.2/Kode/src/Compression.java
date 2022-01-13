import java.util.ArrayList;

public class Compression {
    private final int MIN_LENGTH = 3;
    private String fileIn;
    private String fileOut;

    public Compression(String fileIn, String fileOut) {
        this.fileIn = fileIn;
        this.fileOut = fileOut;
    }

    public byte[] compress(byte[] data) {
        ArrayList<Byte> compressed = new ArrayList<>();
        byte unchanged = MIN_LENGTH;
        int i;

        for (i = MIN_LENGTH; i < data.length; i++) {
            boolean found = false;
            short distance = 0;
            byte foundLength = 0;
            for (short d = 3; d <= i && d < Short.MAX_VALUE; d++) {
                if (data[i - d] == data[i]) {
                    int foundLengthInt;

                    for (foundLengthInt = 1; foundLengthInt < d
                            && foundLengthInt < Byte.MAX_VALUE
                            && i + foundLengthInt < data.length;) {
                        if (data[i + foundLengthInt] == data[i - d + foundLengthInt]) {foundLengthInt++;}
                        else {break;}

                    }
                    if (foundLengthInt > MIN_LENGTH && foundLengthInt > foundLength) {
                        found = true;
                        foundLength = (byte)foundLengthInt;
                        distance = d;
                        if (foundLength == Byte.MAX_VALUE) {break;}
                    }
                }
            }
            if (found) {
                if (unchanged != 0) {
                    compressed.add(unchanged);
                    for (int j = i - unchanged; j < i; j++) {compressed.add(data[j]);}
                    unchanged = 0;
                }
                compressed.add((byte)(-foundLength));	// MIN_LENGDE.
                compressed.add((byte)(distance & 0xff));
                compressed.add((byte)((distance >> 8) & 0xff));

                i += ((int)(foundLength) - 1);
            }
            else {unchanged++;}
            if (unchanged == Byte.MAX_VALUE) {
                compressed.add(unchanged);
                for (int j = i - unchanged + 1; j <= i; j++) {compressed.add(data[j]);}
                unchanged = 0;
            }
        }
        compressed.add(unchanged);
        for (int j = i - unchanged; j < i; j++) {compressed.add(data[j]);}
        return FileHandling.listToArray(compressed);
    }

    public void runCompression() {
        byte[] lestData = FileHandling.readBytes(this.fileIn);
        byte[] komprimert = compress(lestData);
        FileHandling.writeBytes(komprimert, this.fileOut);

    }
}

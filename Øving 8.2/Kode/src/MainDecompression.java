public class MainDecompression {
    public static void main(String[] args) {
        Decompression decompressor = new Decompression("./compressed.lz","./decompressed.txt");
        decompressor.runDecompression();
    }
}

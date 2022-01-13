public class MainCompression {
    public static void main(String[] args) {
        Compression compressor = new Compression("./diverse.txt","./compressed.lz");
        compressor.runCompression();
    }
}

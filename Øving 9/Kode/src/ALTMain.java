import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ALTMain {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("./noderNorden.txt");
        InputStream inputStream1 = new FileInputStream("./kanterNorden.txt");
        InputStream inputStream2 = new FileInputStream("./interessepkt.txt");
        MapData mapData = new MapData();
        mapData.nodeInput(inputStream);
        System.out.println("Nodes read");
        mapData.edgeInput(inputStream1);
        System.out.println("Vertexes read");
        mapData.readInterestPoint(inputStream2);
        System.out.println("Interest points added");

        InputStream inputStream3 = new FileInputStream("./PreFileFrom.txt");
        InputStream inputStream4 = new FileInputStream("./PreFileTo.txt");
        mapData.readPreProcessedFileFromLandmark(inputStream3);
        mapData.readPreProcessedFileToLandmark(inputStream4);
        System.out.println("Preprocessed files read");

        long start;
        long end;

        /*
        System.out.println("\nALT Stjørdal to Meråker");
        start = System.nanoTime();
        mapData.ALT(6579983, 1693246);
        end = System.nanoTime();
        System.out.println((end - start)/1000000000 + " seconds used");
        mapData.printTime(1693246);
        mapData.nodesInShortestPath(1693246);
        mapData.writeMapData(6579983,1693246,  "ALTMapMeråker-Stjørdal.txt");
*/

        /*
        System.out.println("\nALT Kårvåg–Gjemnes");
        start = System.nanoTime();
        mapData.ALT(6368906, 6789998);
        end = System.nanoTime();
        System.out.println((end - start)/1000000000 + " seconds used");
        mapData.printTime(6789998);
        mapData.nodesInShortestPath(6789998);
        mapData.writeMapData(6368906, 6789998, "ALTMapKårvåg–Gjemnes.txt");
*/


        /*
        System.out.println("\nALT Oslo–Trondheim");
        start = System.nanoTime();
        mapData.ALT(  2518118, 6861306);
        end = System.nanoTime();
        System.out.println((end - start)/1000000000 + " seconds used");
        mapData.printTime(6861306);
        mapData.nodesInShortestPath(6861306);
        mapData.writeMapData(2518118, 6861306, "ALTMapOslo–Trondheim.txt");
*/

        /**/
        System.out.println("\nALT Tampere–Trondheim");
        start = System.nanoTime();
        mapData.ALT(  136963, 6861306);
        end = System.nanoTime();
        System.out.println((end - start)/1000000000 + " seconds used");
        mapData.printTime(6861306);
        mapData.nodesInShortestPath(6861306);
        mapData.writeMapData(136963, 6861306, "ALTMapTampere–Trondheim.txt");

    }
}

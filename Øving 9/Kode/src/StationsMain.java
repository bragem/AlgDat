import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StationsMain {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream(("C:\\Users\\hassa\\NTNU.Data\\2år\\1.sem\\AlgDat\\AlgDat_IDATT2101\\src\\main\\java\\Test\\nord_noder.txt"));
        InputStream inputStream1 = new FileInputStream("C:\\Users\\hassa\\NTNU.Data\\2år\\1.sem\\AlgDat\\AlgDat_IDATT2101\\src\\main\\java\\Test\\nord_kanter.txt");
        InputStream inputStream2 = new FileInputStream("C:\\Users\\hassa\\NTNU.Data\\2år\\1.sem\\AlgDat\\AlgDat_IDATT2101\\src\\main\\java\\Test\\nord_interessepkt.txt");
        MapData mapData = new MapData();
        mapData.nodeInput(inputStream);
        System.out.println("Nodes read");
        mapData.edgeInput(inputStream1);
        System.out.println("Vertexes read");
        mapData.readInterestPoint(inputStream2);
        System.out.println("Interest points added");
        System.out.println("\nRøros Charching Stations");
        mapData.stationsToMapData(mapData.dijkstraDistStations(1419364, 4), "RørosChargeStations.txt");//Røros Charging
        System.out.println("\nVærnes Gas Stations");
        mapData.stationsToMapData(mapData.dijkstraDistStations(6590451, 2), "VærnesGasStations.txt");//Værnes Gas
    }
}

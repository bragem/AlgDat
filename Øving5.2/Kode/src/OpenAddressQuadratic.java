public class OpenAddressQuadratic extends OpenAddress{

    @Override
    public int probe(int h, int i, int m) {
        return (int) (h+i+Math.pow(i,2)%m);
    }

}

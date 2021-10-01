public class OpenAddressLinear extends OpenAddress{

    @Override
    public int probe(int h, int i, int m) {
        return (h+i)%m;
    }

}

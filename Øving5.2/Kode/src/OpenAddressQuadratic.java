public class OpenAddressQuadratic extends OpenAddress{

    @Override
    public int probe(int h, int i, int m) {
        int probed = (int) (h+i+Math.pow(i,2)%m);
        if(probed<0) probed*=-1;
        return probed;
    }

}

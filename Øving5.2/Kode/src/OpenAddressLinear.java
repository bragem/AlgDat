public class OpenAddressLinear extends OpenAddress{

    @Override
    public int probe(int h, int i, int m) {
        int probed =  (h+i)%m;
        if(probed<0) probed*=-1;
        return probed;
    }

}

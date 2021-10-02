public class OpenAddressDouble extends OpenAddress{

    @Override
    public int probe(int h, int i, int m) {
        int probed = (hash1(h)+i*hash2(h))%m;
        if(probed < 0) probed *=-1;
        return probed;
    }


    public int hash2(int number){
        int hashed = number%(table.length-1)+1;
        if(hashed<0) hashed= hashed * (-1);
        return hashed;
    }

    //for partallslengde av tabell
    public int hash3(int number){
        int hashed = (2*Math.abs(number)+1)% table.length;
        if(hashed<0) hashed= hashed * (-1);
        return hashed;
    }

}

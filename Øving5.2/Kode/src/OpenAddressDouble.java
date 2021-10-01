public class OpenAddressDouble extends OpenAddress{

    @Override
    public int probe(int h, int i, int m) {
        return (hash1(h)+i*hash2(h))%m;
    }


    public int hash2(int number){
        return 7-(number%7);
    }
}

public class OpenAddressDouble extends OpenAddress{

    @Override
    public int probe(int h, int i, int m) {

        return (i+hash2(h))%m;
    }


    public int hash2(int number){
        return number%(table.length-1)+1;
    }
}

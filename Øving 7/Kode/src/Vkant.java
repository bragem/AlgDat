public class Vkant extends Kant{
    int vekt;
    int flyt;
    public Vkant(Node n, Vkant nst, int vkt){
        super(n,nst);
        vekt=vkt;
    }
    public int beregnRestkapasitet(){
        return vekt - flyt;
    }
}

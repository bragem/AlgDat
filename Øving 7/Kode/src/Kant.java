public abstract class Kant {
    Kant neste;
    Kant motsatt;
    Node til;
    public Kant(Node n, Kant nst){
        til = n;
        neste = nst;
    }
}

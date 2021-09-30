public class Node {
    String value;
    int key;
    Node next;

    public Node(String value, int key, Node n){
        this.value = value;
        this.key = key;
        next = n;
    }

    public String getValue(){
        return value;
    }
    public int getKey(){return key;}

    public Node getNext() {
        return next;
    }

}

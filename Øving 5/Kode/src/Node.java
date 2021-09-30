public class Node {
    int element;
    Node next;

    public Node(int e, Node n){
        element = e;
        next = n;
    }

    public int getElement(){
        return element;
    }

    public Node getNext() {
        return next;
    }

}

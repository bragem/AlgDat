public class Node {
    int element;
    Node next;
    Node previous;
    public Node(int e, Node n, Node p){
        element = e;
        next = n;
        previous = p;
    }
    public Node(int e, Node n){
        element = e;
        next = n;
        previous = null;
    }
    public int getElement(){
        return element;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrevious() {
        return previous;
    }
}

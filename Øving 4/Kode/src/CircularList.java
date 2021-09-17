public class CircularList {
    private Node head = null;
    private Node tail = null;
    private int elements = 0;

    public int getElements() {
        return elements;
    }

    public Node getHead() {
        return head;
    }

    public void addNode(int e){
        elements++;
        Node newNode = new Node(e, null,null);

        if(head == null) head = newNode;
        else tail.next = newNode;

        tail = newNode;
        tail.next = head;
    }

    public void removeNode(int deleteElement){
        Node currentNode = head;
        if (head==null) return; //Hvis lista er tom
        do{
            Node nextNode = currentNode.next;
            if(nextNode.element == deleteElement){
                if (tail == head){
                    //Hvis lista bare har ett element
                    head = null;
                    tail = null;
                }
                else{
                    currentNode.next = nextNode.next;
                    if (head == nextNode){
                        head = head.next;//Her blir hodet slettet
                    }
                    if (tail == nextNode){
                        tail = currentNode;//Her blir halen slettet
                    }
                }
                break;
            }
            currentNode = nextNode;
        }
        while(currentNode != head);
    }
}

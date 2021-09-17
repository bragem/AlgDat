public class Algorithm {
    public static int josephus(int persons, int interval){
        //det å gå innom en egen klasse med circular list virker som veldig mye ekstra arbeid
        //her er det laget en sirkulær liste uten den ekstra klassen
        Node head = new Node(1, null);
        Node previous = head;
        for (int i = 2; i<=persons;i++){
            previous.next = new Node(i, null);
            previous = previous.next;
        }
        previous.next = head;


        Node node1 = head;
        Node node2 = head;

        while(node1.next!=node1){

            for(int i = 1;i<interval;i++){
                node2 = node1;
                node1=node1.next;
            }
            node2.next = node1.next;
            node1 = node2.next;
        }
        return node1.element;
    }
}

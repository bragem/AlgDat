public class Hashtabell {
    private final int size;
    Node[] table;
    int collisions;



    public Hashtabell(int size){
        this.size = size;
        this.table = new Node[size];
    }

    public int stringToInt(String s){
        int sum=0;
        char[] arr = s.toCharArray();
        for(int i = 1; i < arr.length+1; i++){
            int ascii = arr[i-1];
            sum += (ascii*(Math.pow(7,i)))%1000;
        }
        return sum;
    }

    public int divhash(int k){
        return k%size;
    }

    public void add(int k, Node newNode){
        int h = divhash(k);
        if(table[h] != null){
            System.out.println("Collision. New name: "+newNode.value +", Old name: "+ table[h].value);
            collisions++;

            newNode.next = table[h];
            table[h].next=null;
        }
        table[h] = newNode;
    }

    public int getCollisions() {
        return collisions;
    }

    public void resetCollisions(){
        collisions = 0;
    }
}

public class Hashtabell {
    private int size;
    Node[] table;
    int collisions;



    public Hashtabell(int size){
        this.size = size;
        this.table = new Node[size];
    }

    public int stringToInt(String s){
        int sum=0;
        for(int i = 0; i < s.toCharArray().length; i++){
            char[] arr = s.toCharArray();
            int ascii = arr[i];
            sum += ascii*(Math.pow(7,i));
        }
        return sum;
    }

    public int divhash(int k){
        return k%size+1;
    }

    public void add(int k, Node newNode){
        int h = divhash(k);
        if(table[h] != null){
            System.out.println("Collision. New name: "+newNode.value +", Old name: "+ table[h]);
            collisions++;

            newNode.next = table[h];
            table[h].next=null;
        }
        table[h] = newNode;
    }


}

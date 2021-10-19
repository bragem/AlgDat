import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Graf {
    //antall noder
    int N;
    //antall kanter
    int K;
    Node[] node;

    public void initForgj(Node s){
        for (int i=N;i-->0;){
            node[i].d = new Forgj();
        }
        ((Forgj) s.d).dist = 0;
    }


    public void bfs(Node s){
        initForgj(s);
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(s);
        while (!queue.isEmpty()){
            Node n = queue.getFirst();
            for(Kant k = n.kant1;k!=null;k=k.neste){
                Forgj f =  (Forgj) k.til.d;
                if (f.dist == f.uendelig){
                    f.dist = ((Forgj)n.d).dist+1;
                    f.forgj = n;
                    queue.add(k.til);
                }
            }
            queue.removeFirst();
        }
    }

    public void printBFSResults(){
        System.out.println("Node:  Forgj:  Dist:  ");
        for (int i=0;i<N;i++){
            int forgj;
            if(((Forgj)node[i].d).forgj == null){
                forgj = -1;
            }
            else{
                forgj = ((Forgj)node[i].d).forgj.number;
            }
            System.out.println(node[i].number+"      "+forgj+"     "+ ((Forgj)node[i].d).dist);
        }
    }

    public void ny_vgraf(BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        node = new Node[N];
        for (int i=0;i<N;++i) node[i] = new Node();
        K = Integer.parseInt(st.nextToken());
        for (int i=0;i<K;++i){
             st = new StringTokenizer(br.readLine());
             int fra = Integer.parseInt(st.nextToken());
             int til = Integer.parseInt(st.nextToken());
             int vekt = Integer.parseInt(st.nextToken());
             Vkant k = new Vkant(node[til],(Vkant)node[fra].kant1, vekt);
             node[fra].kant1 = k;
        }
    }


}

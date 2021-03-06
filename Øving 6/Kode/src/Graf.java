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

    public void ny_ugraf(BufferedReader br) throws IOException  {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        node = new Node[N];
        for (int i=0;i<N;i++) {
            node[i] = new Node();
            node[i].number=i;
        }
        K = Integer.parseInt(st.nextToken());
        for (int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int fra = Integer.parseInt(st.nextToken());
            int til = Integer.parseInt(st.nextToken());
            node[fra].kant1 = new Kant(node[til],node[fra].kant1);
        }
    }

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

    public Node df_topo(Node n, Node l){
        Topo_lst nd = (Topo_lst) n.d;
        if(nd.funnet) return l;
        nd.funnet = true;
        for(Kant k = n.kant1;k!=null;k=k.neste){
            l = df_topo(k.til,l);
        }
        nd.neste = l;
        System.out.println(n.number);
        return n;
    }

    public Node topologisort(){
        Node l = null;
        for(int i=N;i-->0;){
            node[i].d = new Topo_lst();
        }
        for (int i=N;i-->0;){
            l = df_topo(node[i],l);
        }
        return l;
    }









}

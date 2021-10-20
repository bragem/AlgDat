import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import static java.lang.Math.min;

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


    public int bfs(Node kilde, Node sluk){
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(kilde);
        Vkant[] forrige = new Vkant[N];
        while (!queue.isEmpty()){
            Node n = queue.getFirst();
            for(Vkant k = (Vkant)n.kant1;k!=null;k=(Vkant)k.neste){

                if(k.beregnRestkapasitet()==0) {
                    queue.removeFirst();
                    continue;
                }
                Forgj f =  (Forgj) k.til.d;
                if (f.dist == f.uendelig){
                    f.dist = ((Forgj)n.d).dist+1;
                    f.forgj = n;
                    forrige[k.til.number] = k;
                    queue.add(k.til);
                }
                queue.removeFirst();
            }
        }

        //finner vei og flaskehals
        int flaskehals = Integer.MAX_VALUE;
        for (Vkant k = forrige[sluk.number];k!=null;k=forrige[k.til.number]){
            flaskehals = min(flaskehals, k.beregnRestkapasitet());
        }

        //backtracker og oppdaterer flyt
        for (Vkant k = forrige[sluk.number];k!=null;k=forrige[k.til.number]){
            k.flyt += flaskehals;
            ((Vkant)k.motsatt).flyt -= flaskehals;
        }
        return flaskehals;

    }

    public void ny_vgraf(BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        node = new Node[N];
        for (int i=0;i<N;++i){
            node[i] = new Node();
            node[i].number = i;
        }
        K = Integer.parseInt(st.nextToken());
        for (int i=0;i<K;++i){
             st = new StringTokenizer(br.readLine());
             int fra = Integer.parseInt(st.nextToken());
             int til = Integer.parseInt(st.nextToken());
             int vekt = Integer.parseInt(st.nextToken());
             Vkant k = new Vkant(node[til],(Vkant)node[fra].kant1, vekt);
             k.motsatt = new Vkant(node[fra],(Vkant)node[til].kant1,0);
             k.motsatt.motsatt = k;
             node[fra].kant1 = k;
        }
    }


    public int getMaxFlow(Node kilde, Node sluk){
        int flow;
        int maxFlow=0;
        initForgj(kilde);
        do{
            //markAllNodesAsUnvisited
            for(int i=0;i< node.length;i++){
                ((Forgj)node[i].d).dist=1000000000;
            }
            flow=bfs(kilde,sluk);
            maxFlow+=flow;
        }
        while(flow!=0);
        return maxFlow;
    }


}

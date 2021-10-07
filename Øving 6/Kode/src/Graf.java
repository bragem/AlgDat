import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Graf {
    //antall noder
    int N;
    //antall kanter
    int K;
    Node[] node;

    public void ny_ugraf(BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        node = new Node[N];
        for (int i=0;i<N;i++) node[i] = new Node();
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
        ((Forgj)s.d).dist = 0;
    }


}

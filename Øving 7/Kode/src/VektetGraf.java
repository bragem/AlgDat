import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class VektetGraf {
    private int N, K, edgeAmount;
    private List<List<Kant>> graftabell;

    public VektetGraf(BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        graftabell = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            graftabell.add(new ArrayList<>());
        }
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            addEdges(from, to, weight);
            edgeAmount +=2;
        }
    }

    public void addEdges(int vertexFrom, int vertexTo, int weight) {
        if (vertexFrom < N && vertexFrom >= 0 && weight > 0 && vertexTo < N) {
            Kant kant1 = new Kant(vertexTo, weight);
            Kant kant2 = new Kant(vertexFrom, 0);
            graftabell.get(vertexFrom).add(kant1);
            graftabell.get(vertexTo).add(kant2);
        }
    }


    public boolean bfs(int start, int sluk, int[] nodeliste){
        boolean[] visited = new boolean[N];
        LinkedList<Integer> queue = new LinkedList<>();
        nodeliste[start] = -1;
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            start = queue.getFirst();
            for (Kant kant : graftabell.get(start)){

                if(!visited[kant.til] && kant.weight>0){
                    visited[kant.til] = true;
                    nodeliste[kant.til] = start;
                    queue.add(kant.til);
                }

            }
        }
        return visited[sluk];
    }

    public void edmondKarp(int start, int sluk){
        int maxflow;
        int[] nodeliste = new int[N];
        int[] print = new int[N];
        for(int i = 0; i<N;i++){
            print[i] = -1;
        }
        

    }

    public String printFlow(int start, int[] printNodes){
        StringBuilder print = new StringBuilder(start + " ");
        for (int i = 0; i < N; i++) {
            if (printNodes[i]>=0){
                print.append(i).append(" ");
            }
        }
        return print.toString();
    }



}

import java.io.*;
import java.util.*;

public class Tour {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int N = Integer.parseInt(first[0]);
        int M = Integer.parseInt(first[1]);
        int S = Integer.parseInt(first[2]);
        int Q = Integer.parseInt(first[3]);

        List<Integer>[] adj = new ArrayList[N+1];
        for (int i=1;i<=N;i++) adj[i] = new ArrayList<>();

        for (int i=0;i<M;i++) {
            String[] parts = br.readLine().split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            adj[u].add(v);
            adj[v].add(u);
        }

       String[] srcIn=br.readLine().split(" ");
       int [] src=new int[S];
       for(int i=0;i<S;i++) src[i]=Integer.parseInt(srcIn[i]);          //read and type cast source

       String[] desIn=br.readLine().split(" ");                  //typecast des
       int [] des=new int[Q];
       for(int i=0;i<Q;i++) des[i]=Integer.parseInt(desIn[i]);

       int [] dist=new int[N+1];
       Arrays.fill(dist,-1);          //distance 

       

       Queue<Integer> q=new ArrayDeque<>();
       
       for(int s: src){
        dist[s]=0;
        q.add(s);            //queue all src
       }

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int d : des) {
            sb.append(dist[d]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}

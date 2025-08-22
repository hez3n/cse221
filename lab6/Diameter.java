import java.io.*;
import java.util.*;

public class Diameter {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        List<Integer>[] adj = new ArrayList[N+1];
        for (int i=1;i<=N;i++) adj[i] = new ArrayList<>();

        for (int i=0;i<N-1;i++) {
            String[] parts = br.readLine().split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            adj[u].add(v);
            adj[v].add(u);
        }

        int[] dist = new int[N+1];

        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);           ///always starting at 1
        dist[1]=0;             
        int A=1;                //initially where the bfs is
        
        while(!q.isEmpty()){
            int u=q.poll();
            for(int v: adj[u]){
                if(dist[v]==-1){           //now found before
                    dist[v]=dist[u]+1;      
                    q.add(v);
                    if(dist[v]>dist[A]) A=v; // updating state until reach endpoint
                }
            }
        }
        //A should be the endpoint now
        Arrays.fill(dist, -1);
        q.add(A);
        dist[A]=0;
        int B=A;

        while(!q.isEmpty()){
            int u=q.poll();
            for(int v: adj[u]){
                if(dist[v]==-1){
                    dist[v]=dist[u]+1; 
                    q.add(v);
                    if(dist[v]>dist[B]) B=v;  //update until reach other end point
                }
            }
        } 
        System.out.println(dist[B]);         //dist[B] is the distance from A to B
        System.out.println(A + " " + B);
    }
}

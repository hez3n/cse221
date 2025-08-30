
import java.io.*;
import java.util.*;

public class Where {

    static long[] dijk(int N,ArrayList<int[]>[] adj, int src){
          long [] dist=new long[N+1];
          Arrays.fill(dist, Long.MAX_VALUE);
          dist[src]=0;

          PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
          pq.add(new long[]{0,src});
          
          while(!pq.isEmpty()){
            long [] curr=pq.poll();
            long d= curr[0];
            int u=(int) curr[1];

            for(int [] nei : adj[u]){
                int v=nei[0];
                int w=nei[1];
                if(dist[v]>d+w){
                    dist[v]=d+w;
                    pq.add(new long[]{dist[v],v});
                }
            }
          }

          return dist;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new int[]{v, w});
        }

        long[]alice=dijk(N,adj,S);
        long[]bob=dijk(N,adj,T);

        long minTime=Long.MAX_VALUE;
        int place=-1;

        for (int i = 1; i <= N; i++) {
            if (alice[i] == Long.MAX_VALUE || bob[i] == Long.MAX_VALUE) continue;
            long meetTime = Math.max(alice[i], bob[i]);
            if (meetTime < minTime || (meetTime == minTime && i < place)) {
                minTime = meetTime;
                place = i;
            }
        }
        if (place == -1) 
            System.out.println(-1);
         else 
            System.out.println(minTime + " " + place);
        
    }
}

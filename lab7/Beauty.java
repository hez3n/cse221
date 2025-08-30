import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Beauty {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        long[] weight = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            weight[i] = Long.parseLong(st.nextToken());
        }

        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
        }
        
        long [] dist= new long[N+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[S]=weight[S];

        PriorityQueue<long[]> pq=new PriorityQueue<>(Comparator.comparingLong(a->a[0]));
        pq.add(new long[]{dist[S], S});

        while(!pq.isEmpty()){
            long[] curr= pq.poll();
            long d=curr[0];
            int  u=(int )curr[1];

            if(d>dist[u]) continue;

            for(int v: graph[u]){
                long newdist=dist[u]+weight[v];
                if(dist[v]>newdist){
                    
                    dist[v]=newdist;
                    pq.add(new long[]{dist[v], v});

                }
            }
        }
        if (dist[D] == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(dist[D]);
    }

}

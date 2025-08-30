
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Danger {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] adj=new ArrayList[N+1];
        for(int i=0;i<=N;i++) adj[i]=new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new int[]{v,w});
            adj[v].add(new int[]{u,w});
        }

        long [] danger=new long[N+1];
        Arrays.fill(danger, Long.MAX_VALUE);
        danger[1]=0;

        PriorityQueue<long[]> pq=new PriorityQueue<>(Comparator.comparingLong(a->a[0]));
        pq.add(new long[]{0,1});

        while(!pq.isEmpty()){
            long[] curr= pq.poll();
            long d=curr[0];
            int  u=(int )curr[1];

            if(d>danger[u]) continue;

            for( int[]neig:adj[u]){
                int v=neig[0];
                int w=neig[1];

                long  maxDang= Math.max(danger[u], w);
                if(danger[v]>maxDang){
                    danger[v]=maxDang;
                    pq.add(new long[]{maxDang, v});
                }
            }
            
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (danger[i] == Long.MAX_VALUE) sb.append("-1 ");
            else sb.append(danger[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}

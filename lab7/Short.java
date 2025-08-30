import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Short{

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int S=Integer.parseInt(st.nextToken());
        int D=Integer.parseInt(st.nextToken());

        int[] u=new int[M];
        int[] v=new int[M];
        int[] w=new int[M];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++)u[i]=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++)v[i]=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++)w[i]=Integer.parseInt(st.nextToken());

        List<int[]>[] adj=new ArrayList[N+1];
        for(int i=0;i<=N;i++)adj[i]=new ArrayList<>();
        for(int i=0;i<M;i++){
            adj[u[i]].add(new int[]{v[i],w[i]});
        }

        long[] dist=new long[N+1];
        int[] parent=new int[N+1];
        Arrays.fill(dist,Long.MAX_VALUE);
        Arrays.fill(parent,-1);
        dist[S]=0;

        PriorityQueue<long[]> pq=new PriorityQueue<>(Comparator.comparingLong(a->a[0]));
        pq.add(new long[]{0,S});

        while(!pq.isEmpty()){
            long[] cur=pq.poll();
            long d=cur[0];
            int node=(int)cur[1];
            if(d>dist[node])continue;

            for(int[] edge:adj[node]){
                int next=edge[0];
                int weight=edge[1];
                if(dist[next]>d+weight){
                    dist[next]=d+weight;
                    parent[next]=node;
                    pq.add(new long[]{dist[next],next});
                }
            }
        }

        if(dist[D]==Long.MAX_VALUE){
            System.out.println(-1);
            return;
        }

        List<Integer> path=new ArrayList<>();
        for(int cur=D;cur!=-1;cur=parent[cur]){
            path.add(cur);
        }
        Collections.reverse(path);

        System.out.println(dist[D]);
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i));
            if(i+1<path.size())System.out.print(" ");
        }
        System.out.println();
    }
}
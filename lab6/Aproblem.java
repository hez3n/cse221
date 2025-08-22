
import java.io.*;
import java.util.*;
public class Aproblem{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] l1= br.readLine().split(" ");
        
        int N=Integer.parseInt(l1[0]);
        int M=Integer.parseInt(l1[1]);

        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();

        for(int i=0;i<=N;i++) adj.add(new ArrayList<>());

        int [] indegree= new int[N+1];

        for(int i=0;i<M;i++){
            String [] edge= br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);

            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1;i<=N;i++){
            if(indegree[i] == 0)
              q.add(i);
        }

        int count=0;

        while(!q.isEmpty()){
            int u=q.poll();
            sb.append(u).append(" ");
            count++;

            for(int v: adj.get(u)){
                indegree[v]--;
                if(indegree[v]==0) q.add(v);
            }
        }

        if (count !=N){
            System.out.println(-1);
        }
        else{
            System.out.println(sb);
        }
    }
}
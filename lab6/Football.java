
import java.io.*;
import java.util.*;

public class Football {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String [] l1= br.readLine().split(" ");

        int N= Integer.parseInt(l1[0]);
        int M= Integer.parseInt(l1[1]);

        List<Integer>[] adj= new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
             adj[i] = new ArrayList<>(); 
        }

        for(int i=0;i<M;i++){
            String [] edge= br.readLine().split(" ");
            int u= Integer.parseInt(edge[0]);
            int v= Integer.parseInt(edge[1]);
            adj[u].add(v);
            adj[v].add(u);
        }

        int []color=new int[N+1];

        int ans=0;
         
        for(int i=1;i<=N;i++){
            if(color[i]!=0) continue;

            Queue<Integer> queue=new LinkedList<>();
            queue.add(i);
            color[i] = 1;
            int countA = 1;
            int countB = 0;

            while(!queue.isEmpty()){
                int x=queue.poll();
                for(int neigh: adj[x]){
                    if(color[neigh]==0){
                        color[neigh]=- color[x]; //opposite of prev
                        if(color[neigh]==1) countA++;
                        else countB++;
                        queue.add(neigh);
                    }
                }
            }
            ans+=Math.max(countA, countB);
        }
        System.out.println(ans);
    }
}

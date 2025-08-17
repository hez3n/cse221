import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Traverse2 {
    static StringBuilder sb= new StringBuilder();
    static int  []color;
    static ArrayList<Integer>[]adj;
    public static void main(String[] args)throws IOException {
      BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
      

      String[]inp= br.readLine().split(" ");
      int N =Integer.parseInt(inp[0]);
      int M =Integer.parseInt(inp[1]);

      adj=new ArrayList[N+1];
      color=new int[N+1];             // array of arraylist

      for(int i=1;i<=N;i++){                                   //create empty arraylists
        adj[i]=new ArrayList<>();
      }
      
      String [] l2=br.readLine().split(" ");
      String[]l3=br.readLine().split(" ");

      for(int i=0;i<M;i++){
        int u=Integer.parseInt(l2[i]);
        int v=Integer.parseInt(l3[i]);

        adj[u].add(v);
        adj[v].add(u);

      }
      
      for(int i=1;i<=N;i++){
        Collections.sort(adj[i]);
      }
      
      dfs(1);
      System.out.print(sb);
      
    }

    public static void dfs(int vertex){
        color[vertex]=1;
        sb.append(vertex).append(" ");
        
        for(int neigh: adj[vertex]){
          if(color[neigh]==0){
            dfs(neigh);
          }
        }
    }
}

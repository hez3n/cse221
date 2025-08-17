
import java.io.*;
import java.util.ArrayList;

public class TreeQuaries {

    static StringBuilder sb= new StringBuilder();
    static int  []color;
    static ArrayList<Integer>[]adj;
    static int []subtree;
    public static void main(String[] args)throws IOException {
      BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
      

      String[]inp= br.readLine().split(" ");
      int N =Integer.parseInt(inp[0]);
      int R =Integer.parseInt(inp[1]);

      adj=new ArrayList[N+1];
      color=new int[N+1];             
      subtree=new int[N+1];

      for(int i=1;i<=N;i++){                                   
        adj[i]=new ArrayList<>();
      }

      for(int i=0;i<N-1;i++){
        String [] edges=br.readLine().split(" ");
        int u=Integer.parseInt(edges[0]);
        int v=Integer.parseInt(edges[1]);
        
        adj[u].add(v);
        adj[v].add(u);
      }

      dfs(R);

      int q=Integer.parseInt(br.readLine());

      for(int i=0;i<q;i++){
          int a= Integer.parseInt(br.readLine());
          sb.append(subtree[a]).append("\n");

      }
      System.out.print(sb);

    }

    public static void dfs(int vertex){
        color[vertex]=1;
        subtree[vertex]=1;

        for(int neigh:adj[vertex]){
            if(color[neigh]==0){
                dfs(neigh);
                subtree[vertex]+=subtree[neigh];
            }
        }
    }
}

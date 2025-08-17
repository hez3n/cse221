import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Cycle {
    
    static int  []color;
    static ArrayList<Integer>[]adj;

    static boolean cycle=false;
    public static void main(String[] args)throws IOException {
      BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
      

      String[]inp= br.readLine().split(" ");
      int M =Integer.parseInt(inp[0]);
      int N =Integer.parseInt(inp[1]);

      adj=new ArrayList[M+1];
      color=new int[M+1];

      for(int i=1;i<=M;i++){                                   //create empty arraylists
        adj[i]=new ArrayList<>();
      }

      for( int i=0;i<N; i++){
         String[]edge= br.readLine().split(" ");
         int u =Integer.parseInt(edge[0]);
         int v =Integer.parseInt(edge[1]);

         adj[u].add(v);
      }
      for(int i=1;i<=M;i++){
        if(color[i]==0){
            dfs(i);
            if(cycle) break;
        }
        
      }

      if(cycle) System.out.println("YES");
      else System.out.println("NO");
    }

    public static void dfs(int vertex){
        color[vertex]=1;
        
        for(int neigh: adj[vertex]){
            if(color[neigh]==0){         //not visited before
                 dfs(neigh);
                 if(cycle) return;
            }
            else if(color[neigh]==1){
                cycle=true;
                return;
            }
        }
        color[vertex]=2;
    }
}

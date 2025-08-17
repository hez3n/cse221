import java.io.*;
import java.util.*;

public class LightningMcQn{
  public static void main(String[] args)throws IOException {
      BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb= new StringBuilder();

      String[]inp= br.readLine().split(" ");
      int N =Integer.parseInt(inp[0]);
      int M =Integer.parseInt(inp[1]);
      int start =Integer.parseInt(inp[2]);
      int end=Integer.parseInt(inp[3]);

      

      ArrayList<Integer>[] adj=new ArrayList[N+1];             // array of arraylist

      for(int i=1;i<=N;i++){                                  //ceate empty arraylists
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
      
     for(int i=1;i<=N;i++){                                  //ceate empty arraylists
        adj[i].sort(null);
      }
      if(start==end){
        System.out.print(0+"\n"+start);
        return;
      }

     int []color=new int [N+1];
     int []parent=new int[N+1];

     Queue<Integer> q=new LinkedList<>();

     q.add(start);
     color[start]=1;

     while(!q.isEmpty()){

        int vertex= q.poll();
        if(vertex==end) break;          //break when reached end

        for(int neigh : adj[vertex]){
            if(color[neigh]==0){
                color[neigh]=1;
                parent[neigh]=vertex;
                q.add(neigh);
            }
        }
     }

     if(parent[end]==0){
        System.out.print(-1); return;
     }
     

    ArrayList<Integer> lightning_path =new ArrayList<>();
     
     for(int i=end; i!=0;i=parent[i]){
        lightning_path.add(i);
     }
     Collections.reverse(lightning_path);
     
     int count=lightning_path.size()-1;
    
    for(int temp: lightning_path){
        sb.append(temp).append(" ");
    }
    System.out.print(count+"\n"+sb);
  }
}
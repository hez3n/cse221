
import java.io.*;
import java.util.*;

public class Traverse1{
  public static void main(String[] args)throws IOException {
      BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb= new StringBuilder();

      String[]inp= br.readLine().split(" ");
      int N =Integer.parseInt(inp[0]);
      int M =Integer.parseInt(inp[1]);

      ArrayList<Integer>[] adj=new ArrayList[N+1];             // array of arraylist

      for(int i=1;i<=N;i++){                                  //ceate empty arraylists
        adj[i]=new ArrayList<>();
      }

      for(int i=0;i<M;i++){                                    //create graph
        String [] edges=br.readLine().split(" ");
        int u=Integer.parseInt(edges[0]);
        int v=Integer.parseInt(edges[1]);

        adj[u].add(v);
        adj[v].add(u);
      }

      int [] color=new int [N+1];      
      
      Queue<Integer> q= new LinkedList<>() ;

      q.add(1);
      color[1]=1;            //starting 

      while(!q.isEmpty()){
        int vertex= q.poll();
        sb.append(vertex).append(" ");

       for(int neigh:adj[vertex]){
        if(color[neigh]==0){
            color[neigh]=1;
            q.add(neigh);
        }
       }
      }
      System.out.print(sb);
    
      

  }
}
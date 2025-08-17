import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Jungle {
    
    public static void main(String[] args)throws IOException {
      BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb= new StringBuilder();

      String[]inp= br.readLine().split(" ");
      int N =Integer.parseInt(inp[0]);
      int M =Integer.parseInt(inp[1]);
      int start =Integer.parseInt(inp[2]);
      int end=Integer.parseInt(inp[3]);
      int K=Integer.parseInt(inp[4]);

      ArrayList<Integer>[] adj=new ArrayList[N+1];             // array of arraylist

      for(int i=1;i<=N;i++){                                  //ceate empty arraylists
        adj[i]=new ArrayList<>();
      }

      for(int i=0;i<M;i++){                                    //create graph
        String [] edges=br.readLine().split(" ");
        int u=Integer.parseInt(edges[0]);
        int v=Integer.parseInt(edges[1]);

        adj[u].add(v);
        
      }
      if(start==K && K==end){
        System.out.println(0+"\n"+start);
        return;
      }
    
     int []color=new int [N+1];
     int []parent=new int[N+1];
     
     
    if(start!=K){
         Queue<Integer> q=new LinkedList<>();

     q.add(start);
     color[start]=1;

     while(!q.isEmpty()){

        int vertex= q.poll();
        if(vertex==K) break;          //break when reached K

        for(int neigh : adj[vertex]){
            if(color[neigh]==0){
                color[neigh]=1;
                parent[neigh]=vertex;
                q.add(neigh);
            }
        }
     }
      if(color[K]==0){
        System.out.println(-1);
        return;
      }
     
     }

     int [] color2=new int [N+1];
     int []parent2=new int[N+1];

     Queue<Integer> q2 = new LinkedList<>();
     q2.add(K);
     color2[K]=1;

     while(!q2.isEmpty()){

        int vertex= q2.poll();
        if(vertex==end) break;          

        for(int neigh : adj[vertex]){
            if(color2[neigh]==0){
                color2[neigh]=1;
                parent2[neigh]=vertex;
                q2.add(neigh);
            }
        }
     }

     if(color2[end]==0){
        System.out.print(-1); return;
     }
    List<Integer> lightning_path =new ArrayList<>();

    if(start!=K){
     
     for(int i=K; i!=0;i=parent[i]){
        lightning_path.add(i);
     }
     Collections.reverse(lightning_path);
    }
    else{
        lightning_path.add(K);
    }
    
    
     
     List<Integer> lightning_path2 =new ArrayList<>();
     
     for(int i=end; i!=0;i=parent2[i]){
        lightning_path2.add(i);
     }
     Collections.reverse(lightning_path2);
    
    for(int temp:lightning_path) sb.append(temp).append(" ");
    for(int i=1;i<lightning_path2.size();i++) sb.append(lightning_path2.get(i)).append(" ");
    
    int count=lightning_path.size()+lightning_path2.size()-2;

    System.out.print(count+"\n"+sb);
    
    

    }
    

    
}

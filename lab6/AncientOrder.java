
import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class AncientOrder {
    public static void main(String[] args) throws IOException {
     BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
     StringBuilder sb = new StringBuilder();
        
        
     int N=Integer.parseInt(br.readLine());

     String [] words= new String [N];
     boolean[] used=new boolean[26];         //all alphabet

     for(int i=0;i<N;i++){
        words[i]=br.readLine();              //reading words
        for(char c:words[i].toCharArray()){
            used[c-'a']=true;                //if found set true   [c-'a'] converting index to alphabet number        
        }
     }
   
     ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
     for (int i = 0; i < 26; i++) adj.add(new ArrayList<>());

     int [] indegree=new int[26];

     boolean valid=true;

     for(int i=0;i<N-1 && valid;i++){             //till n-1 because always comparing i and i+1 pair
        String w1=words[i];
        String w2=words[i+1];

        int minlen= Math.min(w1.length(), w2.length());
        boolean foundDif=false;

        for(int j=0;j<minlen;j++){
            char c1=w1.charAt(j);
            char c2=w2.charAt(j);

            if(c1!=c2){
                adj.get(c1-'a').add(c2-'a');    //edge from c1 to c2
                indegree[c2-'a']++;
                foundDif=true;
                break;
            }
        }
        if (!foundDif && w1.length() > w2.length()) valid=false;
     }

     if(!valid){
        System.out.println(-1);
        return;
     }
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      for (int i = 0; i < 26; i++) {
            if (used[i] && indegree[i] == 0) pq.add(i);     //queueing ones without any indegree
        }
    
      int count =0;
      int totalLetters = 0;

      for (boolean b : used) {
        if (b) totalLetters++;      //used letter count
      }


      while(!pq.isEmpty()){
            int u = pq.poll();
            sb.append((char) (u + 'a'));  // type casting to char 
            count++;

            for(int v:adj.get(u)){
                indegree[v]--;
                if (indegree[v] == 0) pq.add(v);
            }

      }
      
      if(count!=totalLetters){
        System.out.println(-1);
      }
      else{
        System.out.println(sb.toString());
      }
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AdjList {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] inp=br.readLine().split(" ");

        int n= Integer.parseInt(inp[0]);
        int e= Integer.parseInt(inp[1]);
        
        String [] source = br.readLine().split(" ");
        String [] des = br.readLine().split(" ");
        String [] weight = br.readLine().split(" ");

        int [] s = new int[e];
        int [] d = new int [e];
        int [] w= new int[e];

        for(int k=0; k<e;k++){
            s[k]=Integer.parseInt(source[k]);
            d[k]=Integer.parseInt(des[k]);
            w[k]=Integer.parseInt(weight[k]);
        }

        HashMap<Integer, List<String>> adjList = new HashMap<>();
        
        for(int i=0;i<e;i++){
            adjList.putIfAbsent(s[i],new ArrayList<>());
            adjList.get(s[i]).add("("+d[i]+","+w[i]+")");
        }
       
        for(int j=1; j<=n;j++){
            System.out.print(j+":");
            List<String> edgeList= adjList.get(j);
            if(edgeList!=null){
                for(String edge: edgeList){
                    System.out.print(" "+edge);
                }
            }
            System.out.println();
        }
    }
}

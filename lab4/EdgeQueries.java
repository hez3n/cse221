
import java.io.*;
import java.util.*;
public class EdgeQueries {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] inp= br.readLine().split(" ");
        int v=Integer.parseInt(inp[0]);
        int e= Integer.parseInt(inp[1]);

        HashMap<Integer,Integer> dif= new HashMap<>();

        for(int k=1;k<=v;k++){
            dif.put(k,0);
        }
        String[] inp2=br.readLine().split(" ");
        int []arr= new int [e];
        for(int i=0;i<e;i++){
            arr[i]=Integer.parseInt(inp2[i]);
            dif.put(arr[i],dif.get(arr[i])-1);
        }
        String[] inp3=br.readLine().split(" ");
        int []arr2= new int [e];
        for(int i=0;i<e;i++){
            arr2[i]=Integer.parseInt(inp3[i]);
            dif.put(arr2[i],dif.get(arr2[i])+1);
        }
        for(int i=1;i<=v;i++){
            System.out.print(dif.get(i)+" ");
        }

    }
}

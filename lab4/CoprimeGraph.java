
import java.io.*;
import java.util.*;


public class CoprimeGraph {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] inp=br.readLine().split(" ");
        int n=Integer.parseInt(inp[0]);
        int q=Integer.parseInt(inp[1]);

        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        ArrayList<Integer> zero=new ArrayList<>();
        adjList.add(zero);

        for(int i=1;i<=n;i++){
            ArrayList<Integer> temp= new ArrayList<>();
            for(int j=1;j<=n;j++){
                if(i==j) continue;
                if(gcd(i,j)==1){
                    temp.add(j);
                }
            }
            Collections.sort(temp);
            adjList.add(temp);
        }
        
        for(int i=1;i<=q;i++){
            String [] inp2=br.readLine().split(" ");
            int x=Integer.parseInt(inp2[0]);
            int y=Integer.parseInt(inp2[1]);
            
            ArrayList<Integer> temp= new ArrayList<>();
            temp=adjList.get(x);
            int size=temp.size();
            if(size<y){
                System.out.println(-1);
            }
            else{
                System.out.println(temp.get(y-1));
            }
        }
    }
    public static int gcd(int a, int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}

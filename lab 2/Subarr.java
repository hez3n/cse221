
import java.io.*;


public class Subarr {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");  
        int n=Integer.parseInt(s[0]);
        int sum=Integer.parseInt(s[1]);
        String[] inp=br.readLine().split(" ");
        int [] arr=new int [n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(inp[i]);
        }

        int i=-1;
        int best=0;
        int currSum=0;
        for(int j=0;j<n;j++){
            currSum+=arr[j];
            while (currSum>sum){
                i++;
                currSum-=arr[i];
            }
            best=Math.max(best, j-i);   
        }
        System.out.print(best);

    }
}

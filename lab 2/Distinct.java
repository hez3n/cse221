
import java.io.*;

public class Distinct {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");  
        int n=Integer.parseInt(s[0]);
        int k=Integer.parseInt(s[1]);
        String[] inp=br.readLine().split(" ");
        int [] arr=new int [n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(inp[i]);
        }
        int [] count=new int[1000000];
        int l=-1;
        int max=0;
        int dist=0;

        for(int r=0;r<n;r++){
            if(count[arr[r]]==0){
                dist++;
            }
            count[arr[r]]++;

            while(dist>k){
                l++;
                count[arr[l]]--;
                if(count[arr[l]]==0){
                    dist--;
                }
            }
            max=Math.max(max,r-l);
        }
        System.out.print(max);
    }
}

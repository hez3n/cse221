import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Drift {
     public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test = Integer.parseInt(br.readLine());
        for (int i = 0; i < test; i++) {
        String [] inp=br.readLine().split(" ");
        Long a=Long.parseLong(inp[0]);
        Long b=Long.parseLong(inp[1]);
        long mod=Long.parseLong(inp[2]);
        long ans=seriesSum(a,b,mod);
        sb.append(ans).append("\n");
        }
        System.out.print(sb);
        
        }
    public static long fastMod(long a, long b,long mod){
        long ans=1;
        a%=mod;
        while (b>0){
          if(b%2!=0){
            ans=(ans*a)%mod;
          }
          a=(a*a)%mod;
          b/=2;
       }
       return ans;
    }
    public static long seriesSum(long a,long b,long mod){
        if(b==1) return a%mod;
        if(b%2==0){
            long left=seriesSum(a,b/2,mod);
            long half=fastMod(a,b/2,mod);
            return (left*(1+half)%mod)%mod;
        }
        else{
            long left=seriesSum(a,b-1,mod);
            long last=fastMod(a,b,mod);
            return (left+last)%mod;
        }
    }
}


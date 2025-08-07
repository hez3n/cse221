import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
 
 
 
public class FastMod {
    
    public static void main(String[] args)throws IOException {
        long mod=107;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        String [] inp=br.readLine().split(" ");
        Long a=Long.parseLong(inp[0]);
        Long b=Long.parseLong(inp[1]);
        
        long ans=1;
 
       while (b>0){
          if(b%2!=0){
            ans=(ans*a)%mod;
          }
          a=(a*a)%mod;
          b/=2;
       }
       System.out.println(ans);
    }
}

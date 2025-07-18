import java.io.*;
public class SearchingNotfun {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        long t=Integer.parseInt(br.readLine());
        for(long i=0;i<t;i++){
            String []s=br.readLine().split(" ");
            long k=Long.parseLong(s[0]);
            long x=Long.parseLong(s[1]);

            long l=1; 
            long r=(long)1e18;
            if(x==1){
                System.out.println(0);
                continue;
            }
            while(l<r){
                 long  mid=(l+r)/2;
                 long count= mid -(mid/x);
                 if(count<k){
                    l=mid+1;
                 }
                 else{
                    r=mid;
                 }          
            }
            System.out.println(l);
        }
    }
}

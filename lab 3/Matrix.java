import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Matrix {
    
    public static void main(String[] args)throws IOException {
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int test=Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<test;i++){
            String []inp1=br.readLine().split(" ");
            long[][] matrix={
               {Long.parseLong(inp1[0]), Long.parseLong(inp1[1])},
               {Long.parseLong(inp1[2]), Long.parseLong(inp1[3])}
            };
            long x=Long.parseLong(br.readLine());
            long[][] ans=fastMod(matrix,x);

            sb.append(ans[0][0]).append(" ").append(ans[0][1]).append("\n");
            sb.append(ans[1][0]).append(" ").append(ans[1][1]).append("\n");
            
        }
        System.out.print(sb);

        
    }
    public static long mod=1000000007;
    public static long [][]fastMod(long[][] matrix,long x){
      long [][]ans={
        {1,0},
        {0,1}
      };
      while (x>0){
          if(x%2!=0){
            ans=matrixmult(ans,matrix);
          }
          matrix=matrixmult(matrix,matrix);
          x/=2;
       }
       return ans;

    }
    public static long[][] matrixmult(long[][] A,long [][]B){
        long [][] c=new long[2][2];
        c[0][0] = (A[0][0]*B[0][0] + A[0][1]*B[1][0]) % mod;
         c[0][1] = (A[0][0]*B[0][1] + A[0][1]*B[1][1]) % mod;
        c[1][0] = (A[1][0]*B[0][0] + A[1][1]*B[1][0]) % mod;
        c[1][1] = (A[1][0]*B[0][1] + A[1][1]*B[1][1]) % mod;
       
        return c;
        
    }
}

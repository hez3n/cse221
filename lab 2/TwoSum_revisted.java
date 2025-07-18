
import java.io.*;

public class TwoSum_revisted {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");
        int len1=Integer.parseInt(s[0]);
        int len2=Integer.parseInt(s[1]);
        int sum=Integer.parseInt(s[2]);
        String []inp1=br.readLine().split(" ");
        String []inp2=br.readLine().split(" ");
        int[] arr1=new int[len1];
        int []arr2=new int[len2];
        

        for(int i=0;i<len1;i++){
            arr1[i]=Integer.parseInt(inp1[i]);
            
        }
        for(int i=0;i<len2;i++){
            arr2[i]=Integer.parseInt(inp2[i]);
        }
        
        int i=0;
        int j=len2-1;
        int closest=10000000;
        int idx_1=-1;
        int idx_2=-1;
        
        
        while(i<len1 && j>=0){
          int dif=Math.abs(sum-(arr1[i]+arr2[j]));
          if(dif<closest){
            closest=dif;
            idx_1=i;
            idx_2=j;
          }
          if(arr1[i]+arr2[j]==sum){
                 idx_1=i;
                 idx_2=j;
                 break;
          }
          if(arr1[i]+arr2[j]<sum){ 
            i++;
            
          }    
          else {j--;};
          
        
    }
        System.out.println((idx_1+1)+" "+(idx_2+1));
         
    }
  
}

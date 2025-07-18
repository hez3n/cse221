
import java.io.*;
public class Count {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");  
        int len1=Integer.parseInt(s[0]);
        int q=Integer.parseInt(s[1]);
        String[] inp=br.readLine().split(" ");
        int [] arr=new int [len1];
        for(int i=0;i<len1;i++){
            arr[i]=Integer.parseInt(inp[i]);
        }
        for(int i=0;i<q;i++){
           String[] s2=br.readLine().split(" ");
           int lower=Integer.parseInt(s2[0]);
           int higher=Integer.parseInt(s2[1]);
           
           int l=lowerRange(arr, lower);
           int r=higherRange(arr,higher);
           
          System.out.println(r-l);

           
        } 
       
    }
    public static int lowerRange(int []arr,int val){
            int l=0; int r=arr.length;

            while(l<r){
                int mid=(l+r)/2;
                if(arr[mid]>=val)
                   r=mid;
                else l=mid+1;

            }
            return l;
    }
    public static int higherRange(int []arr,int val){
        int l=0; int r=arr.length;
        while(l<r){
            int mid = (l+r)/2;
            if(arr[mid]>val) r=mid;
            else l=mid+1;
        }
        return l;
    }
}

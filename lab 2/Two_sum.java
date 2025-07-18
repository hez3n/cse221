import java.io.*;
public class Two_sum{
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
        int i=0;
        int j=n-1;
        boolean flag=false;
        while (i<j){
            if(arr[i]+arr[j]==sum){
                 System.out.println(++i+" "+ ++j);
                 flag=true;
                 break;
            }
            
            else if(arr[i]+arr[j]<sum) i++;
            
            else if(arr[i]+arr[j]>sum) j--;
            
        }
        if(flag==false)
         System.out.println(-1);
         
    }
}
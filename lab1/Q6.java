
import java.io.*;

public class Q6 {
    public static void main(String[]args)throws IOException{
       InputStreamReader in=new InputStreamReader(System.in);
       BufferedReader br=new BufferedReader(in);

       int n=Integer.parseInt(br.readLine());
       String s=br.readLine();
       String[] arr=s.split(" ");
       for(int k=0;k<n;k++){

       
       for(int i=0;i<n-1;i++){
          String temp="";
          
          if(Long.parseLong(arr[i])%2==0 && Long.parseLong(arr[i+1])%2==0 && Long.parseLong(arr[i+1]) <= Long.parseLong(arr[i])){
            temp=arr[i];
            arr[i]=arr[i+1];
            arr[i+1]=temp;
          }
          else if(Long.parseLong(arr[i])%2!=0 && Long.parseLong(arr[i+1])%2!=0  && Long.parseLong(arr[i+1]) <= Long.parseLong(arr[i])){
            temp=arr[i];
            arr[i]=arr[i+1];
            arr[i+1]=temp;
          }
       }
    }
       for(int j=0;j<n;j++){
        System.out.print(arr[j]+" ");
       }
 }
}

import java.io.*;
 
public class Q5eo {
    public static void main(String[]args)throws IOException{
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(in);
 
        int n=Integer.parseInt(br.readLine());
        
        
        String inp=br.readLine();
        String[] arr=inp.split(" ");
        long arr2[]=new long[n];
        
        for (int j=0;j<n;j++){
          arr2[j]=Integer.parseInt(arr[j]);
        }
        
        long count=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr2[i]>arr2[j])
                  count++;
            }
        }
        if(count%2==0)
         System.out.println("YES");
        else
          System.out.println("NO");
      
    
  }
}
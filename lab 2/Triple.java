import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Triple {
    public static void main(String[] args)throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");  
        int n=Integer.parseInt(s[0]);
        int sum=Integer.parseInt(s[1]);
        String[] inp=br.readLine().split(" ");
        int [] arr=new int [n];
        int [][]arr2=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(inp[i]);
            arr2[i][0]= arr[i];
            arr2[i][1]=i+1;
        }

        for(int i=0;i<n-1;i++){
            int minIdx=i;
            for(int j=i+1;j<n;j++){
                if(arr2[j][0]<arr2[minIdx][0]){
                    minIdx=j;
                }
            }
        

        int temp=arr2[i][0];
        int tempIdx=arr2[i][1];
        arr2[i][0]=arr2[minIdx][0];
        arr2[i][1]=arr2[minIdx][1];
        arr2[minIdx][0]=temp;
        arr2[minIdx][1]=tempIdx;
        }

        for(int i=0;i<n-2;i++){
            int val=sum-arr2[i][0];
            int l=i+1;
            int r=n-1;

            while(l<r){
                int total=arr2[l][0]+arr2[r][0];
                if(total==val){
                    System.out.println(arr2[i][1] + " " + arr2[l][1] + " " + arr2[r][1]);
                     return;
                }
                else if(total<val){
                   l++;
                }
                else{
                    r--;
                }
            }
        }
        
        System.out.println(-1);
    }
}

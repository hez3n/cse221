import java.io.*;

public class Inversion {
    public static long count=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String [] inp=br.readLine().split(" ");
        int [] arr=new int[n];
        for(int a=0;a<n;a++){
            arr[a]=Integer.parseInt(inp[a]);
        }
        int [] newArr=mergeSort(arr,0,n-1);

        System.out.println(count);
        for(int i=0;i<n;i++){
           System.out.print(newArr[i]+" ");
        }

        
    }
    public static int []merge(int []A,int[]B){
        
        int i=0; int j=0; int k=0;
        int m=A.length; int n=B.length;
        int []C= new int[m+n];
        while(i<m && j<n){
            if(A[i]<B[j]){
                 C[k++]=A[i++];
                
            }
            else {
                C[k++]=B[j++]; count+=(m-i);
            }
        }
        for(;i<m;i++){
            C[k++]=A[i];
        }
         for(;j<n;j++){
            C[k++]=B[j];
        }
        return C;
        
    }
    
    public static int[] mergeSort(int []arr,int left,int right){
        
        if(left<right){
            int mid=(left+right)/2;
            int []A1=mergeSort(arr ,left,mid);
            int[]A2=mergeSort(arr,mid+1,right);
            int[]A=merge(A1,A2);
            return A;
        }

        else{
            int[]A=new int[1];
            A[0]=arr[left];
            return A;
        }       
    }
    
}

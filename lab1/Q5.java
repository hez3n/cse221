
import java.io.*;
 
public class Q5 {
    public static void main(String[]args)throws IOException{
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(in);
 
        int n=Integer.parseInt(br.readLine());
        String inp=br.readLine();
        String[] arr=inp.split(" ");
        int arr2[]=new int[n];
        for (int j=0;j<n;j++){
          arr2[j]=Integer.parseInt(arr[j]);
        }
       
        long count=mergeSort(arr2);
        
       
        if(count%2==0)
         System.out.println("YES");
        else
          System.out.println("NO");
    }
    public static long mergeSort(int[]arr){
      long invCount=0;
      int len=arr.length;
      if(len<=1) return 0;
 
      int mid=len/2;
      int[] leftarr=new int[mid];
      int []rightarr= new int [len -mid];
 
      int i=0;
      int j=0;
 
      for(;i<len;i++){
          if(i<mid) leftarr[i]=arr[i];
          else{
            rightarr[j]=arr[i];
            j++;
          }
      }
      invCount+=mergeSort(leftarr);
      invCount+=mergeSort(rightarr);
      
      invCount+=merge(leftarr,rightarr,arr);
 
      return invCount;
 
    }
    public static long merge(int []leftarr,int []rightarr,int[]arr){
           int leftsize=leftarr.length;
           int rightsize=rightarr.length;
           
           int i=0;
           int l=0;
           int r=0;
           long invCount=0;
 
           while(l<leftsize && r< rightsize){
              if(leftarr[l]<=rightarr[r]){
                arr[i]=leftarr[l];
                i++;
                l++;
              }
              else{
                arr[i]=rightarr[r];
                i++;
                r++;
                invCount+=(leftsize-l);
              }
           }
           while(l<leftsize){
            arr[i]=leftarr[l];
            i++;
            l++;
           }
           while(r<rightsize){
            arr[i]=rightarr[r];
            i++;
            r++;
           }
           return invCount;
    }
}


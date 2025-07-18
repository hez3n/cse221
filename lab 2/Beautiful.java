

import java.io.*;
public class Beautiful {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n1=Integer.parseInt(br.readLine());
        String[] inp=br.readLine().split(" ");
        int [] arr1=new int [n1];
        for(int i=0;i<n1;i++){
            arr1[i]=Integer.parseInt(inp[i]);
        }
        int n2=Integer.parseInt(br.readLine());
        String[] inp2=br.readLine().split(" ");
        int [] arr2=new int [n2];
        for(int i=0;i<n2;i++){
            arr2[i]=Integer.parseInt(inp2[i]);
        }
        
        int []arr3=new int [n1+n2];
        
        int i=0;
        int j=0;
        int idx=0;

        while(i<n1 && j<n2){
          if(arr1[i]<arr2[j]){
            arr3[idx]=arr1[i];
            i++; idx++;
          }
          else if(arr2[j]<arr1[i]){
               arr3[idx]=arr2[j];
               j++; idx++;
          }
          else{
            arr3[idx]=arr1[i]; idx++; i++;
            arr3[idx]=arr2[j]; idx++; j++;
            
          }
        }
        while(i<n1){
            arr3[idx++]=arr1[i++];
        }
        while(j<n2){
            arr3[idx++]=arr2[j++];
        }
        
        StringBuilder sb=new StringBuilder();
        for(int m=0;m<idx;m++){
            sb.append(arr3[m]).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}

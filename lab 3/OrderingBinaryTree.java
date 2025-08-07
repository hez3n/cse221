import java.io.*;
import java.util.StringTokenizer;

public class OrderingBinaryTree {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int len=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        long[] sortedArray = new long[len];
        for (int i =0;i<len;i++) {
            sortedArray[i]=Long.parseLong(st.nextToken());
        }
        long[] preorderResult = preorderTraversal(sortedArray);
        for (long number : preorderResult) {
            sb.append(number).append(" ");
        }
        System.out.print(sb.toString().trim());
    }
    
    static long[] preorderTraversal(long[] sorted) {
        long[] preordered= new long[sorted.length];
        int[] curr={0}; 
        binTreeBuilder(0, sorted.length-1,sorted,preordered,curr);
        return preordered;
    }
    
    static void binTreeBuilder(int left,int right,long[] sorted,long[]preordered,int[]curr) {
        if (left>right) return;
        
        int mid =left+(right-left)/2;
        preordered[curr[0]++] = sorted[mid];
        
        binTreeBuilder(left,mid-1,sorted,preordered,curr);
        binTreeBuilder(mid+1,right,sorted,preordered,curr);
    }
}
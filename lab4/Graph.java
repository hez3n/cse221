import java.io.*;
public class Graph {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] inp=br.readLine().split(" ");

        int n= Integer.parseInt(inp[0]);
        int [][] arr= new int[n][n];
        for (int i=0;i<n;i++){

            String [] data= br.readLine().split(" ");
            for(int k=1;k<=Integer.parseInt(data[0]);k++){
               int j=Integer.parseInt(data[k]);
               arr[i][j]=1;
            }
        }
        for (int i=0;i<n;i++) {
         for (int j=0;j<n;j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}

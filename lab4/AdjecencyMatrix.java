import java.io.*;

public class AdjecencyMatrix {
  public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String [] inp=br.readLine().split(" ");

      int n=Integer.parseInt(inp[0]);
      int edgeNum=Integer.parseInt(inp[1]);
      int [][] arr= new int [n][n];
     for (int k=0;k<edgeNum;k++){
      String [] edge=br.readLine().split(" ");

      int s=Integer.parseInt(edge[0])-1;
      int d=Integer.parseInt(edge[1])-1;
      int w=Integer.parseInt(edge[2]);
      arr[s][d]=w;
     }
    for (int i=0;i<n;i++) {
         for (int j=0;j<n;j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
  }
}
import java.io.*;
public class Q3 {
    public static void main(String[]args) throws IOException{
    InputStreamReader in=new InputStreamReader(System.in);
    BufferedReader br=new BufferedReader(in);
    
    int count=Integer.parseInt(br.readLine());
    for(int i=0;i<count;i++){
     long n=Long.parseLong(br.readLine());
     System.out.println((n*(n+1))/2);
    }
    }

}

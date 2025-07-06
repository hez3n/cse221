import java.io.*;
public class Q4 {
    public static void main(String[]args) throws IOException{
    InputStreamReader in=new InputStreamReader(System.in);
    BufferedReader br=new BufferedReader(in);

    int count =Integer.parseInt(br.readLine());
    
    for(int i=0;i<count;i++){
        int len=Integer.parseInt(br.readLine());
        String a=br.readLine();
        String[] arr=a.split(" ");
        String ans="YES";
        for (int j=0;j<len-1;j++){
          if(Integer.parseInt(arr[j])>Integer.parseInt(arr[j+1])){
                  ans="NO";
                  break;
          }
        }
        System.out.println(ans);
    }
    
}
}

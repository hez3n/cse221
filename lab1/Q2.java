
import java.io.*;


public class Q2 {
    public static void main(String []args) throws IOException{
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader br =new BufferedReader(in);
        int count=Integer.parseInt(br.readLine());
        int i=0;
        while(i<count ){
        String text=br.readLine();
        
        String[] smp=text.split(" ");
        if(smp[2].equals("+")){
            System.out.printf("%.6f%n",(float)Integer.parseInt(smp[1])+Integer.parseInt(smp[3]));
        }
        else if(smp[2].equals("-")){
            System.out.printf("%.6f%n",(float)Integer.parseInt(smp[1])-Integer.parseInt(smp[3]));
        }
        else if(smp[2].equals("*")){
            System.out.printf("%.6f%n",(float)Integer.parseInt(smp[1])*Integer.parseInt(smp[3]));
        }
        else if(smp[2].equals("/")){
            System.out.printf("%.6f%n",(float)Integer.parseInt(smp[1])/Integer.parseInt(smp[3]));
        }
        i++;
    }
    br.close();
    }
}

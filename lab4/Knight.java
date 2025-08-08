import java.io.*;
import java.util.*;
public class Knight {
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String [] inp=br.readLine().split(" ");
         int row=Integer.parseInt(inp[0]);
         int col=Integer.parseInt(inp[1]);
         int knight=Integer.parseInt(inp[2]);

         HashSet<String> pos =new HashSet<>();
         
         int [] xdif={2,2,-2,-2,1,1,-1,-1};
         int [] ydif={1,-1,1,-1,2,-2,2,-2}; //board movements

         for (int i = 0; i < knight; i++) {
            String[] parts = br.readLine().split(" ");
            int x= Integer.parseInt(parts[0]);
            int y= Integer.parseInt(parts[1]); //adding all default positions
            pos.add(x +" "+ y);
        }


         for(String temp_pos : pos){ //check if posible movement matches any default positions
            String[] inp2= temp_pos.split(" ");

            int xpos = Integer.parseInt(inp2[0]);
            int ypos = Integer.parseInt(inp2[1]);
            
            for(int i=0;i<8;i++){
                 int newX=xpos+xdif[i];
                 int newY=ypos+ydif[i];

                 String newPos=newX+ " "+ newY;
                 if(pos.contains(newPos)){
                    System.out.println("YES");
                    return;
                 }
            }
         }

         System.out.println("NO");
         
    }
}

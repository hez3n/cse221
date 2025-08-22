
import java.io.*;
import java.util.*;

public class Knight {
    public static void main(String[] args)throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int N = Integer.parseInt(br.readLine());

         String [] inp=br.readLine().split(" ");
        int x1 = Integer.parseInt(inp[0]);
        int y1 = Integer.parseInt(inp[1]);
        int x2 = Integer.parseInt(inp[2]);
        int y2 = Integer.parseInt(inp[3]);
        int[] dx = {+2,+2,-2,-2,+1,+1,-1,-1};
        int[] dy = {+1,-1,+1,-1,+2,-2,+2,-2};

        if(x1==x2 && y1==y2){
            System.out.println(0);
            return;
        }

        int[][] board = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) Arrays.fill(board[i], -1);

        Queue<int []>q=new ArrayDeque<>();
        q.add(new int[]{x1, y1});
        board[x1][y1] = 0;

        int ans=-1;
        while(!q.isEmpty()){
            int[]curr=q.poll();
            int x = curr[0], y = curr[1];
            int d=board[x][y];              //board position

            for(int k=0;k<8;k++){    //8 positions
                int nx= x+dx[k], ny= y + dy[k];
                if (nx >= 1 && nx <= N && ny >= 1 && ny <= N && board[nx][ny] == -1){
                    board[nx][ny] = d + 1;
                    if(nx==x2&& ny==y2){
                        ans = board[nx][ny];
                        q.clear();
                        break;
                    }
                    q.add(new int[]{nx, ny});
                }
            }
        }
        System.out.println(ans);

    }
}

import java.io.*;
import java.util.*;

public class PreOrderTree{
    static class Node{
        Node l,r;
        int val;
        Node(int val){this.val=val;}
    }

    static int pi;
    static Map<Integer,Integer> mp=new HashMap<>();
    
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        pi=n-1;
        int[] post=new int[n];
        int[] in=new int[n];
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            in[i]=Integer.parseInt(st.nextToken());
            mp.put(in[i],i);
        }
        
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            post[i]=Integer.parseInt(st.nextToken());
        }
        
        Node root=build(in,post,0,n-1);
        StringBuilder sb=new StringBuilder();
        pre(root,sb);
        System.out.println(sb.toString().trim());
    }

    static Node build(int[] in,int[] post,int s,int e){
        if(s>e)return null;
        int v=post[pi--];
        Node root=new Node(v);
        int idx=mp.get(v);

        root.r=build(in,post,idx+1,e);
        root.l=build(in,post,s,idx-1);

        return root;
    }

    static void pre(Node root,StringBuilder sb){
        if(root==null)return;
        sb.append(root.val).append(" ");
        pre(root.l,sb);
        pre(root.r,sb);
    }
}
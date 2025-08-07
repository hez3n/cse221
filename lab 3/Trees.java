import java.io.*;
import java.util.*;

public class  Trees{
    static class Node {
        Node leftChild, rightChild;
        int elem;
        Node(int elem) {
            this.elem=elem;
        }
    }
    
    static int currentPreIndex=0;
    static int[] inorderPos;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count=Integer.parseInt(br.readLine());
        int[]inorder = new int[count];
        int[]preorder = new int[count];
        inorderPos = new int[100001];
        Arrays.fill(inorderPos, -1);
        StringTokenizer st= new StringTokenizer(br.readLine());
        for (int i=0;i<count;i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            inorderPos[inorder[i]]= i;
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<count; i++) {
            preorder[i] = Integer.parseInt(st.nextToken());
        }
        
        Node rootNode = constructTree(inorder,preorder,0,count-1);
        StringBuilder result = new StringBuilder();
        traversePost(rootNode, result);
        System.out.println(result.toString().trim());
    }

    
    static Node constructTree(int[] inOrder,int[]preOrder,int leftBound,int rightBound) {
        if (leftBound > rightBound) return null;
        
        int nodeValue = preOrder[currentPreIndex++];
        Node currentNode = new Node(nodeValue);
        int nodePosition = inorderPos[nodeValue];
        
        currentNode.leftChild = constructTree(inOrder,preOrder,leftBound, nodePosition-1);
        currentNode.rightChild = constructTree(inOrder,preOrder,nodePosition+1,rightBound);
        
        return currentNode;
    }
    
    static void traversePost(Node node, StringBuilder output) {
        if (node == null) return;

        traversePost(node.leftChild, output);
        traversePost(node.rightChild, output);
        output.append(node.elem).append(" ");
    }
}
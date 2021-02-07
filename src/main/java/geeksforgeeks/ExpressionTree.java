package main.java.geeksforgeeks;

// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    String data;
    Node left, right;
    Node(String d) {
        data = d;
        left = null;
        right = null;
    }
}

public class ExpressionTree {
    static Node root;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String[] s = new String[n];
            for (int i = 0; i < n; i++) s[i] = sc.next();
            GfG g = new GfG();

            root = null;
            makeTree(s, n);
            System.out.println(g.evalTree(root));
        }
    }

    public static boolean isExpression(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
            return true;
        return false;
    }
    public static void makeTree(String[] s, int n) {
        int p = 0;
        root = new Node(s[p++]);
        Queue<Node> qq = new LinkedList<Node>();
        qq.add(root);
        while (!qq.isEmpty()) {
            Node f = qq.poll();
            Node l = null, r = null;
            if (isExpression(f.data)) {
                l = new Node(s[p++]);
                r = new Node(s[p++]);
                f.left = l;
                f.right = r;
                qq.add(l);
                qq.add(r);
            }
        }
    }
}
// } Driver Code Ends


/* A Tree node is defined as
class Node
{
    String data;
    Node left,right;

    Node(String data)
     {
     this.data = data;
     this.left = null;
     this.right = null;
     }


SampleInput -
1
7
+ * - 5 4 100 20


}*/

class GfG {
    Set<String> set= new HashSet<>();
    public int evalTree(Node root) {
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        while(root!=null){
            inorderCalculate(root);
            if(root.left==null && root.right==null)
                return Integer.parseInt(root.data);
        }
        return 0;
    }
    void inorderCalculate(Node root){
        if(root==null)
            return;
        inorderCalculate(root.left);

        if((root.left !=null && root.right!=null) && (!set.contains(root.left.data) && !set.contains(root.right.data))){
            root.data = calculate(root)+"";
            root.left=null;
            root.right=null;
        }

        inorderCalculate(root.right);
    }
    int calculate(Node node){

        if(node.left== null || node.right==null)
            return 0;

        switch(node.data){
            case "+":
                return Integer.parseInt(node.left.data)+Integer.parseInt(node.right.data);
            case "-":
                return Integer.parseInt(node.left.data)-Integer.parseInt(node.right.data);
            case "*":
                return Integer.parseInt(node.left.data)*Integer.parseInt(node.right.data);
            case "/":
                return (int) (Integer.parseInt(node.left.data)/Integer.parseInt(node.right.data));
            default:
                return 0;
        }
    }
}
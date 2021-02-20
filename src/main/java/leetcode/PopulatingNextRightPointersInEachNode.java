package main.java.leetcode;

import java.util.LinkedList;
import java.util.Queue;
/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
You are given a perfect binary tree where all leaves are on the same level, and every parent has two
children. The binary tree has the following definition:

Populate each next pointer to point to its next right node.
If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.

Follow up:

You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.

Example 1:

Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer
to point to its next right node, just like in Figure B. The serialized output is in level order as connected
by the next pointers, with '#' signifying the end of each level.

Constraints:

The number of nodes in the given tree is less than 4096.
-1000 <= node.val <= 1000
*/

class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if(root==null || root.left==null)
            return root;
        Queue<Node> queue= new LinkedList<>();
        queue.add(root);
        queue.add(null);

        Node prev= null;
        while(!queue.isEmpty()){
            Node temp= queue.remove();

            if(temp==null){
                if(queue.peek()== null){
                    return root;
                }
                prev.next=null;
                queue.add(null);
                prev= null;
                continue;
            }
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
            if(prev!=null)
                prev.next=temp;
            prev= temp;
        }
        return root;
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
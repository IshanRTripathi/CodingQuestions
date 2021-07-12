package main.java.otherCodingQuestions;


public class MyBinarySearchTree {
    Node root;

    public MyBinarySearchTree() {
    }

    void insert(int key, String name) {
        this.root = this.insertKey(this.root, key, name);
    }

    Node insertKey(Node root, int key, String name) {
        Node temp= new Node(key, name);
        if (root == null) {
            root = temp;
        } else {
            if (temp.compareTo(root) < 0) {
                root.left = this.insertKey(root.left, key, name);
            } else if (temp.compareTo(root) >= 0) {
                root.right = this.insertKey(root.right, key, name);
            }
        }
        return root;
    }

    void inorder() {
        this.inorderKey(this.root);
    }

    void inorderKey(Node root) {
        if (root != null) {
            this.inorderKey(root.left);
            System.out.print(root.name + "  ");
            this.inorderKey(root.right);
        }

    }

    public static void main(String[] args) {
        MyBinarySearchTree tree = new MyBinarySearchTree();
        tree.insert(50, "ishanrtripathi");
        tree.insert(90, "ayushtrip");
        tree.insert(70, "rishumish");
        tree.insert(20, "yishumishra");
        tree.insert(10, "devparamtrip");
        tree.insert(30, "prachitripath");
        tree.insert(120, "amanga");
        tree.insert(40, "anuj");
        tree.inorder();
    }

    static class Node implements Comparable<Node>{
        String name;
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
        public Node(int key, String name) {
            this.key = key;
            this.name= name;
        }

        @Override
        public int compareTo(Node node){
            if(this.name.length()>node.name.length())
                return 1;
            else if(this.name.length()<node.name.length())
                return -1;
            return 0;
        }
    }
}

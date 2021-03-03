package main.java.otherCodingQuestions;

/*
As we are all too tired from solving other problems, we'll skip the story and move
straight to the question instead.

You are given a tree with N nodes numbered from 1 to N and it is rooted at node 1.
There's a value associated with each node, which is given in an array A.
You are required to handle Q events, each of which will be either of the following two types:

1 u x: Update the value of node u to x.
2 u: Consider the set of values associated with all nodes v such that u lies on the path from v to the
root. Print the maximum value from this set of values.
Input:

First line will contain T, the number of test cases. The description of each testcase follows.
First line of each testcase contains two space separated integers, N and Q, denoting the number of nodes
and the number of events respectively.
Second line contains N space-separated values A1,A2,A3…AN , with Ai denoting the value associated with
node i.
Next N−1 lines each contain two integers u and v which denotes that there's an edge between node u and
node v.
Next Q lines each contain events as specified above.
Output:

For each query of Type 2, print the required maximum value in a new line.

Constraints

1≤T≤4
2≤N≤10^5
1≤Q≤10^5
Each testcase input forms a tree.
|Ai|,|x|≤10^8
1≤u,v≤N
Sub tasks

30% points : N,Q≤1000
70% points : Original constraints.
Sample Input:

1
5 3
6 3 7 4 5
1 2
1 3
2 4
2 5
2 2
1 4 7
2 1

View of tree
        6
       /  \
      3    7
     /  \
    4    5
Sample Output:

5
7
EXPLANATION:

In the first query, the nodes which have node 2 on the path to the root are nodes 2, 4 and 5.
So the set of values is {3,4,5}, among which the maximum value is 5.

The second query updates the value associated with node 4 to 7.

*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TreeSolution {
    static class Node{
        int data;
        Node[] next= {null, null};
        Node prev;

        Node(int v){
            data= v;
            next= null;
            prev= null;
        }

        @Override
        public String toString(){
            if(this.data==-1)
                return "-1";

            return "\nNode : "+this.data+
                    "\nPrev : "+this.prev.data +
                    "\nNext : "+this.next[0]+" & "+this.next[1] +"\n";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t-- >0){
            Map<Integer, Node> map= new HashMap<Integer, Node>();
            int n= sc.nextInt();
            int k= sc.nextInt();
            int a[] =new int[n];
            for(int i=0; i<n; i++){
                a[i]= sc.nextInt();
            }
            Node root = new Node(-1);
            for(int i=0; i<n-1; i++){
            int u= a[sc.nextInt()-1];
            int v= a[sc.nextInt()-1];

            if(!map.containsKey(u)){
                map.put(u, new Node(u));
            }
            if(map.size()==1){
                if(root.next[0]!= null)
                    root.next[1]= map.get(u);
                else
                    root.next[0]= map.get(u);
                map.get(u).prev= root;
            }
            if(!map.containsKey(v)){
                map.put(v, new Node(v));
            }
            if(map.get(u).next[0]!= null)
                map.get(u).next[1] = map.get(v);
            else
                map.get(u).next[0] = map.get(v);


                if(map.get(v).next[0]!= null)
                    map.get(v).next[1] = map.get(u);
                else
                    map.get(v).next[0] = map.get(u);
            }
            for(Map.Entry<Integer,Node> entry : map.entrySet()){
                System.out.println(entry);//.getKey() + " : "+ entry.getValue());
            }
        }
    }
}

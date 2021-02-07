package main.java.geeksforgeeks;

import java.util.*;

/*
For Input:
2
4 4
0 2 0 3 1 3 2 3
4 3
0 2 0 1 0 3
your output is:
4
3
*/

public class SumOfDependenciesInAGraph {
    public static void main (String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int tc=sc.nextInt();

        while(tc-->0)
        {
            int n=sc.nextInt();
            Map<Integer, List<Integer>> map =new HashMap<>();
            for(int i=0; i<n; i++)
                map.put(i, new ArrayList<>());
            int k= sc.nextInt();

            for(int i=0; i<k; i++){
                int src= sc.nextInt();
                int dest= sc.nextInt();
                map.get(src).add(dest);
            }
            int sum=0;
            for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
                sum+= entry.getValue().size();
            }
            System.out.println(sum);
        }
    }
}

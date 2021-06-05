package main.java.geeksforgeeks;

import java.io.*;
import java.util.*;
import main.java.customClass.Pair;

/*
Link - https://practice.geeksforgeeks.org/problems/269f61832b146dd5e6d89b4ca18cbd2a2654ebbe/1/
Input-
1
3 5
2 1 0 2 1
1 0 1 2 1
1 0 0 2 1

Output -
2

*/
class CovidSpread
{
    public static void main(String[] args)throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        while(t-- > 0)
        {


            int R = sc.nextInt();

            int C = sc.nextInt();



            int hospital[][] = new int[R][C];

            int cnt=0;
            for(int i = 0; i < R; i++)
            {
                for(int j=0; j < C; j++)
                {
                    hospital[i][j] = sc.nextInt();
                }

            }

            Solution ob = new Solution();
            System.out.println(ob.helpaterp(hospital));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int helpaterp(int[][] bed) {
        int time=0;

        Set<Pair> infected= new HashSet<>();
        Set<Pair> fresh= new HashSet<>();

        for(int i=0; i<bed.length; i++){
            for(int j=0; j<bed[i].length; j++){
                if(bed[i][j]==1)
                    fresh.add(new Pair(i, j));
                else if(bed[i][j]==2)
                    infected.add(new Pair(i, j));
            }
        }
        if(fresh.size()==0 || infected.size()==0)
            return -1;

        Set<Pair> newInfected= new HashSet<>();
        do{
            newInfected= new HashSet<>();
            for(Pair p: infected){
                int x= p.getX();
                int y= p.getY();
                if(fresh.contains(new Pair(x+1, y))){
                    fresh.remove(new Pair(x+1, y));
                    newInfected.add(new Pair(x+1, y));
                }
                if(fresh.contains(new Pair(x-1, y))){
                    fresh.remove(new Pair(x-1, y));
                    newInfected.add(new Pair(x-1, y));
                }
                if(fresh.contains(new Pair(x, y+1))){
                    fresh.remove(new Pair(x, y+1));
                    newInfected.add(new Pair(x, y+1));

                }
                if(fresh.contains(new Pair(x, y-1))){
                    fresh.remove(new Pair(x, y-1));
                    newInfected.add(new Pair(x, y-1));}
            }
            if(time==0 && newInfected.size()==0)
                return -1;
            infected.addAll(newInfected);
            time++;
        }while(newInfected.size()>0);

        if(fresh.size()!=0)
            return -1;

        return time-1;
    }
}

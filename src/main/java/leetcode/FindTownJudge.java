package main.java.leetcode;

import java.util.Scanner;

/*

https://leetcode.com/problems/find-the-town-judge/
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

Input and output-
4
1 3
1 4
2 3
2 4
4 3
^D
1 trusts 2 people
	Trusted by 0 people
2 trusts 2 people
	Trusted by 0 people
3 trusts 0 people
	Trusted by 3 people
4 trusts 1 people
	Trusted by 2 people
3

Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3


Constraints:

1 <= N <= 1000
0 <= trust.length <= 10^4
trust[i].length == 2
trust[i] are all different
trust[i][0] != trust[i][1]
1 <= trust[i][0], trust[i][1] <= N*/
public class FindTownJudge {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        System.out.println("Press CTRL+D when done with the input");
        int[][] trust= new int[n+1][2];
        int i=0;
        while(sc.hasNext()){
            trust[i][0]= sc.nextInt();
            trust[i][1]= sc.nextInt();
            i++;
        }
        System.out.println(new FindTownJudge().findJudge(n, trust));
    }
    public int findJudge(int n, int[][] trust) {

        int[] out= new int[n+1];
        int[] in= new int[n+1];

        for(int i=0; i<trust.length; i++){
            out[trust[i][0]]++;
            in[trust[i][1]]++;
        }
        for(int i=1; i<=n; i++){
            System.out.println(i+ " trusts "+ out[i]+" people\n\tTrusted by "+in[i]+" people");
        }
        for(int i=1; i<=n; i++){
            if(out[i]==0 && in[i]==n-1)// && map[map[i]]==n)
                return i;
        }
        return -1;
    }
}

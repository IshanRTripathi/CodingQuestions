package main.java.leetcode;
/*
Link : https://leetcode.com/problems/process-tasks-using-servers/

Problem Description: 
1882. Process Tasks Using Servers
Medium

You are given two 0-indexed integer arrays servers and tasks of lengths n and m respectively. servers[i] is the weight
of the i server, and tasks[j] is the time needed to process the
jth task in seconds.

You are running a simulation system that will shut down after all tasks are processed. Each server can only process
one task at a time. You will be able to process the jth task starting from the jth second beginning with the 0th
task at second 0. To process task j, you assign it to the server with the smallest weight that is free, and in case
of a tie, choose the server with the smallest index. If a free server gets assigned task j at second t, it will
be free again at the second t + tasks[j].

If there are no free servers, you must wait until one is free and execute the free tasks as soon as possible. If multiple
tasks need to be assigned, assign them in order of increasing index.

You may assign multiple tasks at the same second if there are multiple free servers.

Build an array ans of length m, where ans[j] is the index of the server the jth task will be assigned to.

Return the array ans.



Example 1:

Input: servers = [3,3,2], tasks = [1,2,3,2,1,2]
Output: [2,2,0,2,1,2]
Explanation: Events in chronological order go as follows:
- At second 0, task 0 is added and processed using server 2 until second 1.
- At second 1, server 2 becomes free. Task 1 is added and processed using server 2 until second 3.
- At second 2, task 2 is added and processed using server 0 until second 5.
- At second 3, server 2 becomes free. Task 3 is added and processed using server 2 until second 5.
- At second 4, task 4 is added and processed using server 1 until second 5.
- At second 5, all servers become free. Task 5 is added and processed using server 2 until second 7.
Example 2:

Input: servers = [5,1,4,3,2], tasks = [2,1,2,4,5,2,1]
Output: [1,4,1,4,1,3,2]
Explanation: Events in chronological order go as follows:
- At second 0, task 0 is added and processed using server 1 until second 2.
- At second 1, task 1 is added and processed using server 4 until second 2.
- At second 2, servers 1 and 4 become free. Task 2 is added and processed using server 1 until second 4.
- At second 3, task 3 is added and processed using server 4 until second 7.
- At second 4, server 1 becomes free. Task 4 is added and processed using server 1 until second 9.
- At second 5, task 5 is added and processed using server 3 until second 7.
- At second 6, task 6 is added and processed using server 2 until second 7.


Constraints:

servers.length == n
tasks.length == m
1 <= n, m <= 2 * 105
1 <= servers[i], tasks[j] <= 2 * 105
*/

import java.util.*;

public class ProcessTasksUsingServers {
    public static void main(String[] args) {
        ProcessTasksUsingServers ProcessTasksUsingServersObject = new ProcessTasksUsingServers();
        int[] servers = {3,3,2};
        int[] tasks = {1,2,3,2,1,2};
        var result = ProcessTasksUsingServersObject.assignTasks(servers, tasks);
        System.out.println(Arrays.toString(result));
    }
    public int[] assignTasks(int[] servers, int[] tasks) {

        int[] res= new int[tasks.length];
        PriorityQueue<ServerInfo> pq= new PriorityQueue<>((p1, p2) -> {
            if (p1.getValue() == p2.getValue()) {
                return p1.getKey() - p2.getKey();
            }
            return p1.getValue() - p2.getValue();
        });
        for(int i=0; i<servers.length; i++){
            pq.add(new ServerInfo(i, servers[i]));
        }
        System.out.println(pq);

        List<ServerInfo> list= new ArrayList<>();
        for(int i=0; i<tasks.length; i++){
            ServerInfo server= null;
            int time= 0; //server.getnextfree()+tasks[i];
            //System.out.println("===========================");
            while(true || pq.size()>0){
                ServerInfo temp= pq.remove();
                System.out.println("Checking server :"+temp);
                list.add(temp);
                if(temp.getnextfree()>i){
                    System.out.println("Server: "+temp.getKey()+" is busy");
                    continue;
                }
                else{
                    System.out.println("Server: "+temp.getKey()+" is available");
                    server= temp;
                    break;
                }
            }
            if(list.size()>0){
                //System.out.println("Before adding all"+ pq);
                pq.addAll(list);
                //System.out.println("After adding all"+ pq);
                list= new ArrayList<>();
            }
            System.out.println("Starting task "+i+" at time "+i);
            server.setnextfree(i+tasks[i]);
            System.out.println("Server: "+server.getKey()+" will be next free at: "+server.getnextfree());
            //System.out.println("New server config: "+server);
            res[i]= server.getKey();
        }
        return res;
    }
}
class ServerInfo{
    int key, value, nextfree;

    ServerInfo(int key, int value){
        this.key= key;
        this.value= value;
        nextfree=0;
    }

    int getKey(){ return key; }
    int getValue(){ return value; }
    void setnextfree(int t){ this.nextfree= t; }
    int getnextfree(){ return nextfree; }

    @Override
    public String toString(){
        return "{sever: "+key+", weight: "+value+", nextfree: "+nextfree+"}\n";
    }
}

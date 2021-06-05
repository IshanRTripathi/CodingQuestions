package leetcode;

import main.java.leetcode.ProcessTasksUsingServers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ProcessTasksUsingServersTest {

    @Test
    public void testSample1(){
        ProcessTasksUsingServers obj= new ProcessTasksUsingServers();
        int[] servers = {3,3,2};
        int[] tasks = {1,2,3,2,1,2};

        int[] expected= obj.assignTasks(servers, tasks);
        int[] actual= {2, 2, 0, 2, 1, 2};
        System.out.println(Arrays.toString(expected));
        assert(Arrays.equals(expected, actual));
    }

    @Test
    public void testSample2(){
        ProcessTasksUsingServers obj= new ProcessTasksUsingServers();
        int[] servers = {10,63,95,16,85,57,83,95,6,29,71};
        int[] tasks = {70,31,83,15,32,67,98,65,56,48,38,90,5}   ;

        int[] expected= obj.assignTasks(servers, tasks);
        int[] actual= {8,0,3,9,5,1,10,6,4,2,7,9,0};

        assert(Arrays.equals(expected, actual));
    }
}

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

        assert(Arrays.equals(expected, actual));
    }
}

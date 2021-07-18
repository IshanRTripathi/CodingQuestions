package main.selfLearning.interviewScheduler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class InterviewService {
    public static void main(String[] args) {
        BlockingQueue queue= new ArrayBlockingQueue(3);

        InterviewProcessor processor= new InterviewProcessor(queue);
        InterviewScheduler scheduler= new InterviewScheduler(queue);

        Thread p= new Thread(processor);
        Thread s= new Thread(scheduler);

        p.setPriority(10);
        p.start();
        s.start();
    }
}

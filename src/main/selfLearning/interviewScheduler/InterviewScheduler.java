package main.selfLearning.interviewScheduler;

import java.util.concurrent.BlockingQueue;

public class InterviewScheduler implements Runnable{

    private BlockingQueue<String> queue;

    public InterviewScheduler(BlockingQueue<String> queue){
        this.queue= queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int) (Math.random()*10000));
            while(!this.queue.isEmpty()){
                System.out.println(queue.take()+"'s interview completed !");
                Thread.sleep((int) (Math.random()*10000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

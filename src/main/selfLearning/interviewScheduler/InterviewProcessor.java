package main.selfLearning.interviewScheduler;

import java.util.concurrent.BlockingQueue;

public class InterviewProcessor implements Runnable{

    private BlockingQueue<String> queue;

    public InterviewProcessor(BlockingQueue<String> queue){
        this.queue= queue;
    }

    @Override
    public void run() {
        System.out.println("Starting interview for 10 candidates");
        for(int i=0; i<10; i++){
            String candidateName= "Candidate_"+i;
            try {
                queue.put(candidateName);
                System.out.println(candidateName+"'s interview scheduled !");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

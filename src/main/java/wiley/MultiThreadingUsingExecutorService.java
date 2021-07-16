package main.java.wiley;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadingUsingExecutorService {
    static int i;
    public static void main(String[] args) {

        CustomThread customThread= new CustomThread();

        ExecutorService service= Executors.newFixedThreadPool(5);
        for(int i=0; i<5; i++){
            service.execute(customThread);
        }
        service.shutdown();
    }
}

class CustomThread implements Runnable{

//    static int i;
    @Override
    public void run() {
        for (int itr= 0; itr< 10; itr++)
            System.out.println(Thread.currentThread().getName()+" - "+itr);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

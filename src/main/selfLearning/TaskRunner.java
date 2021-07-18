package main.selfLearning;

public class TaskRunner {

    private static int number;
    private static boolean ready;

    private static class Reader extends Thread {

        @Override
        public void run() {
            while (!ready) {
//                System.out.println("Not yet ready!");
                number++;
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new Reader().start();
        number = 42;

//        for (int i=0; i<100_000; i++){
//            System.out.print("");
//        }

        ready = true;
    }
}
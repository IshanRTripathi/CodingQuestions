package main.selfLearning;

public class QueueImplementation {
    public static void main(String[] args) {
        runTest1();
        runTest2();
    }

    private static void runTest2() {
        FIFOQueue queue= new FIFOQueue();
        /*
        Test Case 2:
        Enque(1);
        Enque(2);
        Enque(3);
        System.out.println(Deque());
        System.out.println(Deque());
        Enque(1);
        Enque(2);
         */
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(1);
        queue.enqueue(2);
    }

    private static void runTest1() {
        FIFOQueue queue= new FIFOQueue();
        /*
        Test Case 1:
        Enque(1);
        Enque(2);
        Enque(3);
        System.out.println(Deque());
        System.out.println(Deque());
        System.out.println(Deque());
        Enque(1);
        System.out.println(Deque());
        */
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.enqueue(1);
        System.out.println(queue.dequeue());
    }
}

package main.selfLearning;

/*
Implement a FIFO queue which uses an integer array (not List/ArrayList) to store elements and has enque,
 deque methods. Deque should return the dequeued number in a FIFO manner.

Queue test cases:
Set Max Queue Size=3
Test Case 1:
Enque(1);
Enque(2);
Enque(3);
System.out.println(Deque());
System.out.println(Deque());
System.out.println(Deque());
Enque(1);
System.out.println(Deque());

Test Case 2:
Enque(1);
Enque(2);
Enque(3);
System.out.println(Deque());
System.out.println(Deque());
Enque(1);
Enque(2);
*/

public class FIFOQueue {
    static final int MAX_QUEUE_SIZE= 3;
    private int enqueueIndex;
    private int dequeueIndex;
    private int[] queue;

    FIFOQueue(){
        this.queue= new int[MAX_QUEUE_SIZE];
        enqueueIndex = 0;
        dequeueIndex = 0;
    }

    public void enqueue(int x){
//        try {
//            System.out.println("Adding element: "+x+" at index: "+ dequeueIndex);
            dequeueIndex= (dequeueIndex+1+MAX_QUEUE_SIZE)%MAX_QUEUE_SIZE;

            queue[dequeueIndex]= x;

//        } catch (QueueSizeExceededException e){
//            e.printStackTrace();
//        }
    }

    public int dequeue(){
//        try {

//        }
//        catch (QueueEmptyException e){
//            e.printStackTrace();
//        }
//        System.out.println("Removing element: "+queue[currentQueueSize]+" at index: "+currentQueueSize);
        enqueueIndex= (enqueueIndex+1)%MAX_QUEUE_SIZE;
        return queue[enqueueIndex];
    }

}

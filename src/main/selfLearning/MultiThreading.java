package main.selfLearning;

/*
Learnings:
1. if using synchronized block in overridden run method, pass your class's name instead of this because
    under the run method, this would point to the Thread class.

Note: if x is incremented in run, then answer depends if run is synchronized or not
Similarly, if x is incremented in test, then answer would depend if at least test or run is synchronized or not

Considering x is incremented in run method
2. run is synchronized and test is synchronised, output 1 to 11
3. run is synchronized and test isn't synchronised, output 1 to 11
4. run isn't synchronized and test is synchronised, output random
5. run isn't synchronized and test isn't synchronised, output random

Static variable is a shared resource, which can be used to exchange some information among different
threads. And we need to be careful while accessing such a shared resource. Hence, we need to make
sure that the access to static variables in multi-threaded environment is synchronized.
Each thread has its own stack but they share the process heap.

* */

class MultiThreading extends Thread{

    /*
    Stack holds only the local variables and not the variables on the heap.
    Static variables are stored in the PermGen section of the heap
    so if x is not static, each thread's stack will have it's own x=1
    when x is static, x will be stored in heap section of the program (i.e process)
    hence the value of x will be commonly used & modified by any thread */

    static int x=1;

    @Override
    public void run(){
//        synchronized (MultiThreading.class) {
//            System.out.println(this.getId() + " -- " + (x++));

//            synchronized (MultiThreading.class) {
                test();
//            }
//        }
    }

    public void test(){
        synchronized (MultiThreading.class){
            x++;
            System.out.println(x+" ");
        }
    }

    public static void main(String[] args) {
        for (int i=0; i<100; i++){
            MultiThreading obj= new MultiThreading();
            obj.setPriority((int)((Math.random()*100)%10)+1); //  this wont matter because of synchronized keyword use
            obj.start();
        }
    }
}
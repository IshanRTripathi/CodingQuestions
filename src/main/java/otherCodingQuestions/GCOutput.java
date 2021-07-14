package main.java.otherCodingQuestions;

public class GCOutput {
    static GCOutput gcOutput;
    static int count=0;

    public static void main(String[] args) throws InterruptedException {
        GCOutput g1= new GCOutput();
        g1= null;
        System.gc();
        Thread.sleep(1000);
        gcOutput=null;
        System.gc();
        Thread.sleep(1000);
        System.out.println("Finalize"+count);
    }

    @Override
    protected void finalize(){
        count++;
        gcOutput= this;
    }
}

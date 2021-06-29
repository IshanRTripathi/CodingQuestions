package main.java.otherCodingQuestions;

//print 1 to n
public class Print1ton {
    public static void main(String[] args) {
        new Print1ton().print(10);
    }

    private void print(int i) {
        if(i==0)
            return;
        print(i-1);
        System.out.println(i);
    }
}

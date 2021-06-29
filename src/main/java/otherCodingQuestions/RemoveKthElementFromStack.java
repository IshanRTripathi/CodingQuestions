package main.java.otherCodingQuestions;

import java.util.Arrays;
import java.util.Stack;

public class RemoveKthElementFromStack {
    public static void main(String[] args) {
        Stack<Integer> stack= new Stack<>(){{
                    push(1);
                    push(2);
                    push(4);
                    push(3);
                    push(7);
                    push(1);
                    push(99);
        }};
        int k= 3;
        System.out.println("Stack: "+stack+"\nk= "+k);
        new RemoveKthElementFromStack().removeKth(stack, k);
    }

    private void removeKth(Stack<Integer> stack, int k) {
        if(k==1){
            System.out.println("Removed: "+stack.pop());
            return;
        }
        int temp= stack.pop();
        removeKth(stack, k-1);
        stack.push(temp);
    }
}

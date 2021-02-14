package main.java.chegg;

import java.util.Arrays;

public class StackOfStrings {
    String[] elements;
    int size;

    StackOfStrings(){
        elements = new String[4];
        size=0;
    }

    StackOfStrings(int capacity){
        elements = new String[capacity];
        size=0;
    }

    public boolean empty(){
        return size==0;
    }

    public void push(String value){
        if(size== elements.length){
//            String[] temp= Arrays.copyOf(stack, stack.length);
//            stack= new String[2* size];
//            System.arraycopy(temp, 0, stack,0, temp.length);
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[size++]= value;
    }

    public String pop(){
        if(size==0)
            return "Stack is EMPTY";
        size--;
        return elements[size+1];
    }

    public String peek(){
        return size==0? "EMPTY": elements[size];
    }

    public void printStack(){
        System.out.print("Stack (top to bottom) :");
        for(int i=size-1; i>=0; i--)
            System.out.print(elements[i]+ " ");
        System.out.println();
    }
}

package main.java.wiley;

import java.util.*;

public class ATMDispenser {
    public static void main(String[] args) {
        int amt= 1200; //new Scanner(System.in).nextInt();
        System.out.println("Dispensing "+amt);

        PriorityQueue<Note> atmNotes= new PriorityQueue<>((a, b)->{
            return (b.getValue()*b.getCount()) - (a.getValue()*a.getCount());
        });
        atmNotes.add(new Note(2000, 2));
        atmNotes.add(new Note(500, 4));
        atmNotes.add(new Note(200, 11));
        atmNotes.add(new Note(100, 8));

        int result= dispenseNotes(amt, atmNotes);

    }

    private static int dispenseNotes(int amt, PriorityQueue<Note> atmNotes) {
        List<Note> tempNotes= new ArrayList<>();
        int sumDispensedSoFar=0;
        Map<Integer, Integer> dispensedDimensions= new HashMap<>();
        while(amt>0 && !atmNotes.isEmpty()){
            Note curr= atmNotes.remove();
            if(curr.getCount()==0){
                continue;
            }

            tempNotes.add(new Note(curr.getValue(), curr.getCount()-1));
            if(curr.getValue()<=amt){
                amt-= curr.getValue();
                sumDispensedSoFar+= curr.getValue();
                dispensedDimensions.put(curr.getValue(), dispensedDimensions.getOrDefault(curr.getValue(), 0)+1);
//                System.out.println("Dispensed : "+curr.getValue());
                atmNotes.addAll(tempNotes);
                tempNotes= new ArrayList<>();
            }
        }
        if(amt==0){
            System.out.println(dispensedDimensions);
            return 1;
        }
        System.out.println("Cannot dispense");
        return -1;
    }
}

class Note {
    private int value;
    private int count;

    public Note(int value, int count) {
        this.value = value;
        this.count = count;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
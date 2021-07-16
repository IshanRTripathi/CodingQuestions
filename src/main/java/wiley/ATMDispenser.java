package main.java.wiley;

import java.util.*;

public class ATMDispenser {
    public static void main(String[] args) {
        int amt= 1200; //new Scanner(System.in).nextInt();
        System.out.println("Dispensing "+amt);

        PriorityQueue<Note> atmNotes= new PriorityQueue<>((a, b)->{
            if(a.getTotalWeight()==b.getTotalWeight()){
                return b.getCount()-a.getCount();
            }
            return (b.getTotalWeight()) - (a.getTotalWeight());
        });
        atmNotes.add(new Note(2000, 0));
        atmNotes.add(new Note(500, 4));
        atmNotes.add(new Note(200, 11));
        atmNotes.add(new Note(100, 8));

        int result= dispenseNotes(amt, atmNotes);
        System.out.println(result==1? "Dispensed total amount success": "Unsuccessful");
    }

    public static int dispenseNotes(int amt, PriorityQueue<Note> atmNotes) {
        System.out.println(atmNotes);
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
                System.out.println("Dispensed : "+curr.getValue()+" , remaining: "+amt);
                atmNotes.addAll(tempNotes);
                System.out.println("Updated dimensions: "+atmNotes);
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


package wiley;

import main.java.wiley.ATMDispenser;
import main.java.wiley.Note;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ATMDispenserTest {

    private static PriorityQueue<Note> atmNotes;
    private static int amt;

    @BeforeAll
    static void init(){
        atmNotes= new PriorityQueue<>((a, b)->{
            if(a.getTotalWeight()==b.getTotalWeight()){
                return b.getCount()-a.getCount();
            }
            return (b.getTotalWeight()) - (a.getTotalWeight());
        });
        amt=0;
    }

    @Test
    public void test1(){
        List<Note> list= new ArrayList<>(){{
            add(new Note(2000, 10));
            add(new Note(500, 5));
            add(new Note(200, 5));
            add(new Note(100, 5));
        }};
        atmNotes.addAll(list);

        amt=1300;
        Assertions.assertEquals(ATMDispenser.dispenseNotes(amt, atmNotes), 1);
    }

    @Test
    public void test2(){
        List<Note> list= new ArrayList<>(){{
            add(new Note(2000, 1));
            add(new Note(500, 8));
            add(new Note(200, 15));
            add(new Note(100, 5));
        }};
        atmNotes.addAll(list);

        amt=13500;
        Assertions.assertEquals(ATMDispenser.dispenseNotes(amt, atmNotes), -1);
    }
}

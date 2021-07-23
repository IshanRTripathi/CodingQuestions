package main.java.wiley;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class CheckOverride {
    public static void main(String[] args) {
        List<Integer> list= new ArrayList<Integer>();
        PriorityQueue<Integer> pq= new PriorityQueue<>(Comparator.comparingInt(o -> o));
        pq.add(1);
        pq.add(-1);
        System.out.println(pq);
    }
}

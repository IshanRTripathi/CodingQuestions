package main.java.wiley;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Account {
    static String[] type= {"saving", "current"};
    static Map<String, Double> map= new HashMap<>();

    static void init(){
        map.put("dd", 0.0);
        List<Integer> list= new ArrayList<>(Arrays.asList(1,2,3,4,5));
        list.stream().filter(x-> x%2==0).collect(Collectors.toList()).forEach(System.out::println);
    }

    public static void main(String[] args) {
        init();
    }
}

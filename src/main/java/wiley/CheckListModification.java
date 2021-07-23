package main.java.wiley;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CheckListModification {
    public static void main(String[] args) {
        List<String> list= new ArrayList<>(List.of("Ishan", "aywdsush", "pingss"));
//        for(int i=0; i<list.size(); i++){
//            list.set(i, list.get(i).toUpperCase());
//        }
//        System.out.println(list);

        System.out.println(list.stream().reduce("", (s1, s2) -> s1+s2));


        List<Integer> integers= List.of(1,2,3,4,5,611,221,323,511,11);
        integers.stream().filter(x -> x%2==0).reduce((a,b)-> a*b).ifPresent(System.out::println);
    }
}

package main.selfLearning;

import java.util.*;
import java.util.stream.Collectors;

public class OptionalExample {
    public static void main(String[] args) {
        String input= "Tripathi";
        List<Integer> list= new ArrayList<>(); //Arrays.asList(5,6,7,4,8,4,4,1,8,7);//new ArrayList<>(){{add(5);add(7);add(9);}};
//        Optional<List<Integer>> optional= Optional.of(list);
//        System.out.println(optional);
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        for(int i=0; i<n; i++){
            list.add(sc.nextInt());
        }
        new OptionalExample().fun(list, 4);
    }

    private void fun(List<Integer> list, int i) {
//
//        System.out.println(Optional.of(list));
//        System.out.println(Optional.of(list).stream().map(List::get).filter(x -> x>=7).isPresent());

        Optional<Set<Integer>> opt= Optional.of(list.stream()
                .filter(x -> x>5)
                .map(x -> x*7)
                .collect(Collectors.toSet()));
        System.out.println(opt);


        System.out.println(list.stream()
                .filter(x -> x>5)
                .map(x -> x*7)
                .collect(Collectors.toSet()));

        System.out.println(Optional.ofNullable(list.stream().filter(x-> x>25)).isPresent());

        String[] arr= {"1","2","1","2"};
        System.out.println(Optional.ofNullable(null).orElse(12));

        String str= null;
        Optional<String> stringOptional= Optional.ofNullable(str);
        System.out.println(stringOptional);

        List<String> lstr= null;
        Optional<String> loptional= Optional.ofNullable(str);

    }
}

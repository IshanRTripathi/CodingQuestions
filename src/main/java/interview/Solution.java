package main.java.interview;

/*
List<String> l1 = {"ab", "bc", "ad"}
List<String> l2 = {"ab", "kk", "bc"}
List<String> l3 = {"bc", "kk", "ab"}
Get common elements from the three lists*/

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<String> l1 = List.of("ab", "bc", "ad");
        List<String> l2 = List.of("ab", "kk", "bc");
        List<String> l3 = List.of("bc", "kk", "ab");

        for(String str: l1) {
            if(l2.contains(str) && l3.contains(str)) {
                System.out.println(str);
            }
        }
    }
}

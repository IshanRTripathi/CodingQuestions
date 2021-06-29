package main.java.leetcode;
/*
* link: https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/
*/ 

public class CheckIfWordEqualsSummationOfTwoWords {
    public static void main(String[] args) {
        CheckIfWordEqualsSummationOfTwoWords obj= new CheckIfWordEqualsSummationOfTwoWords();
        System.out.println(obj.isSumEqual("aaa", "a", "aab"));
    }
    public boolean isSumEqual(String f, String s, String t) {
        int ff=0, ss=0, tt=0;
        for(char c: f.toCharArray()){
            ff= (ff*10)+(c-'a');
        }
        for(char c: s.toCharArray()){
            ss= (ss*10)+(c-'a');
        }
        for(char c: t.toCharArray()){
            tt= (tt*10)+(c-'a');
        }

        return (ff+ss == tt);
    }
}

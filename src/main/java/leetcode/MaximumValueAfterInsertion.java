package main.java.leetcode;

public class MaximumValueAfterInsertion {
    public static void main(String[] args) {
        MaximumValueAfterInsertion obj= new MaximumValueAfterInsertion();
        obj.maxValue("-13354", 6);
    }
    public String maxValue(String s, int x) {
        String res="";
        if(s.charAt(0)=='-'){
            res= getMin(s.substring(1, s.length()), x);
        }
        else{
            res= getMax(s,x);
        }
        return res;
    }
    public String getMax(String s, int x){
        if(x==0){
            return s+(x+"");
        }
        int index=s.length();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)-'0'<x)
            {
                index= i;
                break;
            }
        }
        // if(index<0)
        //     index=0;
        return s.substring(0, index)+ (x+"") + s.substring(index, s.length());
    }
    public String getMin(String s, int x){
        if(x==0){
            return s;
        }
        int index=-1;

        //for(int i=s.length()-1; i>=0; i--){
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)-'0'>x)
            {
                index= i;
                break;
            }
        }
        //System.out.println("for "+s +"index: "+index);
        if(index<0)
            index=s.length();
        return "-"+s.substring(0, index)+ (x+"") + s.substring(index, s.length());
    }
}

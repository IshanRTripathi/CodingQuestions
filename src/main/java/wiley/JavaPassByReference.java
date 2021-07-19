package main.java.wiley;

import java.util.ArrayList;
import java.util.List;

public class JavaPassByReference {
    public static void main(String[] args) {
        JavaPassByReference ref= new JavaPassByReference();


        for (int i=0; i<1; i++){
            List<Integer> list= new ArrayList<>();
            System.out.println(list);
            System.out.println(i);

            Integer intObj= Integer.valueOf(11);
            MyInteger x= new MyInteger(intObj);

            ref.callPrint(intObj, list);

            System.out.println(list);
            System.out.println(intObj);
        }
    }

    private void callPrint(Integer x, List<Integer> list) {
        int temp=10;
//        x.modify(x.x+1);
        x++;
        list.add(120);
    }

}


class MyInteger{
    Integer x;

    public MyInteger(int x) {
        this.x= x;
    }

    public void modify(int i) {
        x=i;
    }

    @Override
    public String toString() {
        return x+"";
    }
}

package main.java.wiley;

public class ChildClass extends MyClass{

    public static void main(String[] args) {
        MyClass myClass= new MyClass();
        myClass.setColor("Red");
        myClass.setSize(5);
        System.out.println(myClass);
        System.out.println(myClass.hashCode());
    }
}

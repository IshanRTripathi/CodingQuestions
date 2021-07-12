package main.java.wiley;

public class MyClass extends Object{
    public MyClass() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    String color;
    int size;

    private final int DEFAULT_SIZE= 5;
    private final String DEFAULT_COLOR= "Blue";

    MyClass(String color, int size){
        this.color= color;
        this.size= size;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "color='" + color + '\'' +
                ", size=" + size +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    //    MyClass(String color){
////        this.size= DEFAULT_SIZE;
//        this.color= color;
//    }
}

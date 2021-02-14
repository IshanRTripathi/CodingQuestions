package main.java.leetcode;

class Pair{
    int x, y;
    Pair(int x, int y){
        this.x= x;
        this.y= y;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Pair))
            return false;

        Pair p= (Pair) o;
        return this.x==p.x && this.y==p.y;
    }

    @Override
    public int hashCode(){
        return x*13 + y*41;
    }

    @Override
    public String toString(){
        return "Co-ordinates : ("+x+","+y+")\n";
    }
}

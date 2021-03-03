package main.java.chegg;


public class RandomWalker {
    public static void main(String[] args) {
        int n= Integer.parseInt(args[0]);
        int row=0, column=0;
        while(n-->0){
            int direction= (int) (Math.random()*10%4);

            switch (direction) {
                case 0 -> row++; // Move North
                case 1 -> row--; // Move South
                case 2 -> column++; // Move West
                case 3 -> column--; // Move East
            }
            System.out.println("Particle moved to : ("+row+", "+column+")");
        }
        System.out.println("Squared Euclidean distance: "+ getEuclideanDistance(row, column));
    }

    private static String getEuclideanDistance(int row, int column) {
        return String.valueOf(Math.pow(row, 2)+ Math.pow(column, 2));
    }
}

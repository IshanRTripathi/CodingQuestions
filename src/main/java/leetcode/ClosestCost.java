package main.java.leetcode;

public class ClosestCost {
    public static void main(String[] args) {
        int[] baseCosts= new int[]{2,3};
        int[] toppingCosts= new int[]{4,5,100};
        int target= 18;

        int totalCost= 0;
        for(int base: baseCosts){
            System.out.println("Checking for base: "+base);
            totalCost= base;
            for(int topping: toppingCosts){
                System.out.println("\tTaking 1 topping of size "+topping);
                System.out.println("\tTotalCost: "+(totalCost+topping));
                System.out.println("\tTaking 2 toppings of size "+topping);
                System.out.println("\tTotalCost: "+(totalCost+topping+topping));
            }
        }
    }
}

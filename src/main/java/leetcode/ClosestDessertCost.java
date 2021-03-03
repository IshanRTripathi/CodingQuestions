package main.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ClosestDessertCost {
    int minTarget;
    int targetValue;
    int intermediateTarget;
    public static void main(String[] args) {
        int[] baseCosts= new int[]{4};//{2,3};//{1,7};
        int[] toppingCosts= new int[]{9};//{4,5,100};//{3,4}
        int target=9;
        int closestCost= new ClosestDessertCost().closestCost(baseCosts, toppingCosts, target);

        System.out.println("Closest cost: "+closestCost);
    }

    private int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        if(baseCosts==null || toppingCosts==null || target==0)
            return 0;

        minTarget=0;
        targetValue=0;
        intermediateTarget=0;

        int result=0;
        for(int baseCost: baseCosts){
            Map<Integer, Integer> toppingHash= new HashMap<>();
            for(int toppingCost: toppingCosts)
                toppingHash.put(toppingCost, 0);
            intermediateTarget= target- baseCost;
            System.out.println("intermediateTarget: "+intermediateTarget);
            backtrack(0, toppingCosts, toppingHash, intermediateTarget);
            result= Math.max(baseCost,Math.max(result, targetValue-minTarget));
        }
        return result;
    }

    private void backtrack(int index, int[] toppingCosts, Map<Integer, Integer> toppingHash, int target) {

        if(index == toppingCosts.length){
                //System.out.println("\t"+toppingHash);
                minTarget= Math.min(minTarget, target);
            return;
        }
        if(toppingHash.containsKey(toppingCosts[index]) && toppingHash.get(toppingCosts[index])<2){
            toppingHash.put(toppingCosts[index], toppingHash.getOrDefault(toppingCosts[index], 0)+1);
            backtrack(index, toppingCosts, toppingHash, target- toppingCosts[index]);
            toppingHash.put(toppingCosts[index], toppingHash.get(toppingCosts[index])-1);
        }
        backtrack(index+1, toppingCosts, toppingHash, target);
    }
}

package main.java.wiley;

public class Note {
    private final int value;
    private final int count;
    private final int totalWeight;

    public Note(int value, int count) {
        this.value = value;
        this.count = count;
        this.totalWeight= value*count;
    }

    public int getValue() {
        return value;
    }

    public int getCount() {
        return count;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    @Override
    public String toString() {
        return "\n\tNote{" +
                "value=" + value +
                ", count=" + count +
                ", totalWeight=" + totalWeight +
                '}';
    }
}

package edu.umn.d.cs1632.Features;

import java.util.ArrayList;

public class IntegerFeature extends Feature {
    public ArrayList<Integer> uniqueIntegers;
    public int lowestValue;
    public int highestValue;

    public IntegerFeature(String n) {
        super(n);
        uniqueIntegers = new ArrayList<>();
    }
    //adds new integers to the already established feature and updates the information
    public void addInteger(int num) {
        if (!uniqueIntegers.contains(num)) {
            uniqueIntegers.add(num);
            getLowestAndHighestValue();
        }
    }
    // determines the highest and lowest value based off the set of uniqueIntegers available to look at.
    public void getLowestAndHighestValue() {
        for (int i = 0; i < uniqueIntegers.size(); i++) {
            if (i == 0) {
                lowestValue = uniqueIntegers.get(i);
                highestValue = uniqueIntegers.get(i);
            } else if (lowestValue > uniqueIntegers.get(i)) {
                lowestValue = uniqueIntegers.get(i);
            } else if (highestValue < uniqueIntegers.get(i)) {
                highestValue = uniqueIntegers.get(i);
            }
        }
    }

    public ArrayList<Integer> getUniqueIntegers() {
        return uniqueIntegers;
    }

    public int getLowest() {
        return lowestValue;
    }

    public int getHighest() {
        return highestValue;
    }
}

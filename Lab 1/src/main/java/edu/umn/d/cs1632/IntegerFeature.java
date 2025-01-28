package edu.umn.d.cs1632;

import java.util.ArrayList;

public class IntegerFeature extends Feature {
    public ArrayList<Integer> uniqueValues;
    public int lowestValue;
    public int highestValue;

    public IntegerFeature(String n) {
        super(n);
        //getUniqueValues(data);
        //getLowestAndHighestValue();
    }

    public void getUniqueValues(ArrayList<Integer> data) {
        for (int i = 0; i < data.size(); i++) {
            if(!uniqueValues.contains(data.get(i)))
            {
                uniqueValues.add(data.get(i));
            }
        }
    }

    public void getLowestAndHighestValue() {
        for (int i = 0; i < uniqueValues.size(); i++) {
            if(i == 0)
            {
                lowestValue = uniqueValues.get(i);
                highestValue = uniqueValues.get(i);
            }
            else if (lowestValue > uniqueValues.get(i))
            {
                lowestValue = uniqueValues.get(i);
            }
            else if(highestValue < uniqueValues.get(i))
            {
                highestValue = uniqueValues.get(i);
            }
        }
    }
}

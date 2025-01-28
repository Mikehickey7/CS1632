package edu.umn.d.cs1632;

import java.util.ArrayList;

public class StringFeature extends Feature {
    public int uniqueStringCount = 0;
    public ArrayList<String> uniqueStrings;

    public StringFeature(String n) {
        super(n);
    }

    public void getUniqueStrings(ArrayList<String> data) {
        for (int i = 0; i < data.size(); i++) {
            if(!uniqueStrings.contains(data.get(i)))
            {
                uniqueStrings.add(data.get(i));
                uniqueStringCount++;
            }
        }
    }

    public String stringLookup(String input) {
        if(uniqueStrings.contains(input))
        {
            return (input + " is in the string set");
        }
        else {
            return (input + " is not in the string set");
        }
    }
}

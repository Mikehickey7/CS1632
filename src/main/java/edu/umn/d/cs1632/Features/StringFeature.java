package edu.umn.d.cs1632.Features;

import java.util.ArrayList;

public class StringFeature extends Feature {
    public int uniqueStringCount = 0;
    public ArrayList<String> uniqueStrings;

    public StringFeature(String n) {
        super(n);
        uniqueStrings = new ArrayList<>();
    }

    public void addString(String s) {
        if (!stringLookup(s)) {
            uniqueStrings.add(s);
            uniqueStringCount++;
        }
    }

    public boolean stringLookup(String input) {
        return uniqueStrings.contains(input);
    }

    public String getUniqueString(String input) {
        if (uniqueStrings.contains(input)) {
            return input + " was found at index " + uniqueStrings.indexOf(input) + ".";
        }
        return input + " was not in the Feature, the last string in this feature is '" + uniqueStrings.get(uniqueStringCount-1) + "' at index " + (uniqueStringCount-1) + ".";
    }

    public ArrayList<String> getUniqueStrings() {
        return uniqueStrings;
    }
}

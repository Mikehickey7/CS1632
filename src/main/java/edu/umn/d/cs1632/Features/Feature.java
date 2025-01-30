package edu.umn.d.cs1632.Features;

public abstract class Feature {
    protected String fName;

    protected Feature() {}
    public Feature(String n) {
        fName = n; }

    public String featureName() { return fName; }
}


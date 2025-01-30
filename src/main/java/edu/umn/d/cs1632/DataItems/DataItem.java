package edu.umn.d.cs1632.DataItems;

public abstract class DataItem{
    public String type;
    public DataItem(String t) {
        type = t;
    }

    public String showString() { return "Should not happen"; }
    public String getString() {
        return "should not return";
    }
}

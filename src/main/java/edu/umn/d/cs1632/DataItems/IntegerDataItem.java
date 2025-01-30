package edu.umn.d.cs1632.DataItems;

public class IntegerDataItem extends DataItem {
    public int value;
    public IntegerDataItem(String t, int val) {
        super(t);
        value = val;
    }
    public String showString(){
        return "Integer: " + Integer.toString(value);
    }

    public int getInt() {
        return value;
    }
}

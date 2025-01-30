package edu.umn.d.cs1632.DataItems;

public class DoubleDataItem extends DataItem {
    public double value;
    public DoubleDataItem(String t, double val) {
        super(t);
        value = val;
    }
    public String showString() {
        return "Double: " + Double.toString(value);
    }

    public double getDouble() {
        return value;
    }
}

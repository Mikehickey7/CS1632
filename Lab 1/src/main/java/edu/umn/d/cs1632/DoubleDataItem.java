package edu.umn.d.cs1632;

public class DoubleDataItem extends DataItem {
    public double value;
    public DoubleDataItem(double val) {
        value = val;
    }
    public String showString() { return Double.toString(value); }
}

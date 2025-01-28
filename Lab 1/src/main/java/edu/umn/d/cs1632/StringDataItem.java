package edu.umn.d.cs1632;

public class StringDataItem extends DataItem{
    public String value;
    public StringDataItem(String val) {
        value = val;
    }
    public String showString() {
        return value;
    }
}

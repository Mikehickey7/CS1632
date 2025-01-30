package edu.umn.d.cs1632.DataItems;

public class StringDataItem extends DataItem {
    public String value;

    public StringDataItem(String t, String val) {
        super(t);
        value = val;
    }
    public String showString() {
        return "String: " + value;
    }

    public String getString() {
        return value;
    }
}

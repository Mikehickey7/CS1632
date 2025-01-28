package edu.umn.d.cs1632;

public class IntegerDataItem extends DataItem {
    public int value;
    public IntegerDataItem(int val){
        value = val;
    }
    public String showString(){
        return Integer.toString(value);
    }
}

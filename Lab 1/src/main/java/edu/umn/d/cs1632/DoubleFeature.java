package edu.umn.d.cs1632;

import java.util.ArrayList;
import java.util.Collections;

public class DoubleFeature extends Feature {
    public double mean;
    public double median;
    public double standDev;

    public DoubleFeature(String n) {
        super(n);
    }

    public void setMean(ArrayList<Double> data) {
        double tempMean = 0;
        for(int i = 0; i < data.size(); i++) {
            tempMean += data.get(i);
        }
        mean = tempMean / data.size();
    }

    public void setMedian(ArrayList<Double> data) {
        Collections.sort(data);

        if(data.size() % 2 == 0)
        {
            median = (data.get(data.size()/2) + data.get(data.size()/2 - 1)/2);
        }
        else
        {
            median = data.get(data.size()/2);
        }
    }

    public void setStandDev(ArrayList<Double> data) {
        double tempMean = 0;
        ArrayList<Double> tempArray;
        double tempVal;
        double varianceCount = 0;
        double varianceAvg;
        for(int i = 0; i < data.size(); i++) {
            tempMean += data.get(i);
        }
        tempMean = tempMean / data.size();

        for(int i = 0; i < data.size(); i++) {
            tempVal = data.get(i);
            tempVal = tempVal - tempMean;
            tempVal *= tempVal;
            varianceCount += tempVal;
        }
        varianceAvg = varianceCount / data.size();

        standDev = Math.sqrt(varianceAvg);
    }
}

package edu.umn.d.cs1632.Features;

import java.util.ArrayList;
import java.util.Collections;

public class DoubleFeature extends Feature {
    public ArrayList<Double> doubles;
    public double mean;
    public double median;
    public double standDev;

    public DoubleFeature(String n) {
        super(n);
        doubles = new ArrayList<>();
        setMean(doubles);
        setMedian(doubles);
        setStandDev(doubles);
    }
    //method to reset the mean, median, and standard deviation after a new double is added to the feature.
    public void addDouble(double num) {
        doubles.add(num);
        setMean(doubles);
        setMedian(doubles);
        setStandDev(doubles);
    }

    public void setMean(ArrayList<Double> data) {
        double tempMean = 0;
        for (int i = 0; i < data.size(); i++) {
            tempMean += data.get(i);
        }
        mean = tempMean / data.size();
    }

    public void setMedian(ArrayList<Double> data) {
        Collections.sort(data);
        if (data.size() == 0) {
            median = 0;
        } else if (data.size() % 2 == 0) {
            median = (data.get(data.size() / 2) + data.get(data.size() / 2 - 1) / 2);
        } else {
            median = data.get(data.size() / 2);
        }
    }

    public void setStandDev(ArrayList<Double> data) {
        double tempMean = 0;
        ArrayList<Double> tempArray;
        double tempVal;
        double varianceCount = 0;
        double varianceAvg;
        //find mean again
        for (int i = 0; i < data.size(); i++) {
            tempMean += data.get(i);
        }
        tempMean = tempMean / data.size();
        //for each data point subtract the mean, square it, then add it to the total for the set.
        for (int i = 0; i < data.size(); i++) {
            tempVal = data.get(i);
            tempVal = tempVal - tempMean;
            tempVal *= tempVal;
            varianceCount += tempVal;
        }
        //find average
        varianceAvg = varianceCount / (data.size()-1);
        //and then the square root of that is the standard deviation
        standDev = Math.sqrt(varianceAvg);
    }

    public double getMean() {
        return mean;
    }

    public double getMedian() {
        return median;
    }

    public double getStandDev() {
        return standDev;
    }
}

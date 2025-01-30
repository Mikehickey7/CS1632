package edu.umn.d.cs1632;

import com.opencsv.CSVReader;
import edu.umn.d.cs1632.DataItems.DataItem;
import edu.umn.d.cs1632.DataItems.DoubleDataItem;
import edu.umn.d.cs1632.DataItems.IntegerDataItem;
import edu.umn.d.cs1632.DataItems.StringDataItem;
import edu.umn.d.cs1632.Features.DoubleFeature;
import edu.umn.d.cs1632.Features.Feature;
import edu.umn.d.cs1632.Features.IntegerFeature;
import edu.umn.d.cs1632.Features.StringFeature;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

class Dataset {
    ArrayList<Feature> featureList;
    ArrayList<ArrayList<DataItem>> data;

    private Dataset() {
    }

    public Dataset(String fileName) {
        featureList = new ArrayList<>();
        data = new ArrayList<ArrayList<DataItem>>();
        ArrayList<DataItem> tempSet = new ArrayList<>();
        ArrayList<ArrayList<String>> tempData = new ArrayList<>();
        ArrayList<String> tempColumn = new ArrayList<>();
        int rowTracker = 0;


        try {
            //read in data from csv file and assign to variable
            FileReader filereader = new FileReader(fileName);
            CSVReader csvReader = new CSVReader(filereader);
            List<String[]> allData = csvReader.readAll();

            //loop through data and assign columns to an arraylist
            for (int i = 0; i <= allData.size(); i++) {
                for (String[] row : allData) {
                    tempColumn.add(row[i]);
                }
                //gets what the feature type of this column will be
                tempSet = determineFeatureType(tempColumn, rowTracker);
                //add to row tracker to have featureList select the right feature to add to.
                rowTracker++;
                data.add(tempSet);
                tempColumn.clear();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //print the details using the new Features that were just filled
        printFeatureDetails();
    }

    //method to determine the featureType/dataType of the whole column
    private ArrayList<DataItem> determineFeatureType(ArrayList<String> set, int rowTracker) {
        ArrayList<DataItem> tempDataItems = new ArrayList<>();
        ArrayList<Feature> tempFeatureList = new ArrayList<>();
        //this variable will be used to determine what featureType the data is
        String type = "IntegerFeature";
        //using try catch here in case of failure to convert datatype.
        try {
            //set i to one because the data is after the 0th index
            for (int i = 1; i < set.size(); i++) {
                int intValue = Integer.parseInt(set.get(i));
                tempDataItems.add(new IntegerDataItem(type, intValue));
            }
        } catch (NumberFormatException e) {
            tempDataItems.clear();
            //uses nested try/catch, not necessarily good but works :).
            try {
                type = "DoubleFeature";
                //set i to one because the data is after the 0th index
                for (int i = 1; i < set.size(); i++) {
                    double doubleValue = Double.parseDouble(set.get(i));
                    tempDataItems.add(new DoubleDataItem(type, doubleValue));
                }

            } catch (NumberFormatException e1) {
                tempDataItems.clear();
                type = "StringFeature";

                for (int i = 1; i < set.size(); i++) {
                    tempDataItems.add(new StringDataItem(type, set.get(i)));
                }
            }
        }
        //switch type based on the variable set earlier
        switch (type) {
            case "IntegerFeature":
                for (int i = 0; i <= tempDataItems.size(); i++) {
                    //makes a new feature using the column header
                    if (i == 0) {
                        featureList.add(new IntegerFeature(set.get(i)));
                    } else {
                        //finds the feature just made using the rowTracker input variable
                        Feature currentFeature = featureList.get(rowTracker);
                        //adds the unique data item to the feature
                        if (currentFeature instanceof IntegerFeature integerFeature) {
                            integerFeature.addInteger(Integer.parseInt(set.get(i)));
                        }
                    }
                }
                break;
            case "DoubleFeature":
                for (int i = 0; i <= tempDataItems.size(); i++) {
                    if (i == 0) {
                        featureList.add(new DoubleFeature(set.get(i)));
                    } else {
                        Feature currentFeature = featureList.get(rowTracker);

                        if (currentFeature instanceof DoubleFeature doubleFeature) {
                            doubleFeature.addDouble(Double.parseDouble(set.get(i)));
                        }
                    }
                }
                break;
            case "StringFeature":
                for (int i = 0; i <= tempDataItems.size(); i++) {
                    if (i == 0) {
                        featureList.add(new StringFeature(set.get(i)));
                    } else {
                        Feature currentFeature = featureList.get(rowTracker);

                        if (currentFeature instanceof StringFeature stringFeature) {
                            stringFeature.addString(set.get(i));
                        }
                    }
                }
        }
        return tempDataItems;
    }

    //Print out the details of each feature
    private void printFeatureDetails() {
        for (Feature feature : featureList) {
            System.out.println("Feature: " + feature.featureName());
            if (feature instanceof IntegerFeature integerFeature) {
                System.out.println("Type: IntegerFeature");
                System.out.println("Unique values: " + integerFeature.getUniqueIntegers());
                System.out.println("Low value: " + integerFeature.getLowest());
                System.out.println("High value: " + integerFeature.getHighest());
            } else if (feature instanceof DoubleFeature doubleFeature) {
                System.out.println("Type: DoubleFeature");
                System.out.println("Mean: " + doubleFeature.getMean());
                System.out.println("Median: " + doubleFeature.getMedian());
                System.out.println("Standard Deviation: " + doubleFeature.getStandDev());
            } else if (feature instanceof StringFeature stringFeature) {
                System.out.println("Type: StringFeature");
                System.out.println("Unique values: " + stringFeature.getUniqueStrings());
                System.out.println(stringFeature.getUniqueString("XXX"));
            }
            System.out.println();
        }
    }
}
package edu.umn.d.cs1632;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

class Dataset {
    ArrayList<Feature> featureList;
    ArrayList<ArrayList<DataItem>> data;

    private Dataset() {}
    public Dataset(String fileName) {
        ArrayList<Object> tempData = new ArrayList<>();
        ArrayList<Object> tempFeatureList = new ArrayList<>();

        try {
            FileReader filereader = new FileReader(fileName);
            CSVReader csvReader = new CSVReader(filereader);
            List<String[]> allData = csvReader.readAll();

            String[] features = allData.get(0);
            for(String feature : features) {
                tempFeatureList.add(feature);
            }

            for (String[] row : allData) {
                for (String cell : row) {
                    System.out.print(cell + "\t");

                }
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}


//import com.opencsv.CSVReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//
//public class Dataset {
//    private ArrayList<Feature> featureList;  // List of features (F1, F2, ...)
//    private ArrayList<ArrayList<DataItem>> data;  // 2D list for data items
//
//    // Constructor to read the CSV and initialize the features and data
//    public Dataset(String filename) {
//        featureList = new ArrayList<>();
//        data = new ArrayList<>();
//
//        try {
//            CSVReader reader = new CSVReader(new FileReader(filename));
//            List<String[]> rows = reader.readAll();
//            reader.close();
//
//            // Process the first row to create features
//            String[] headers = rows.get(0); // headers are the first row in CSV
//            for (String header : headers) {
//                // Assuming createFeature determines the feature type
//                featureList.add(createFeature(header, rows, featureList.size()));
//            }
//
//            // Process the rest of the rows and populate data items
//            for (int i = 1; i < rows.size(); i++) {
//                String[] row = rows.get(i);
//                ArrayList<DataItem> rowData = new ArrayList<>();
//
//                for (int j = 0; j < row.length; j++) {
//                    String value = row[j];
//                    Feature feature = featureList.get(j);
//
//                    // Create the appropriate DataItem based on feature type
//                    DataItem dataItem = createDataItem(feature, value);
//                    rowData.add(dataItem);
//                }
//
//                data.add(rowData);  // Add the row of data items to the data list
//            }
//
//            // Print out the details for each feature after data is loaded
//            printFeatureDetails();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Create the appropriate feature based on the feature name and data in the column
//    private Feature createFeature(String featureName, List<String[]> rows, int columnIndex) {
//        boolean allInteger = true;
//        boolean allDouble = true;
//
//        // Look through a few rows to decide the type of feature
//        for (int i = 1; i < Math.min(5, rows.size()); i++) {
//            String value = rows.get(i)[columnIndex];
//
//            // Check if all values are integers
//            try {
//                Integer.parseInt(value);
//            } catch (NumberFormatException e) {
//                allInteger = false;
//            }
//
//            // Check if all values are doubles (if not integer)
//            if (!allInteger) {
//                try {
//                    Double.parseDouble(value);
//                } catch (NumberFormatException e) {
//                    allDouble = false;
//                }
//            }
//
//            // If we know the feature is neither integer nor double, we can break early
//            if (!allInteger && !allDouble) {
//                break;
//            }
//        }
//
//        // Determine feature type based on the checks above
//        if (allInteger) {
//            return new IntegerFeature(featureName);
//        } else if (allDouble) {
//            return new DoubleFeature(featureName);
//        } else {
//            return new StringFeature(featureName);
//        }
//    }
//
//    // Create the appropriate DataItem based on the feature type and value
//    private DataItem createDataItem(Feature feature, String value) {
//        try {
//            // Try to create IntegerDataItem
//            Integer intValue = Integer.parseInt(value);
//            return new IntegerDataItem(intValue);
//        } catch (NumberFormatException e) {
//            try {
//                // Try to create DoubleDataItem
//                Double doubleValue = Double.parseDouble(value);
//                return new DoubleDataItem(doubleValue);
//            } catch (NumberFormatException ex) {
//                // Fallback to StringDataItem
//                return new StringDataItem(value);
//            }
//        }
//    }
//
//    // Print out the details of each feature
//    private void printFeatureDetails() {
//        for (Feature feature : featureList) {
//            System.out.println("Feature: " + feature.featureName());
//            if (feature instanceof IntegerFeature) {
//                IntegerFeature intFeature = (IntegerFeature) feature;
//                System.out.println("Type: IntegerFeature");
//                System.out.println("Unique values: " + intFeature.getUniqueValues());
//                System.out.println("Low value: " + intFeature.getLowValue());
//                System.out.println("High value: " + intFeature.getHighValue());
//            } else if (feature instanceof DoubleFeature) {
//                DoubleFeature doubleFeature = (DoubleFeature) feature;
//                System.out.println("Type: DoubleFeature");
//                System.out.println("Mean: " + doubleFeature.getMean());
//                System.out.println("Median: " + doubleFeature.getMedian());
//                System.out.println("Standard Deviation: " + doubleFeature.getStdDev());
//            } else if (feature instanceof StringFeature) {
//                StringFeature stringFeature = (StringFeature) feature;
//                System.out.println("Type: StringFeature");
//                System.out.println("Unique values: " + stringFeature.getUniqueValues());
//            }
//            System.out.println();
//        }
//    }
//
//    // Getters for featureList and data if needed
//    public ArrayList<Feature> getFeatureList() {
//        return featureList;
//    }
//
//    public ArrayList<ArrayList<DataItem>> getData() {
//        return data;
//    }
//
//    public static void main(String[] args) {
//        // Example: loading a CSV and creating the dataset
//        Dataset dataset = new Dataset("path/to/your/csvfile.csv");
//    }
//}


//Needed for BufferedReader to read in a text file
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Used to parse data in BufferedReader
import java.util.StringTokenizer;

//needed for Scanner class and to read in a text file
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class SalesFileHandler {
    public static void readSalesFile(String filename, List saleList) {
        String absolutePath = "/Users/charliekid/PycharmProjects/FrugalFoodieWebscrape/SaleItems.txt";
        String temp = "";

        //Open FileReader and BufferReader
        FileReader fileReader = null;
        BufferedReader inputStream = null;

        try {
            fileReader = new FileReader(absolutePath);
            System.out.println("File read");
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Exiting Program");
            System.exit(0);
        }

        // Lets process the data
        inputStream = new BufferedReader(fileReader);

        String itemName;
        double itemPrice;
        int itemUnit;

        try {
            String lineOfData;
            while((lineOfData = inputStream.readLine()) != null) {
                //System.out.println("Line Read : " + lineOfData);
                // Split on a comma and store items
                String[] saleInfo = lineOfData.split(";");
                //System.out.println("saleInfo length " + saleInfo.length);
                itemName = saleInfo[0];

                System.out.println("inside of saleInfo[1] " + saleInfo[1] + " does it contain / " + saleInfo[1].contains("/") );
                // Checking to see if there are more than one items on sale
                if(saleInfo[1].contains("/")) {
                    String[] tempArray = saleInfo[1].split("/");
                    itemUnit = Integer.parseInt(tempArray[0]);
                    // locate where the $ and substring and parse from there
                    //  i was getting errors from parsing anything like "$5"
                    int location = (tempArray[1].indexOf('$') + 1);
                    System.out.println("location of $ is at " + location);
                    itemPrice = Double.parseDouble(tempArray[1].substring(location));
                } else {
                    String[] tempArray = saleInfo[1].split(" ");
                    int location = (saleInfo[1].indexOf('$') + 1);
                    itemPrice = Double.parseDouble(tempArray[0].substring(location));
                    itemUnit = 1;
                }
                System.out.println("Adding " + itemName + " price: " + itemPrice + " unit: " + itemUnit);
                //saleList.add(new SaleItem(itemName, itemPrice, itemUnit));
            }
        } catch (IOException ioe) {
            System.out.println("ERROR in IOException file handler " + ioe.getMessage());
        } catch (NumberFormatException nfe) {
            System.out.println("ERROR in NumberFormatException file hanlder " + nfe.getMessage());
        }
        //inputStream.close();
    }
}

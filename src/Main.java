import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List salesList = new ArrayList<SaleItem>();

//        SalesFileHandler.readSalesFile("SaleItems.txt", salesList);
//        System.out.println("size = " + salesList.size());
        try {
            Runtime.getRuntime().exec("python hello.py");
        }
        catch(SecurityException se) {
            System.out.println(se.getMessage());
        }
        catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}

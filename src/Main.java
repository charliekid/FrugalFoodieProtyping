import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List salesList = new ArrayList<SaleItem>();

        SalesFileHandler.readSalesFile("SaleItems.txt", salesList);
    }
}

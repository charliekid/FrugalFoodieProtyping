import java.util.Objects;

public class SaleItem {
    private String itemName;    // name of item
    private double price;       // how much it costs
    private int qty;            // is it 1 item? 3 items? is it 4 lbs?
    private String unit;        // is it lbs, each etc

    public SaleItem(String itemName, double price, int qty, String unit) {
        this.itemName = itemName;
        this.price = price;
        this.qty = qty;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleItem saleItem = (SaleItem) o;
        return Double.compare(saleItem.price, price) == 0 &&
                qty == saleItem.qty &&
                itemName.equals(saleItem.itemName) &&
                unit.equals(saleItem.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, price, qty, unit);
    }

    @Override
    public String toString() {
        return "SaleItem{" +
                "itemName='" + itemName + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", unit='" + unit + '\'' +
                '}';
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}

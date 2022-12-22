package dat.backend.model.entities;

public class Item {

    int item_id;
    String item_name;
    String item_description;
    int price = 0;
    String unit;
    int quantity;
    int length;


    public Item(int item_id, String item_name, String item_description, int price, String unit, int length) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_description = item_description;
        this.price = price;
        this.unit = unit;
        this.length = length;
    }

    public int getItem_id() {
        return item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getItem_description() {
        return item_description;
    }

    public int getPrice() {
        return price;
    }

    public String getUnit() {
        return unit;
    }

    public int getLength() {
        return length;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item_id=" + item_id +
                ", item_name='" + item_name + '\'' +
                ", item_description='" + item_description + '\'' +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                ", quantity=" + quantity +
                ", length=" + length +
                '}';
    }
}


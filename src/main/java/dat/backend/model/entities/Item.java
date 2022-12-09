package dat.backend.model.entities;

public class Item {

    int item_id;
    String item_name;
    String item_description;
    int price = 0;
    int unit;
    int quantity;
    int length;

    public Item(int item_id, String item_name, String item_description, int price, int unit, int quantity, int length) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_description = item_description;
        this.price = price;
        this.unit = unit;
        this.quantity = quantity;
        this.length = length;
    }

    public Item() {

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

    public int getUnit() {
        return unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getLength() {
        return length;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setLength(int length) {
        this.length = length;
    }
}

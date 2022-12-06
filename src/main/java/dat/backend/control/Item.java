package dat.backend.control;

public class Item {

    int item_id;
    String item_name;
    String item_description;
    int price = 0;

    public Item(int item_id, String item_name, String item_description, int price) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_description = item_description;
        this.price = price;
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
}

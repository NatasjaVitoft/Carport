package dat.backend.model.entities;

public class ItemVariant {

    private int itemVariant_id;
    private String itemVariant_name;
    private String itemVariant_description;
    private int price = 0;
    private String unit;
    private int quantity;

    public ItemVariant(int itemVariant_id, String itemVariant_name, String itemVariant_description, int price, String unit, int quantity) {
        this.itemVariant_id = itemVariant_id;
        this.itemVariant_name = itemVariant_name;
        this.itemVariant_description = itemVariant_description;
        this.price = price;
        this.unit = unit;
        this.quantity = quantity;
    }

    public int getItemVariant_id() {
        return itemVariant_id;
    }

    public void setItemVariant_id(int itemVariant_id) {
        this.itemVariant_id = itemVariant_id;
    }

    public String getItemVariant_name() {
        return itemVariant_name;
    }

    public void setItemVariant_name(String itemVariant_name) {
        this.itemVariant_name = itemVariant_name;
    }

    public String getItemVariant_description() {
        return itemVariant_description;
    }

    public void setItemVariant_description(String itemVariant_description) {
        this.itemVariant_description = itemVariant_description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

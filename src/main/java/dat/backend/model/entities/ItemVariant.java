package dat.backend.model.entities;

public class ItemVariant {

    // Fields

    private int itemVariant_id;
    private String itemVariant_name;
    private String itemVariant_description;
    private int price = 0;
    private String unit;

    // Constructor

    public ItemVariant(int itemVariant_id, String itemVariant_name, String itemVariant_description, int price, String unit) {
        this.itemVariant_id = itemVariant_id;
        this.itemVariant_name = itemVariant_name;
        this.itemVariant_description = itemVariant_description;
        this.price = price;
        this.unit = unit;
    }


    // Methods

    public int getItemVariant_id() {
        return itemVariant_id;
    }

    public String getItemVariant_name() {
        return itemVariant_name;
    }

    public String getItemVariant_description() {
        return itemVariant_description;
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

    @Override
    public String toString() {
        return "ItemVariant{" +
                "itemVariant_id=" + itemVariant_id +
                ", itemVariant_name='" + itemVariant_name + '\'' +
                ", itemVariant_description='" + itemVariant_description + '\'' +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                '}';
    }
}

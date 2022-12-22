package dat.backend.model.entities;

public class BillOfMaterialLine {

    // fields

    private int item_id;
    private int itemVariant_id;
    private String name;
    private String unit;
    private int length;
    private int price;
    private String description;
    private int carport_id;
    private int quantity;
    private int orders_id;


    public BillOfMaterialLine(int itemVariant_id, String name, String unit, int price, String description, int quantity, int orders_id) {
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.orders_id = orders_id;
        this.itemVariant_id = itemVariant_id;
    }

    public BillOfMaterialLine(int item_id, String name, String unit, int length, int price, String description, int quantity, int orders_id) {
        this.item_id = item_id;
        this.name = name;
        this.unit = unit;
        this.length = length;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.orders_id = orders_id;
    }

    public BillOfMaterialLine(String name, String unit, int length, int price, String description, int quantity) {
        this.name = name;
        this.unit = unit;
        this.length = length;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public BillOfMaterialLine(String name, String unit, int price, String description, int quantity) {
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    // Methods

    public int getItem_id() {
        return item_id;
    }

    public int getOrders_id() {
        return orders_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getItemVariant_id() {
        return itemVariant_id;
    }


    @Override
    public String toString() {
        return "BillOfMaterialLine{" +
                "item_id=" + item_id +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", length=" + length +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", carport_id=" + carport_id +
                ", quantity=" + quantity +
                ", orders_id=" + orders_id +
                '}';
    }
}

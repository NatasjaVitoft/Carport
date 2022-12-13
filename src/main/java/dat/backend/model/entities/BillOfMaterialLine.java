package dat.backend.model.entities;

public class BillOfMaterialLine {

    private int item_id;
    private String name;
    private String unit;
    private int length;
    private int price;
    private String description;
    private int carport_id;
    private int quantity;
    private int orders_id;



    public BillOfMaterialLine() {

    }

    public BillOfMaterialLine(int item_id, String name, String unit, int length, int price, String description, int carport_id, int quantity, int orders_id) {
        this.item_id = item_id;
        this.name = name;
        this.unit = unit;
        this.length = length;
        this.price = price;
        this.description = description;
        this.carport_id = carport_id;
        this.quantity = quantity;
        this.orders_id = orders_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCarport_id() {
        return carport_id;
    }

    public void setCarport_id(int carport_id) {
        this.carport_id = carport_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

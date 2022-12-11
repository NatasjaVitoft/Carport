package dat.backend.model.entities;


public class Orderline {

    private int item_id;
    private int various_id;
    private int shed_id;
    private int price;

    public Orderline(int item_id, int various_id, int shed_id, int price) {
        this.item_id = item_id;
        this.various_id = various_id;
        this.shed_id = shed_id;
        this.price = price;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getVarious_id() {
        return various_id;
    }

    public void setVarious_id(int various_id) {
        this.various_id = various_id;
    }

    public int getShed_id() {
        return shed_id;
    }

    public void setShed_id(int shed_id) {
        this.shed_id = shed_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Orderline{" +
                "item_id=" + item_id +
                ", various_id=" + various_id +
                ", shed_id=" + shed_id +
                ", price=" + price +
                '}';
    }
}

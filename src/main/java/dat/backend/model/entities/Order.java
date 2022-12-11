package dat.backend.model.entities;

import java.sql.Timestamp;

public class Order {

    private Timestamp date;
    private String username;
    private int order_id;
    private int price;
    private String email;
    private String carport;

    public Order(Timestamp date, String username, int order_id, int price, String email, String carport) {
        this.date = date;
        this.username = username;
        this.order_id = order_id;
        this.price = price;
        this.email = email;
        this.carport = carport;
    }

    public Order(String username, int price, String email, String carport) {
        this.username = username;
        this.price = price;
        this.email = email;
        this.carport = carport;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCarport() {
        return carport;
    }

    public void setCarport(String carport) {
        this.carport = carport;
    }

    @Override
    public String toString() {
        return "Order{" +
                "date=" + date +
                ", username='" + username + '\'' +
                ", order_id=" + order_id +
                ", price=" + price +
                ", email='" + email + '\'' +
                ", carport='" + carport + '\'' +
                '}';
    }
}

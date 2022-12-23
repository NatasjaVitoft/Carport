package dat.backend.model.entities;

import java.sql.Timestamp;

public class Order {

    private Timestamp date;
    private String username;
    private int order_id;
    private int price;
    private String email;
    private String carportID;
    private int length;
    private int width;
    private int shedwidth;
    private int shedlength;


    public Order(Timestamp date, String username, int order_id, int price, String email, String carportID) {
        this.date = date;
        this.username = username;
        this.order_id = order_id;
        this.price = price;
        this.email = email;
        this.carportID = carportID;
    }

    public Order(String username, int price, String email, String carportID) {
        this.username = username;
        this.price = price;
        this.email = email;
        this.carportID = carportID;
    }

    public Order(Timestamp date, String username, int order_id, int price, String email, String carportID, int length, int width) {
        this.date = date;
        this.username = username;
        this.order_id = order_id;
        this.price = price;
        this.email = email;
        this.carportID = carportID;
        this.length = length;
        this.width = width;
    }

    public Order(String username, int price, String email, String carportID, int length, int width) {
        this.username = username;
        this.order_id = order_id;
        this.price = price;
        this.email = email;
        this.carportID = carportID;
        this.length = length;
        this.width = width;
    }

    public Order(int order_id) {
        this.order_id = order_id;
    }

    public Order(String username, int price, String email, String carportID, int length, int width, int shedwidth, int shedlength) {
        this.carportID = carportID;
        this.username = username;
        this.price = price;
        this.email = email;
        this.length = length;
        this.width = width;
        this.shedwidth = shedwidth;
        this.shedlength = shedlength;
    }

    public Order(int length, int width, int shedwidth, int shedlength) {
        this.length = length;
        this.width = width;
        this.shedwidth = shedwidth;
        this.shedlength = shedlength;
    }

    public Timestamp getDate() {
        return date;
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

    public String getCarportID() {
        return carportID;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getShedwidth() {
        return shedwidth;
    }

    public void setShedwidth(int shedwidth) {
        this.shedwidth = shedwidth;
    }

    public int getShedlength() {
        return shedlength;
    }

    public void setShedlength(int shedlength) {
        this.shedlength = shedlength;
    }

    @Override
    public String toString() {
        return "Order{" +
                "date=" + date +
                ", username='" + username + '\'' +
                ", order_id=" + order_id +
                ", price=" + price +
                ", email='" + email + '\'' +
                ", carport='" + carportID + '\'' +
                '}';
    }
}

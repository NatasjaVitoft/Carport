package dat.backend.model.entities;

import java.util.ArrayList;

public class Carport {

    final int height;
    final int length;
    final int price;

    ArrayList<Item> itemList = new ArrayList<>();


    public Carport(int height, int length, int price, ArrayList<Item> itemList) {
        this.height = height;
        this.length = length;
        this.price  = price;
        this.itemList = itemList;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }
}

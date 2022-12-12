package dat.backend.model.entities;

import java.util.ArrayList;
import java.util.List;

public class BillOfMaterials {

    private List<Carport> inventoryList = new ArrayList<>();
    private int totalPrice;

    public void add(Carport carport) {
        inventoryList.add(carport);
    }

    public int getNumberOfCarport() {
        return inventoryList.size();
    }

    public List<Carport> getCarportList() {
        return inventoryList;
    }

    public int getTotalPriceOfCarport() {
        return totalPrice;
    }

    public void setTotalPriceOfCarport(int totalPrice) {
        this.totalPrice = totalPrice;
    }

}

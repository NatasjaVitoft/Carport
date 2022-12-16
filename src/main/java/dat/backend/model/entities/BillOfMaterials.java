package dat.backend.model.entities;

import java.util.ArrayList;
import java.util.List;

public class BillOfMaterials {

    List<BillOfMaterialLine> billOfMaterialLinesList = new ArrayList<>();
    private int totalPrice;


    public int getNumberOfCarport() {
        return billOfMaterialLinesList.size();
    }

    public List<BillOfMaterialLine> getCarportList() {
        return billOfMaterialLinesList;
    }

    public int getTotalPriceOfCarport() {
        return totalPrice;
    }

    public void setTotalPriceOfCarport(int totalPrice) {
        this.totalPrice = totalPrice;
    }

}

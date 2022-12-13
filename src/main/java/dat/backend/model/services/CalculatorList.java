package dat.backend.model.services;

import dat.backend.model.entities.BillOfMaterialLine;
import dat.backend.model.exceptions.DatabaseException;

import java.util.ArrayList;
import java.util.List;

public class CalculatorList {

    // Metode som skal tilføje alle BillOfMaterialLines til en liste og returnerer den

    public static List<BillOfMaterialLine> calculateCarport (int ID, int width, int length) throws DatabaseException {

        // Initialiserer en arrayliste til alle materialerne i en ordre
        List<BillOfMaterialLine> billOfMaterialLinesList = new ArrayList<>();

        // Tilføjer alle hjælpemetoderne/beregningerne fra calculator klassen til listen
        billOfMaterialLinesList.add(Calculator.calcRafter(ID, width, length));

        return billOfMaterialLinesList;
    }
}

package dat.backend.model.services;
import dat.backend.model.entities.BillOfMaterialLine;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CalculatorList {

    // method that adds all BOMLines to a list and returns it
    // Metode som skal tilføje alle BillOfMaterialLines til en liste og returnerer den

    public static List<BillOfMaterialLine> calculateCarport (ConnectionPool connectionPool, int ID, int width, int length) throws DatabaseException, SQLException {

        // instance
        // Initialiserer en arrayliste til alle materialerne i en ordre
        List<BillOfMaterialLine> billOfMaterialLinesList = new ArrayList<>();

        // adding materials to the list from the calc class
        // Tilføjer alle hjælpemetoderne/beregningerne fra calculator klassen til listen

        billOfMaterialLinesList.add(Calculator.calcRafter(connectionPool, ID, width, length));
        billOfMaterialLinesList.add(Calculator.calcStrap(ID, width, length, connectionPool));
        billOfMaterialLinesList.add(Calculator.calcPost(ID, width, length, connectionPool));
        billOfMaterialLinesList.add(Calculator.calcBolts(ID, width, length, connectionPool));
        billOfMaterialLinesList.add(Calculator.calcLongRafterTree(ID, width, length, connectionPool));
        billOfMaterialLinesList.add(Calculator.calcUnderSternFrontAndBack(ID, width, length, connectionPool));
        billOfMaterialLinesList.add(Calculator.calcUnderSternSides(ID, width, length, connectionPool));
        billOfMaterialLinesList.add(Calculator.calcUnderSternSmall(ID, width, length, connectionPool));



        return billOfMaterialLinesList;
    }
}

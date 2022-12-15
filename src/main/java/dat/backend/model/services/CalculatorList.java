package dat.backend.model.services;
import dat.backend.model.entities.BillOfMaterialLine;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CalculatorList {

    // Metode som skal tilføje alle BillOfMaterialLines til en liste og returnerer den

    public static List<BillOfMaterialLine> calculateCarport (ConnectionPool connectionPool, int ID, int width, int length) throws DatabaseException, SQLException {

        // Initialiserer en arrayliste til alle materialerne i en ordre
        List<BillOfMaterialLine> billOfMaterialLinesList = new ArrayList<>();

        // Tilføjer alle hjælpemetoderne/beregningerne fra calculator klassen til listen

        billOfMaterialLinesList.add(Calculator.calcRafter(connectionPool, ID, width, length));
        billOfMaterialLinesList.add(Calculator.calcStrap(ID, width, length, connectionPool));

       /* billOfMaterialLinesList.add(Calculator.calcRafter(ID, width, length));
        billOfMaterialLinesList.add(Calculator.calcLongRafterTree(ID, width, length));
        billOfMaterialLinesList.add(Calculator.calcBolts(ID, width, length));
        billOfMaterialLinesList.add(Calculator.calcBeslagSkruer(ID, width, length));
        billOfMaterialLinesList.add(Calculator.calcPost(ID, width, length));*/



        return billOfMaterialLinesList;
    }
}

package dat.backend.model.services;

import dat.backend.model.entities.BillOfMaterialLine;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.BillOfMaterialLineFacade;
import dat.backend.model.persistence.BomVariantFacade;
import dat.backend.model.persistence.ConnectionPool;

import java.sql.SQLException;
import java.util.ArrayList;

public class CalculatorList {

    // Method that adds all BOMLines to a list and returns it
    // Metode som skal tilføje alle BillOfMaterialLines til en liste og returnerer den

    public static int calculateTotalPrice(ConnectionPool connectionPool, int ID, int width, int length, int shedLength, int shedWidth) throws SQLException, DatabaseException {

        int totalPrice = 0;

        ArrayList<BillOfMaterialLine> priceForMaterial1;
        ArrayList<BillOfMaterialLine> priceForMaterial2;

        priceForMaterial1 = calculateCarport(connectionPool, ID, width, length, shedLength, shedWidth);
        priceForMaterial2 = calculateCarport2(connectionPool, ID, width, length, shedLength, shedWidth);

        for (BillOfMaterialLine b : priceForMaterial1) {
            totalPrice += b.getPrice();
        }

        for (BillOfMaterialLine b : priceForMaterial2) {
            totalPrice += b.getPrice();
        }

        return totalPrice;
    }


    /** FÅ ALT DET HER TIL AT VIRKE. MEGET SMARTERE MÅDE AT GØRE DET PÅ. FÅ ALLE TING VÆK FRA SERVLET
    public static void addBOMlines(ConnectionPool connectionPool, int ID, int width, int length, int shedlength, int shedwidth) throws DatabaseException, SQLException {


        ArrayList<BillOfMaterialLine> allMaterial;
        ArrayList<BillOfMaterialLine> allMaterial2;

        allMaterial = CalculatorList.calculateCarport(connectionPool, ID, width, length, shedlength, shedwidth);
        allMaterial2 = CalculatorList.calculateCarport2(connectionPool, ID, width, length, shedlength, shedwidth);

        for (BillOfMaterialLine b : allMaterial) {
            BillOfMaterialLineFacade.createBOML(b.getItem_id(), b.getName(), b.getUnit(), b.getLength(), b.getPrice(), b.getDescription(), b.getQuantity(), b.getOrders_id(), connectionPool);
        }

        for (BillOfMaterialLine b : allMaterial2) {
            BomVariantFacade.createBOMLVariant(b.getName(), b.getUnit(), b.getPrice(), b.getDescription(), b.getQuantity(), b.getOrders_id(), b.getItemVariant_id(), connectionPool);
        }
    }
     **/

    public static ArrayList<BillOfMaterialLine> calculateCarport(ConnectionPool connectionPool, int ID, int width, int length, int shedLength, int shedWidth) throws DatabaseException, SQLException {

        // instance
        // Initialiserer en arrayliste til alle materialerne i en ordre

        ArrayList<BillOfMaterialLine> billOfMaterialLinesList = new ArrayList<>();

        // adding materials to the list from the calc class
        // Tilføjer alle hjælpemetoderne/beregningerne fra calculator klassen til listen

        billOfMaterialLinesList.add(Calculator.calcRafter(connectionPool, ID, width, length));
        billOfMaterialLinesList.add(Calculator.calcStrap(ID, width, length, shedWidth, shedLength, connectionPool));
        billOfMaterialLinesList.add(Calculator.calcPost(ID, width, length, connectionPool));
        billOfMaterialLinesList.add(Calculator.calcBolts(ID, width, length, connectionPool));
        billOfMaterialLinesList.add(Calculator.calcLongRafterTree(ID, width, length, connectionPool));
        billOfMaterialLinesList.add(Calculator.calcUnderSternFrontAndBack(ID, width, length, connectionPool));
        billOfMaterialLinesList.add(Calculator.calcUnderSternSides(ID, width, length, connectionPool));
        billOfMaterialLinesList.add(Calculator.calcUnderSternSmall(ID, width, length, connectionPool));
        billOfMaterialLinesList.add(Calculator.calcWeatherboard1(ID, width, length, connectionPool));
        billOfMaterialLinesList.add(Calculator.calcWeatherboard2(ID, width, length, connectionPool));

        if (shedWidth != 0 && shedLength != 0) {
            billOfMaterialLinesList.add(CalculatorShed.calcStrapForShed(ID, shedWidth, shedLength, connectionPool));
            billOfMaterialLinesList.add(CalculatorShed.calcLægte(ID, width, length, shedWidth, shedLength, connectionPool));
            billOfMaterialLinesList.add(CalculatorShed.calcLøsholter(ID, width, length, shedWidth, shedLength, connectionPool));
            billOfMaterialLinesList.add(CalculatorShed.calcLøsholterSide(ID, width, length, shedWidth, shedLength, connectionPool));
        }

        return billOfMaterialLinesList;
    }

    public static ArrayList<BillOfMaterialLine> calculateCarport2(ConnectionPool connectionPool, int ID, int width, int length, int shedWidth, int shedLength) throws SQLException, DatabaseException {

        ArrayList<BillOfMaterialLine> billOfMaterialLinesVariantList = new ArrayList<>();

        billOfMaterialLinesVariantList.add(Calculator.calcBeslagSkruer(ID, width, length, connectionPool));
        billOfMaterialLinesVariantList.add(Calculator.calcBundskruer(ID, width, length, connectionPool));
        billOfMaterialLinesVariantList.add(Calculator.calcSkruer(ID, width, length, connectionPool));
        billOfMaterialLinesVariantList.add(Calculator.calcFirkant(ID, width, length, connectionPool));
        billOfMaterialLinesVariantList.add(Calculator.calcSkruer2(ID, width, length, connectionPool));
        billOfMaterialLinesVariantList.add(Calculator.calcSkruer3(ID, width, length, connectionPool));
        billOfMaterialLinesVariantList.add(Calculator.calcUniversalLeft(ID, width, length, connectionPool));
        billOfMaterialLinesVariantList.add(Calculator.calcUniversalRight(ID, width, length, connectionPool));
        billOfMaterialLinesVariantList.add(Calculator.calcBolts(ID, width, length, connectionPool));

        if (shedWidth != 0 && shedLength != 0) {
            billOfMaterialLinesVariantList.add(CalculatorShed.stalddørsgreb(ID, width, length, shedWidth, shedLength, connectionPool));
            billOfMaterialLinesVariantList.add(CalculatorShed.vinkelbeslag(ID, width, length, shedWidth, shedLength, connectionPool));
            billOfMaterialLinesVariantList.add(CalculatorShed.hængsel(ID, width, length, shedWidth, shedLength, connectionPool));
        }

        return billOfMaterialLinesVariantList;
    }
}

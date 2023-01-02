package dat.backend.model.services;

import dat.backend.model.entities.BillOfMaterialLine;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;

import java.sql.SQLException;
import java.util.ArrayList;

public class CalculatorList {


    // The method has int as return time and a connectionpool, ID, width, length, shedlength and shedwidth as parameters
    public static int calculateTotalPrice(ConnectionPool connectionPool, int ID, int width, int length, int shedLength, int shedWidth) throws SQLException, DatabaseException {

        // Initialize variable with the type int to equal 0
        int totalPrice = 0;

        // Creates two arraylists of the type BillOfMaterialLine
        ArrayList<BillOfMaterialLine> priceForMaterial1;
        ArrayList<BillOfMaterialLine> priceForMaterial2;

        // Initialize arraylists. Equals methods that return an arraylist of billOfMaterialLine with all the BOM lines
        priceForMaterial1 = calculateCarport(connectionPool, ID, width, length, shedLength, shedWidth);
        priceForMaterial2 = calculateCarport2(connectionPool, ID, width, length, shedLength, shedWidth);

        // Looping through arraylists
        for (BillOfMaterialLine b : priceForMaterial1) {
            totalPrice += b.getPrice();
        }

        for (BillOfMaterialLine b : priceForMaterial2) {
            totalPrice += b.getPrice();
        }

        // Return totalprice after loop
        return totalPrice;
    }


    /**
     Træ & Tagplader listen
     */
    // The method has an arraylist of BillOfMaterialLine as return type and a connectionpool, ID, width, length, shedlength and shedwidth as parameters
    public static ArrayList<BillOfMaterialLine> calculateCarport(ConnectionPool connectionPool, int ID, int width, int length, int shedLength, int shedWidth) throws DatabaseException, SQLException {


        // Initialize arraylist of BillOfMaterialLine
        ArrayList<BillOfMaterialLine> billOfMaterialLinesList = new ArrayList<>();

        // Adding Objects/instances of BillOfMaterial to the list from the calculator class
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

        // Adding Objects/instances of BillOfMaterial to the list from the calculator and calculatorShed class if there is a shed
        if (shedWidth != 0 && shedLength != 0) {
            billOfMaterialLinesList.add(CalculatorShed.calcStrapForShed(ID, shedWidth, shedLength, connectionPool));
            billOfMaterialLinesList.add(CalculatorShed.calcLægte(ID, width, length, shedWidth, shedLength, connectionPool));
            billOfMaterialLinesList.add(CalculatorShed.calcLøsholter(ID, width, length, shedWidth, shedLength, connectionPool));
            billOfMaterialLinesList.add(CalculatorShed.calcLøsholterSide(ID, width, length, shedWidth, shedLength, connectionPool));
        }

        // Return the list with all the bill of material lines
        return billOfMaterialLinesList;
    }

    /**
        Skruer & beslag listen
     */
    // The method has an arraylist of BillOfMaterialLine as return type and a connectionpool, ID, width, length, shedlength and shedwidth as parameters
    public static ArrayList<BillOfMaterialLine> calculateCarport2(ConnectionPool connectionPool, int ID, int width, int length, int shedWidth, int shedLength) throws SQLException, DatabaseException {

        // Initialize arraylist of BillOfMaterialLine
        ArrayList<BillOfMaterialLine> billOfMaterialLinesVariantList = new ArrayList<>();


        // Adding Objects/instances of BillOfMaterial to the list from the calculator class
        billOfMaterialLinesVariantList.add(Calculator.calcBeslagSkruer(ID, width, length, connectionPool));
        billOfMaterialLinesVariantList.add(Calculator.calcBundskruer(ID, width, length, connectionPool));
        billOfMaterialLinesVariantList.add(Calculator.calcSkruer(ID, width, length, connectionPool));
        billOfMaterialLinesVariantList.add(Calculator.calcFirkant(ID, width, length, connectionPool));
        billOfMaterialLinesVariantList.add(Calculator.calcSkruer2(ID, width, length, connectionPool));
        billOfMaterialLinesVariantList.add(Calculator.calcSkruer3(ID, width, length, connectionPool));
        billOfMaterialLinesVariantList.add(Calculator.calcUniversalLeft(ID, width, length, connectionPool));
        billOfMaterialLinesVariantList.add(Calculator.calcUniversalRight(ID, width, length, connectionPool));
        billOfMaterialLinesVariantList.add(Calculator.calcBolts(ID, width, length, connectionPool));

        // Adding Objects/instances of BillOfMaterial to the list from the calculator and calculatorShed class if there is a shed
        if (shedWidth != 0 && shedLength != 0) {
            billOfMaterialLinesVariantList.add(CalculatorShed.stalddørsgreb(ID, width, length, shedWidth, shedLength, connectionPool));
            billOfMaterialLinesVariantList.add(CalculatorShed.vinkelbeslag(ID, width, length, shedWidth, shedLength, connectionPool));
            billOfMaterialLinesVariantList.add(CalculatorShed.hængsel(ID, width, length, shedWidth, shedLength, connectionPool));
        }

        // Return the list with all the bill of material lines
        return billOfMaterialLinesVariantList;
    }
}

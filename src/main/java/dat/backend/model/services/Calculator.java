package dat.backend.model.services;

import dat.backend.model.entities.BillOfMaterialLine;
import dat.backend.model.entities.Item;
import dat.backend.model.entities.ItemVariant;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.ItemFacade;
import dat.backend.model.persistence.ItemVariantFacade;

import java.sql.SQLException;

public class Calculator {

    /**
     * STYKLISTE : TRÆ (FØRSTE DEN AF LISTEN)
     */

    // Calc Rafter
    // Spær
    public static BillOfMaterialLine calcRafter(ConnectionPool connectionPool, int ID, double width, double length) throws DatabaseException, SQLException {

        int rafter = (int) Math.ceil(length / 55);
        Item items = ItemFacade.getItemByID(10, connectionPool);
        int price = items.getPrice() * rafter;
        return new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), price, items.getItem_description(), rafter, ID);
    }

    // Calc Strap
    // Rem
    public static BillOfMaterialLine calcStrap(int ID, double width, double length, int shedWidth, int shedLength, ConnectionPool connectionPool) throws DatabaseException {

        if (shedWidth == 0 && shedLength == 0) {
            int strap = (int) Math.ceil(length * 2);
            int strap_result = strap / 600;
            Item items = ItemFacade.getItemByID(8, connectionPool);
            int price = strap_result * items.getPrice();
            return new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), price, items.getItem_description(), strap_result, ID);
        } else {
            double n_length = length - shedLength;
            int strap = (int) (n_length * 2);
            int strap_result = strap / 600;
            Item items = ItemFacade.getItemByID(8, connectionPool);
            int price = strap_result * items.getPrice();
            return new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), price, items.getItem_description(), strap_result, ID);
        }
    }


    // Calc post
    // Stolpe
    public static BillOfMaterialLine calcPost(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {

        int post = (int) (length - 120);
        int post2 = (int) Math.ceil(post / 300);
        int post3 = post2 * 2;

        Item items = ItemFacade.getItemByID(11, connectionPool);
        int price = items.getPrice() * post3;

        return new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), price, items.getItem_description(), post3, ID);
    }


    // calc under stern in front and back end of the garage.
    // 5x200 mm. trykimp. Brædt 360 4 Stk understernbrædder til for & bag ende
    public static BillOfMaterialLine calcUnderSternFrontAndBack(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {

        int stern1 = (int) (width + 5);
        int stern2 = (int) (width + 5);
        int stern3 = stern1 + stern2;
        int stern_result = (int) Math.ceil(stern3 / 360);

        Item items = ItemFacade.getItemByID(1, connectionPool);
        int price = stern_result * items.getPrice();

        return new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), price, items.getItem_description(), stern_result, ID);
    }

    // Calc Stern of the sides
    // 25x125mm. trykimp. Brædt 540 4 Stk oversternbrædder til siderne
    // 25x200 mm. trykimp. Brædt 540 4 Stk understernbrædder til siderne
    public static BillOfMaterialLine calcUnderSternSides(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {

        int stern1 = (int) (length + 5);
        int stern2 = (int) (length + 5);
        int stern3 = stern1 + stern2;
        int stern_result = (int) Math.ceil(stern3 / 540);

        Item items = ItemFacade.getItemByID(2, connectionPool);
        int price = items.getPrice() * stern_result;
        return new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), price, items.getItem_description(), stern_result, ID);
    }

    // 25x125mm. trykimp. Brædt 360 2 Stk oversternbrædder til forenden
    public static BillOfMaterialLine calcUnderSternSmall(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {

        int stern1 = (int) (width + 5);
        double stern2 = stern1 / 360;
        int stern_result = (int) Math.ceil(stern2);

        Item items = ItemFacade.getItemByID(3, connectionPool);
        int price = items.getPrice() * stern_result;
        return new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), price, items.getItem_description(), stern_result, ID);
    }

    // Calc Rafter tree, Long
    // 45x195	mm.	spærtræ	ubh., længde: 600
    public static BillOfMaterialLine calcLongRafterTree(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {

        int rafter = (int) Math.ceil(length / 55);
        Item items = ItemFacade.getItemByID(10, connectionPool);
        int price = items.getPrice() * rafter;
        return new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), price, items.getItem_description(), rafter, ID);
    }


    /**
     * STYKLISTE : SKRUER OG BESLAG (ANDEN DEL)
     */

    // Calc bolts
    // Bræddebolt	10	x	120	mm.	 18 Stk Til	montering	af	rem	på	stolper
    public static BillOfMaterialLine calcBolts(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {

        int post1 = (int) Math.floor(length - 120);
        int post2 = post1 / 310;
        int bolt = post2 * 2;
        ItemVariant itemVariants = ItemVariantFacade.getItemByID(7, connectionPool);
        int price = itemVariants.getPrice() * bolt;
        return new BillOfMaterialLine(itemVariants.getItemVariant_id(), itemVariants.getItemVariant_name(), itemVariants.getUnit(), price, itemVariants.getItemVariant_description(), bolt, ID);
    }


    // universal	190	mm	højre 15 Stk Til	montering	af	spær	på	rem
    public static BillOfMaterialLine calcUniversalRight(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException, SQLException {
        int universal = (int) Math.ceil(length / 55);
        ItemVariant itemVariants = ItemVariantFacade.getItemByID(3, connectionPool);
        int price = itemVariants.getPrice() * universal;
        return new BillOfMaterialLine(itemVariants.getItemVariant_id(), itemVariants.getItemVariant_name(), itemVariants.getUnit(), price, itemVariants.getItemVariant_description(), universal, ID);
    }


    // universal 190	mm	venstre 15 Stk Til	montering	af	spær	på	rem
    public static BillOfMaterialLine calcUniversalLeft(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException, SQLException {
        int universal = (int) Math.ceil(length / 55);
        ItemVariant itemVariants = ItemVariantFacade.getItemByID(4, connectionPool);
        int price = itemVariants.getPrice() * universal;
        return new BillOfMaterialLine(itemVariants.getItemVariant_id(), itemVariants.getItemVariant_name(), itemVariants.getUnit(), price, itemVariants.getItemVariant_description(), universal, ID);
    }


    // 4,0	x	50	mm.	beslagskruer	250, stk. 3 pakke Til	montering	af	universalbeslag	+	hulbånd
    public static BillOfMaterialLine calcBeslagSkruer(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException, SQLException {
        int n1 = calcUniversalLeft(ID, width, length, connectionPool).getQuantity() * 3;
        int n2 = calcUniversalRight(ID, width, length, connectionPool).getQuantity() * 3;

        int beslagSkruer = n1 + n2;
        int beslagsSkruer_result = beslagSkruer / 250;

        ItemVariant itemVariants = ItemVariantFacade.getItemByID(6, connectionPool);
        int price = itemVariants.getPrice() * beslagsSkruer_result;
        return new BillOfMaterialLine(itemVariants.getItemVariant_id(), itemVariants.getItemVariant_name(), itemVariants.getUnit(), price, itemVariants.getItemVariant_description(), beslagsSkruer_result, ID);
    }


    // Plastmo bundskruer 200 stk. 3 pakke Skruer til tagplader
    // Vi har valgt at sætte en default værdi så alle tage skal bruge 3 pakker bundskruer

    public static BillOfMaterialLine calcBundskruer(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {
        int bundskruer = 3;
        ItemVariant itemVariants = ItemVariantFacade.getItemByID(1, connectionPool);
        int price = itemVariants.getPrice() * bundskruer;
        return new BillOfMaterialLine(itemVariants.getItemVariant_id(), itemVariants.getItemVariant_name(), itemVariants.getUnit(), price, itemVariants.getItemVariant_description(), bundskruer, ID);
    }

    // 4,5 x 60 mm. skruer 200 stk. 1 Pakke Til montering af stern &v andbrædt
    // Vi har valgt at sætte en default værdi så alle tage skal bruge 1 pakker

    public static BillOfMaterialLine calcSkruer(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {
        int skruer = 1;
        ItemVariant itemVariants = ItemVariantFacade.getItemByID(5, connectionPool);
        int price = itemVariants.getPrice() * skruer;
        return new BillOfMaterialLine(itemVariants.getItemVariant_id(), itemVariants.getItemVariant_name(), itemVariants.getUnit(), price, itemVariants.getItemVariant_description(), skruer, ID);
    }

    // firkantskiver 40x40x11mm 12 Stk Til montering af rem på stolper
    // Vi har valgt at sætte en default værdi så alle tage skal bruge 12
    public static BillOfMaterialLine calcFirkant(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {

        int firkant = 12;
        ItemVariant itemVariants = ItemVariantFacade.getItemByID(8, connectionPool);
        int price = itemVariants.getPrice() * firkant;
        return new BillOfMaterialLine(itemVariants.getItemVariant_id(), itemVariants.getItemVariant_name(), itemVariants.getUnit(), price, itemVariants.getItemVariant_description(), firkant, ID);
    }

    // 4,5 x 70 mm. Skruer 400 stk. 2 pk. til montering af yderste beklædning
    // Vi har valgt at sætte en default værdi så alle tage skal bruge 2 pakker
    public static BillOfMaterialLine calcSkruer2(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {
        int skruer = 2;
        ItemVariant items = ItemVariantFacade.getItemByID(9, connectionPool);
        int price = items.getPrice() * skruer;
        return new BillOfMaterialLine(items.getItemVariant_id(), items.getItemVariant_name(), items.getUnit(), price, items.getItemVariant_description(), skruer, ID);
    }

    // 4,5 x 50 mm. Skruer 300 stk. 2 pk. til montering af inderste beklædning
    // Vi har valgt at sætte en default værdi så alle tage skal bruge 2 pakker
    public static BillOfMaterialLine calcSkruer3(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {
        int skruer = 2;
        ItemVariant items = ItemVariantFacade.getItemByID(10, connectionPool);
        int price = items.getPrice() * skruer;
        return new BillOfMaterialLine(items.getItemVariant_id(), items.getItemVariant_name(), items.getUnit(), price, items.getItemVariant_description(), skruer, ID);
    }

    // 19x100 mm. trykimp. Brædt 540 4 Stk vandbrædt på stern i sider
    public static BillOfMaterialLine calcWeatherboard1(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {
        int n = calcUnderSternSides(ID, width, length, connectionPool).getQuantity();
        Item items = ItemFacade.getItemByID(13, connectionPool);
        int price = items.getPrice() * n;
        return new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), price, items.getItem_description(), n, ID);
    }

    // 19x100 mm. trykimp. Brædt 360 2 Stk vandbrædt på stern i forende
    public static BillOfMaterialLine calcWeatherboard2(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {
        int n = calcUnderSternSmall(ID, width, length, connectionPool).getQuantity();
        Item items = ItemFacade.getItemByID(14, connectionPool);
        int price = items.getPrice() * n;
        return new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), price, items.getItem_description(), n, ID);
    }
}













   /*
    public static BillOfMaterialLine calcStrap(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {
        if(shed == true) {
            int n1 = (int) Math.ceil(shed.length/480);
            Item items = ItemFacade.getItemByID(9, connectionPool);
            int price = items.getPrice() * n1;
            BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), price, items.getItem_description(), n1, ID);
            return billOfMaterialLine;
        }
        else {
            return null;
        }
    }

     */


// 45x195 mm. spærtræ ubh. 480 1 Stk
//Remme i sider, sadles ned i stolper ( skur del,
//deles)




    /*

    // hulbånd 1x20 mm. 10 mtr. 2 Rulle Til vindkryds på spær
    public static BillOfMaterialLine calcMeasurementTapeQuantity(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {
        int n_measurement = 0;

        int n = measurementTape(width, length);

        if(n >= 10 && n < 20) {
            n_measurement = 1;
        }
        if(n >= 20 && n < 30) {
            n_measurement = 2;
        }
        if(n >= 30 && n < 40) {
            n_measurement = 3;
        }
        if(n >= 40 && n < 50) {
            n_measurement = 4;
        }

        Item items = ItemFacade.getItemByID(4, connectionPool);
        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), items.getPrice(), items.getItem_description(), 1, n_measurement, ID);
        return billOfMaterialLine;
    }

    */


// Calc measurement tape
// med skur kan man sige length - 55 på den ene side, og så minus skur bredde på 210. det giver 265
// uden skur kan man sige length - 110 (starter lide ud fra det første spær)



    /*
    // Hulbånd
    public static BillOfMaterialLine measurementTape(double width, double length, ConnectionPool connectionPool) {

     if (skur == true){
     int n = (int) Math.sqrt(Math.pow(width, 2) + Math.pow(length -265, 2));
        int n_measurementTape = n * 2;

         Item items = ItemFacade.getItemByID(3, connectionPool);

        return BillOfMaterialLine;

     } else {
     int n = (int) Math.sqrt(Math.pow(width, 2) + Math.pow(length -110, 2));
        int n_measurementTape = n * 2;
        return n_measurementTape;
     }
    }

     */

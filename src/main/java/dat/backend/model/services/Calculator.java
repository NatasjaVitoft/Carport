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


    // TEGNING

    // Calc Rafter
    // Spær
    public static BillOfMaterialLine calcRafter(ConnectionPool connectionPool, int ID, double width, double length) throws DatabaseException, SQLException {

            int n_rafter = (int) Math.ceil(length / 55);
            Item items = ItemFacade.getItemByID(10, connectionPool);
            int price = items.getPrice() * n_rafter;
            BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), price, items.getItem_description(), n_rafter, ID);
            return billOfMaterialLine;
    }

    // Calc Strap
    // Rem
    public static BillOfMaterialLine calcStrap(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {

            int n_strap = (int) Math.ceil(length * 2);
            int result = n_strap / 600;
            Item items = ItemFacade.getItemByID(8, connectionPool);
            int price = result * items.getPrice();
            BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), price, items.getItem_description(), result, ID);
            return billOfMaterialLine;
    }


    // Calc post
    // Stolpe
    public static BillOfMaterialLine calcPost(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {

        int n_post = (int) Math.floor(length - 120);
        int n_post2 = n_post/310;
        int n_post3 = n_post2 * 2;

        Item items = ItemFacade.getItemByID(11, connectionPool);
        int price = items.getPrice() * n_post3;
        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), price, items.getItem_description(), n_post3, ID);

        return billOfMaterialLine;
    }


    // STYKLISTE

    // calc under stern in front and back end of the garage.
    // 5x200 mm. trykimp. Brædt 360 4 Stk understernbrædder til for & bag ende
    public static BillOfMaterialLine calcUnderSternFrontAndBack(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {

        int u_stern1 = (int) (width + 5);
        int u_stern2 = (int) (width + 5);
        int u_rs = u_stern1 + u_stern2;
        int result = (int) Math.ceil(u_rs/360);

        Item items = ItemFacade.getItemByID(1, connectionPool);
        int price = result * items.getPrice();

        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), price, items.getItem_description(), result, ID);

        return billOfMaterialLine;
    }

    // Calc Stern of the sides
    // 25x125mm. trykimp. Brædt 540 4 Stk oversternbrædder til siderne
    // 25x200 mm. trykimp. Brædt 540 4 Stk understernbrædder til siderne
    public static BillOfMaterialLine calcUnderSternSides(int ID ,double width, double length, ConnectionPool connectionPool) throws DatabaseException {

        int s_stern1 = (int) (length + 5);
        int s_stern2 = (int) (length + 5);
        int s_rs = s_stern1 + s_stern2;
        int result = (int) Math.ceil(s_rs/540);

        Item items = ItemFacade.getItemByID(2, connectionPool);
        int price = items.getPrice() * result;
        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), price, items.getItem_description(), result, ID);
        return billOfMaterialLine;
    }

    // 25x125mm. trykimp. Brædt 360 2 Stk oversternbrædder til forenden
    public static BillOfMaterialLine calcUnderSternSmall(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {

        int u_stern2 = (int) (width + 5);
        double result1 = u_stern2/360;
        int result = (int) Math.ceil(result1);

        Item items = ItemFacade.getItemByID(3, connectionPool);
        int price = items.getPrice() * result;
        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), price, items.getItem_description(), result, ID);
        return billOfMaterialLine;
    }


    // Træ og tagplader

    // Calc Rafter tree, Long
    // 45x195	mm.	spærtræ	ubh., længde: 600
    public static BillOfMaterialLine calcLongRafterTree(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {

        int n_rafter = (int) Math.ceil(length / 55);
        Item items = ItemFacade.getItemByID(10, connectionPool);
        int price = items.getPrice() * n_rafter;
        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), price, items.getItem_description(), n_rafter, ID);
        return billOfMaterialLine;
    }


    // Skruer OG beslag

    // Calc bolts
    // Bræddebolt	10	x	120	mm.	 18 Stk Til	montering	af	rem	på	stolper
    public static BillOfMaterialLine calcBolts(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {

        int n_post = (int) Math.floor(length - 120);
        int n_post2 = n_post / 310;
        int n_bolt = n_post2 * 2;
        ItemVariant itemVariants = ItemVariantFacade.getItemByID(7, connectionPool);
        int price = itemVariants.getPrice() * n_bolt;
        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(itemVariants.getItemVariant_id(), itemVariants.getItemVariant_name(), itemVariants.getUnit(), price, itemVariants.getItemVariant_description(), n_bolt, ID);
        return billOfMaterialLine;
    }


    // universal	190	mm	højre 15 Stk Til	montering	af	spær	på	rem
    public static BillOfMaterialLine calcUniversalRight(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException, SQLException {
        int n = calcRafter(connectionPool, ID, width, length).getQuantity();
        ItemVariant itemVariants = ItemVariantFacade.getItemByID(3, connectionPool);
        int price = itemVariants.getPrice() * n;
        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(itemVariants.getItemVariant_id(), itemVariants.getItemVariant_name(), itemVariants.getUnit(), price, itemVariants.getItemVariant_description(), n, ID);
        return billOfMaterialLine;
    }


    // universal 190	mm	venstre 15 Stk Til	montering	af	spær	på	rem
    public static BillOfMaterialLine calcUniversalLeft(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException, SQLException {
        int n = calcRafter(connectionPool, ID, width, length).getQuantity();
        ItemVariant itemVariants = ItemVariantFacade.getItemByID(4, connectionPool);
        int price = itemVariants.getPrice() * n;
        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(itemVariants.getItemVariant_id(), itemVariants.getItemVariant_name(), itemVariants.getUnit(), price, itemVariants.getItemVariant_description(), n, ID);
        return billOfMaterialLine;
    }


    // 4,0	x	50	mm.	beslagskruer	250, stk. 3 pakke Til	montering	af	universalbeslag	+	hulbånd
    public static BillOfMaterialLine calcBeslagSkruer(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException, SQLException {
        int n1 = calcUniversalLeft(ID, width, length, connectionPool).getQuantity() * 3;
        int n2 = calcUniversalRight(ID, width, length, connectionPool).getQuantity() * 3;

        int n_beslagSkruer = n1 + n2;
        int n = n_beslagSkruer/250;

        ItemVariant itemVariants = ItemVariantFacade.getItemByID(6, connectionPool);
        int price = itemVariants.getPrice() * n;
        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(itemVariants.getItemVariant_id(), itemVariants.getItemVariant_name(), itemVariants.getUnit(), price, itemVariants.getItemVariant_description(), n, ID);
        return billOfMaterialLine;
    }


    // Plastmo bundskruer 200 stk. 3 pakke Skruer til tagplader
    // Vi har valgt at sætte en default værdi så alle tage skal bruge 3 pakker bundskruer

    public static BillOfMaterialLine calcBundskruer(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {

        int n = 3;
        ItemVariant itemVariants = ItemVariantFacade.getItemByID(1, connectionPool);
        int price = itemVariants.getPrice() * n;
        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(itemVariants.getItemVariant_id(), itemVariants.getItemVariant_name(), itemVariants.getUnit(), price, itemVariants.getItemVariant_description(), n, ID);
        return billOfMaterialLine;
    }

    // 4,5 x 60 mm. skruer 200 stk. 1 Pakke Til montering af stern &v andbrædt
    // Vi har valgt at sætte en default værdi så alle tage skal bruge 1 pakker

    public static BillOfMaterialLine calcSkruer(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {

        int n = 1;
        ItemVariant itemVariants = ItemVariantFacade.getItemByID(5, connectionPool);
        int price = itemVariants.getPrice() * n;
        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(itemVariants.getItemVariant_id(), itemVariants.getItemVariant_name(), itemVariants.getUnit(), price, itemVariants.getItemVariant_description(), n, ID);
        return billOfMaterialLine;
    }

    // firkantskiver 40x40x11mm 12 Stk Til montering af rem på stolper
    // Vi har valgt at sætte en default værdi så alle tage skal bruge 12
    public static BillOfMaterialLine calcFirkant(int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {

        int n = 12;
        ItemVariant itemVariants = ItemVariantFacade.getItemByID(8, connectionPool);
        int price = itemVariants.getPrice() * n;
        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(itemVariants.getItemVariant_id(), itemVariants.getItemVariant_name(), itemVariants.getUnit(), price, itemVariants.getItemVariant_description(), n, ID);
        return billOfMaterialLine;
    }

    // 4,5 x 70 mm. Skruer 400 stk. 2 pk. til montering af yderste beklædning
    // Vi har valgt at sætte en default værdi så alle tage skal bruge 2 pakker
    public static BillOfMaterialLine calcSkruer2 (int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {
        int n = 2;
        ItemVariant items = ItemVariantFacade.getItemByID(9, connectionPool);
        int price = items.getPrice() * n ;
        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(items.getItemVariant_id(), items.getItemVariant_name(), items.getUnit(), price, items.getItemVariant_description(), n, ID);
        return billOfMaterialLine;
    }

    // 4,5 x 50 mm. Skruer 300 stk. 2 pk. til montering af inderste beklædning
    // Vi har valgt at sætte en default værdi så alle tage skal bruge 2 pakker
    public static BillOfMaterialLine calcSkruer3 (int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {
        int n = 2;
        ItemVariant items = ItemVariantFacade.getItemByID(10, connectionPool);
        int price = items.getPrice() * n;
        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(items.getItemVariant_id(), items.getItemVariant_name(), items.getUnit(), price, items.getItemVariant_description(), n, ID);
        return billOfMaterialLine;
    }


    // 19x100 mm. trykimp. Brædt 540 4 Stk vandbrædt på stern i sider
    public static BillOfMaterialLine calcVandbræt (int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {
        int n = calcUnderSternSides(ID, width, length, connectionPool).getQuantity();
        Item items = ItemFacade.getItemByID(13, connectionPool);
        int price = items.getPrice() * n;
        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), price, items.getItem_description(), n, ID);
        return billOfMaterialLine;
    }

    // 19x100 mm. trykimp. Brædt 360 2 Stk vandbrædt på stern i forende
    public static BillOfMaterialLine calcVandbrætForende (int ID, double width, double length, ConnectionPool connectionPool) throws DatabaseException {
        int n = calcUnderSternSmall(ID, width, length, connectionPool).getQuantity();
        Item items = ItemFacade.getItemByID(14, connectionPool);
        int price = items.getPrice() * n;
        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), price, items.getItem_description(), n, ID);
        return billOfMaterialLine;
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

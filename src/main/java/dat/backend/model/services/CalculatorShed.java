package dat.backend.model.services;

import dat.backend.model.entities.BillOfMaterialLine;
import dat.backend.model.entities.Item;
import dat.backend.model.entities.ItemVariant;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.ItemFacade;
import dat.backend.model.persistence.ItemVariantFacade;

public class CalculatorShed {

    /*** STYKLISTE : HVIS SKUR VÆLGES (TREDJE DEL) */

// 45x195 mm. spærtræ ubh. 480 1 Stk Remme i sider,
    public static BillOfMaterialLine calcStrapForShed(int ID, double shedWidth, double shedLength, ConnectionPool connectionPool) throws DatabaseException {

        int n_strap = (int) Math.ceil(shedLength * 2);
        int result = n_strap / 480;
        Item items = ItemFacade.getItemByID(9, connectionPool);
        int price = result * items.getPrice();
        return new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), price, items.getItem_description(), result, ID);
    }

    // 38x73 mm. Lægte ubh. 420 1 stk til z på bagside af dør
    //DEFAULT VÆRDI
    public static BillOfMaterialLine calcLægte(int ID, int width, int length, double shedWidth, double shedLength, ConnectionPool connectionPool) throws DatabaseException {

        int lægte = 1;
        Item items = ItemFacade.getItemByID(5, connectionPool);
        int price = lægte * items.getPrice();
        return new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), price, items.getItem_description(), lægte, ID);
    }

    // 45x95 mm. Reglar ub. 270 12 stk løsholter til skur gavle
// DEFAULT VÆRDI
    public static BillOfMaterialLine calcLøsholter(int ID, int width, int length, double shedWidth, double shedLength, ConnectionPool connectionPool) throws DatabaseException {

        int løsholter = 12;
        Item items = ItemFacade.getItemByID(6, connectionPool);
        int price = løsholter * items.getPrice();
        return new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), price, items.getItem_description(), løsholter, ID);
    }

    // 45x95 mm. Reglar ub. 240 4 stk løsholter til skur sider
    public static BillOfMaterialLine calcLøsholterSide(int ID, int width, int length, double shedWidth, double shedLength, ConnectionPool connectionPool) throws DatabaseException {

        int løsholter = 4;
        Item items = ItemFacade.getItemByID(7, connectionPool);
        int price = løsholter * items.getPrice();
        return new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), price, items.getItem_description(), løsholter, ID);
    }

    // stalddørsgreb 50x75 1 Sæt Til lås på dør i skur
// DEFAULT VÆRDI
    public static BillOfMaterialLine stalddørsgreb(int ID, int width, int length, double shedWidth, double shedLength, ConnectionPool connectionPool) throws DatabaseException {

        int løsholter = 1;
        ItemVariant items = ItemVariantFacade.getItemByID(11, connectionPool);
        int price = løsholter * items.getPrice();
        return new BillOfMaterialLine(items.getItemVariant_id(), items.getItemVariant_name(), items.getUnit(), price, items.getItemVariant_description(), løsholter, ID);

    }

    // hængsel 390 mm 2 Stk Til skurdør
    public static BillOfMaterialLine hængsel(int ID, int width, int length, double shedWidth, double shedLength, ConnectionPool connectionPool) throws DatabaseException {

        int hængsel = 2;
        ItemVariant items = ItemVariantFacade.getItemByID(12, connectionPool);
        int price = hængsel * items.getPrice();
        return new BillOfMaterialLine(items.getItemVariant_id(), items.getItemVariant_name(), items.getUnit(), price, items.getItemVariant_description(), hængsel, ID);

    }

// vinkelbeslag 35 32 Stk Til montering af løsholter i skur
    // DEFAULT VÆRDI

    public static BillOfMaterialLine vinkelbeslag(int ID, int width, int length, double shedWidth, double shedLength, ConnectionPool connectionPool) throws DatabaseException {

        int beslag = 32;
        ItemVariant items = ItemVariantFacade.getItemByID(13, connectionPool);
        int price = beslag * items.getPrice();
        return new BillOfMaterialLine(items.getItemVariant_id(), items.getItemVariant_name(), items.getUnit(), price, items.getItemVariant_description(), beslag, ID);
    }
}

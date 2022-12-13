package dat.backend.model.services;
<<<<<<< HEAD
=======

<<<<<<< HEAD
import dat.backend.model.entities.BillOfMaterialLine;
=======
>>>>>>> 64a77a0976fc9d9ca5d9aeddb05b36eeaf4751db
>>>>>>> 9a68bbfb566f1d053cb0ebfd2cc2764f8b5e0da9
import dat.backend.model.entities.Item;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.ItemFacade;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    static ConnectionPool connectionPool;

    // Metode som skal tilføje alle BillOfMaterialLines til en liste og returnerer den

    public List<BillOfMaterialLine> calculateCarport (int width, int length) throws DatabaseException {

        List<BillOfMaterialLine> billOfMaterialLinesList = new ArrayList<>();

        billOfMaterialLinesList.add(calcRafter(width, length));

        return billOfMaterialLinesList;
    }


    // TEGNING

    // Spær
    public static BillOfMaterialLine calcRafter(double width, double length) throws DatabaseException {
        int n_rafter = (int) Math.ceil(length / 55);

        Item items = ItemFacade.getItemByID(1, connectionPool);

        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), items.getPrice(), items.getItem_description(), 1, n_rafter);
        return billOfMaterialLine;
    }

    // Rem
    public static BillOfMaterialLine calcStrap(double width, double length) throws DatabaseException {
        int n_strap = (int) Math.ceil(length * 2);

        Item items = ItemFacade.getItemByID(2, connectionPool);

        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), items.getPrice(), items.getItem_description(), 2, n_strap);
        return billOfMaterialLine;
    }

    // Stolpe
    public static BillOfMaterialLine calcPost(double width, double length) throws DatabaseException {
        int n_post = (int) Math.floor(length - 120 / 310);

        Item items = ItemFacade.getItemByID(3, connectionPool);

        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), items.getPrice(), items.getItem_description(), 3, n_post);
        return billOfMaterialLine;
    }

    // Hulbånd
    public static int measurementTape(double width, double length) {
        int n = (int) Math.sqrt(Math.pow(width, 2) + Math.pow(length, 2));
        int n_measurementTape = n * 2;
        return n_measurementTape;
    }

    // STYKLISTE

    // Træ og tagplader

    // 45x195	mm.	spærtræ	ubh., længde: 600
    public static int calcLongRafterTree(double width, double length) throws DatabaseException {
        int n_rafter = calcRafter(width, length);
        return n_rafter;
    }

    // Skruer OG beslag

    // Bræddebolt	10	x	120	mm.	 18 Stk Til	montering	af	rem	på	stolper
    public static int calcBolts(double width, double length) {
        int n = calcPost(width, length);
        int n_bolt = n * 2;
        return n_bolt;
    }

    // universal	190	mm	højre 15 Stk Til	montering	af	spær	på	rem
    public static int calcUniversalRight(double width, double length) {
        int n = calcRafter(width, length);
        int n_universalRight = n;
        return n_universalRight;
    }

    // universal	190	mm	venstre 15 Stk Til	montering	af	spær	på	rem
    public static int calcUniversalLeft(double width, double length) {
        int n = calcRafter(width, length);
        int n_universalLeft = n;
        return n_universalLeft;
    }

    // 4,0	x	50	mm.	beslagskruer	250, stk. 3 pakke Til	montering	af	universalbeslag	+	hulbånd
    public static int calcBeslagSkruer(double width, double length) {
        int n1 = calcUniversalLeft(width, length) * 3;
        int n2 = calcUniversalRight(width, length) * 3;

        int n_beslagSkruer = n1 + n2;
        return n_beslagSkruer;
        // MANGLER STADIG EN DEL
    }

    // hulbånd 1x20 mm. 10 mtr. 2 Rulle Til vindkryds på spær
    public static int calcMeasurementTapeQuantity(double width, double length) {
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
        return n_measurement;
    }

    // STERN

    // 25x200	mm.	trykimp.	Brædt 360 4 Stk understernbrædder	til	for	&	bag	ende
    public static int calcUnderSternSmall(double width, double length) {
        int n = 600;
        int n1 = n + 5;
        int n_underStern = (int) Math.ceil(n1 / 360) * 2;
        return n_underStern;
    }

    // 25x200	mm.	trykimp.	Brædt 540 4 Stk understernbrædder	til	siderne
    public static int calcUnderSternBig(double width, double length) {
        return 0;
    }

    // 25x125mm.	trykimp.	Brædt 360 2 Stk oversternbrædder	til	forenden
    public static int calcOverSternSmall(double width, double length) {
        return 0;
    }

    // 25x125mm.	trykimp.	Brædt 540 4 Stk oversternbrædder	til	siderne
    public static int calcOverSternBig(double width, double length) {
        return 0;
    }

    // Plastmo bundskruer 200 stk. 3 pakke Skruer til tagplader
    public static int calcBundskruer(double width, double length) {
        return 0;
    }

    // 4,5 x 60 mm. skruer 200 stk. 1 Pakke Til montering af stern &v andbrædt
    public static int calcSkruer(double width, double length) {
        return 0;
    }

    // firkantskiver 40x40x11mm 12 Stk Til montering af rem på stolper
    public static int calcFirkant(double width, double length) {
        return 0;
    }

    // 4,5 x 70 mm. Skruer 400 stk. 2 pk. til montering af yderste beklædning
    public static int calcSkruer2 (double width, double length) {
        return 0;
    }

    // 4,5 x 50 mm. Skruer 300 stk. 2 pk. til montering af inderste beklædning
    public static int calcSkruer3 (double width, double length) {
        return 0;
    }
}

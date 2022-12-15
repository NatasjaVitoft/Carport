package dat.backend.model.services;
import dat.backend.model.entities.BillOfMaterialLine;
import dat.backend.model.entities.Item;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.ItemFacade;


public class Calculator {

    static ConnectionPool connectionPool;

    // TEGNING

    // Spær
    public static BillOfMaterialLine calcRafter(int ID, double width, double length) throws DatabaseException {
        int n_rafter = (int) Math.ceil(length / 55);

        Item items = ItemFacade.getItemByID(1, connectionPool);

        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), items.getPrice(), items.getItem_description(), 1, n_rafter, ID);
        return billOfMaterialLine;
    }

    // Rem
    public static BillOfMaterialLine calcStrap(int ID, double width, double length) throws DatabaseException {
        int n_strap = (int) Math.ceil(length * 2);

        Item items = ItemFacade.getItemByID(2, connectionPool);

        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), items.getPrice(), items.getItem_description(), 2, n_strap, ID);
        return billOfMaterialLine;
    }

    // Stolpe
    public static BillOfMaterialLine calcPost(int ID, double width, double length) throws DatabaseException {
        int n_post = (int) Math.floor(length - 120 / 310);

        Item items = ItemFacade.getItemByID(3, connectionPool);

        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), items.getPrice(), items.getItem_description(), 3, n_post, ID);
        return billOfMaterialLine;
    }

    // uden skur kan man sige width + 0.55 + 0.55 (starter lide ud fra det første spær)

    // Hulbånd
    public static int measurementTape(double width, double length) {
        int n = (int) Math.sqrt(Math.pow(width, 2) + Math.pow(length, 2));
        int n_measurementTape = n * 2;
        return n_measurementTape;
    }

    // STYKLISTE

    // beregning af understern til for & bagende
    // understern skal have +2,5 cm på hver side af forreste spær og bagerste spær.

    public static int calcUnderSternFrontAndBack(double width, double length){

        int u_stern = (int) (width * 0.6);

        return u_stern;

    }
    }


    /*public static int calcUnderSternSides(double width, double length){



    }/*



    // Træ og tagplader


    // 45x195	mm.	spærtræ	ubh., længde: 600
    public static BillOfMaterialLine calcLongRafterTree(int ID, double width, double length) throws DatabaseException {
        int n_rafter = (int) Math.ceil(length / 55);
        Item items = ItemFacade.getItemByID(3, connectionPool);
        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), items.getPrice(), items.getItem_description(), 1, n_rafter, ID);
        return billOfMaterialLine;
    }

    // Skruer OG beslag

    // Bræddebolt	10	x	120	mm.	 18 Stk Til	montering	af	rem	på	stolper
    public static BillOfMaterialLine calcBolts(int ID, double width, double length) throws DatabaseException {
        int n_post = (int) Math.floor(length - 120 / 310);
        int n_bolt = n_post * 2;
        Item items = ItemFacade.getItemByID(4, connectionPool);
        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), items.getPrice(), items.getItem_description(), 1, n_bolt, ID);
        return billOfMaterialLine;

    }

    // universal	190	mm	højre 15 Stk Til	montering	af	spær	på	rem
    public static BillOfMaterialLine calcUniversalRight(int ID, double width, double length) throws DatabaseException {
        int n = calcRafter(ID, width, length).getQuantity();
        int n_universalRight = n;
        Item items = ItemFacade.getItemByID(4, connectionPool);
        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), items.getPrice(), items.getItem_description(), 1, n_universalRight, ID);
        return billOfMaterialLine;
    }

    // universal	190	mm	venstre 15 Stk Til	montering	af	spær	på	rem
    public static BillOfMaterialLine calcUniversalLeft(int ID, double width, double length) throws DatabaseException {
        int n = calcRafter(ID, width, length).getQuantity();
        int n_universalLeft = n;
        Item items = ItemFacade.getItemByID(4, connectionPool);
        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), items.getPrice(), items.getItem_description(), 1, n_universalLeft, ID);
        return billOfMaterialLine;
    }

    // 4,0	x	50	mm.	beslagskruer	250, stk. 3 pakke Til	montering	af	universalbeslag	+	hulbånd
    public static BillOfMaterialLine calcBeslagSkruer(int ID, double width, double length) throws DatabaseException {
        int n1 = calcUniversalLeft(ID, width, length).getQuantity() * 3;
        int n2 = calcUniversalRight(ID, width, length).getQuantity() * 3;

        int n_beslagSkruer = n1 + n2;

        Item items = ItemFacade.getItemByID(4, connectionPool);
        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), items.getPrice(), items.getItem_description(), 1, n_beslagSkruer, ID);
        return billOfMaterialLine;

    }

    // hulbånd 1x20 mm. 10 mtr. 2 Rulle Til vindkryds på spær
    public static BillOfMaterialLine calcMeasurementTapeQuantity(int ID, double width, double length) throws DatabaseException {
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

    // STERN

    // 25x200	mm.	trykimp.	Brædt 360 4 Stk understernbrædder	til	for	&	bag	ende
    public static BillOfMaterialLine calcUnderSternSmall(int ID, double width, double length) throws DatabaseException {
        int n = 600;
        int n1 = n + 5;
        int n_underStern = (int) Math.ceil(n1 / 360) * 2;

        Item items = ItemFacade.getItemByID(4, connectionPool);
        BillOfMaterialLine billOfMaterialLine = new BillOfMaterialLine(items.getItem_id(), items.getItem_name(), items.getUnit(), items.getLength(), items.getPrice(), items.getItem_description(), 1, n_underStern, ID);
        return billOfMaterialLine;
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
}*/

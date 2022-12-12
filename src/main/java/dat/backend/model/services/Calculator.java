package dat.backend.model.services;
import dat.backend.model.entities.Item;

import java.util.ArrayList;

public class Calculator {


    ArrayList<Item> items = new ArrayList<>();

    // TEGNING

    // Spær
    public static int calcRafter(double width, double length) {
        int n_rafter = (int) Math.ceil(length / 55);
        // MÅSKE SKAL DEN VÆRE 60 SOM BESKREVET I TEKSTEN (max 60cm)
        return n_rafter;
    }

    // Rem
    static int calcStrap(double width, double length) {
        int n_strap = (int) Math.ceil(length * 2);
        return n_strap;
    }

    // Stolpe
    public static int calcPost(double width, double length) {
        int n_post = (int) Math.floor(length - 120 / 310);
        return n_post;
    }

    // Hulbånd
    static int measurementTape(double width, double length) {
        int n = (int) Math.sqrt(Math.pow(width, 2) + Math.pow(length, 2));
        int n_measurementTape = n * 2;
        return n_measurementTape;
    }

    // STYKLISTE

    // TRÆ

    // 45x195	mm.	spærtræ	ubh., længde: 600
    static int calcLongRafterTree(double width, double length) {
        int n_rafter = calcRafter(width, length);
        return n_rafter;
    }

    // SKRUER OG BESLAG

    // Bræddebolt	10	x	120	mm.	 18 Stk Til	montering	af	rem	på	stolper
    static int calcBolts(double width, double length) {
        int n = calcPost(width, length);
        int n_bolt = n * 2;
        return n_bolt;
    }

    // universal	190	mm	højre 15 Stk Til	montering	af	spær	på	rem
    static int calcUniversalRight(double width, double length) {
        int n = calcRafter(width, length);
        int n_universalRight = n;
        return n_universalRight;
    }

    // universal	190	mm	venstre 15 Stk Til	montering	af	spær	på	rem
    static int calcUniversalLeft(double width, double length) {
        int n = calcRafter(width, length);
        int n_universalLeft = n;
        return n_universalLeft;
    }

    // 4,0	x	50	mm.	beslagskruer	250, stk. 3 pakke Til	montering	af	universalbeslag	+	hulbånd
    static int calcBeslagSkruer(double width, double length) {
        int n1 = calcUniversalLeft(width, length) * 3;
        int n2 = calcUniversalRight(width, length) * 3;

        int n_beslagSkruer = n1 + n2;
        return n_beslagSkruer;
        // MANGLER STADIG EN DEL
    }

    // hulbånd 1x20 mm. 10 mtr. 2 Rulle Til vindkryds på spær
    static int calcMeasurementTapeQuantity(double width, double length) {
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
    static int calcUnderSternSmall(double width, double length) {
        int n = 600;
        int n1 = n + 5;
        int n_underStern = (int) Math.ceil(n1 / 360) * 2;
        return n_underStern;
    }

    // 25x200	mm.	trykimp.	Brædt 540 4 Stk understernbrædder	til	siderne
    static int calcUnderSternBig(double width, double length) {
        return 0;
    }

    // 25x125mm.	trykimp.	Brædt 360 2 Stk oversternbrædder	til	forenden
    static int calcOverSternSmall(double width, double length) {
        return 0;
    }

    // 25x125mm.	trykimp.	Brædt 540 4 Stk oversternbrædder	til	siderne
    static int calcOverSternBig(double width, double length) {
        return 0;
    }


    // RESULTAT FUNKTIONER

    static ArrayList<Integer> getDrawingItemList(double width, double length) {
        ArrayList<Integer> drawingItemList = new ArrayList<>();
        ArrayList<String> drawingItemNameList = new ArrayList<>();


        return drawingItemList;
    }

    static ArrayList<Integer> getItemList(double width, double length) {
        ArrayList<Integer> itemList = new ArrayList<>();
        ArrayList<String> itemNameList = new ArrayList<>();
        // I den her funktion skal alle stykliste funktionerne kaldes, og resultatet skal tilføjes til listen
        return itemList;
    }

}

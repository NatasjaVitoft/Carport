package dat.backend.model.services;

import java.util.ArrayList;

public class Calculator {

    // TEGNING

    // Spær
    static int calcRafter(double width, double length) {
        int n_rafter = (int) Math.ceil(length / 55);
        return n_rafter;
    }

    // Rem
    static int calcStrap(double width, double length) {
        int n_strap = (int) Math.ceil(length * 2);
        return n_strap;
    }

    // Stolpe
    static int calcPost(double width, double length) {
        int n_post = (int) Math.floor(length - 120 / 302.5);
        return n_post;
    }

    // Hulbånd
    static int measurementTape(double width, double length) {
        int n = (int) Math.sqrt(Math.pow(width, 2) + Math.pow(length, 2));
        int n_measurementTape = n * 2;
        return n_measurementTape;
    }

    // STYKLISTE

    // 45x195	mm.	spærtræ	ubh., længde: 600
    static int calcLongRafterTree(double width, double length) {
        int n_rafter = calcRafter(width, length);
        return n_rafter;
    }

    // Bræddebolt	10	x	120	mm.	 18 Stk Til	montering	af	rem	på	stolper
     static int calcBolts(double width, double length) {
        int n = calcPost(width, length);
        int n_bolt = n * 2;
        return n_bolt;
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

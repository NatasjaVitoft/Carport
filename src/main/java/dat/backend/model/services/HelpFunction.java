package dat.backend.model.services;

public class HelpFunction {

    public static SVGDrawing createNewSVG(int x, int y, int height, int width, String viewbox) {
        return new SVGDrawing(height,  width, viewbox, x, y);
    }

    public static SVGDrawing addBeams(SVGDrawing svg) {
        for (int i = 0; i < 800; i += 50) {
            svg.addRect(i, 0, 600.0, 4.5);
        }
        return svg;
    }

    public static String drawCarportFladtSideView(int length) {

        String generateSVG = "";

        String viewBoxIn = String.format("");
        String viewBoxOut = String.format("");

        return generateSVG;

    }

    public static SVGDrawing drawCarportfladtTopView(double length, double width) {

        // need to get the list with the calculated items
        //List<BillOfMaterialLine> billOfMaterialLinesList = ArrayList<>();
        String viewBox = "0, 0, " + 855 + ", " + 855;
        SVGDrawing svg = new SVGDrawing(0, 0, viewBox, 100, 100);

        //draw frame
        /*for(int i = 0; i < 780; i += 55) {
            svg.addRect(i, 0, 200, 25);
        }*/
        svg.addRect(0, 0, width, length);

        //need the quantity of the item, so we can put it inside our drawing
        //draw rafter
        //BillOfMaterialLine rafter = billOfMaterialLinesList.getQuantity();


        return svg;
    }
}

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

        String viewBoxIn = String.format("0 , 0, %d, %d", length, 220);
        String viewBoxOut = String.format("0 , 0, %d, %d", length + 100, 220 + 100);

        SVGDrawing svgOuterDrawing = new SVGDrawing(length + 100, 220 + 100, viewBoxOut, 0,0);
        SVGDrawing svgInnerDrawing = new SVGDrawing(length, 220, viewBoxIn, 75, 10);

        svgInnerDrawing.addLine(0,220,length,220);

        int stolpe = 108;
        if (length < 410) {
            svgInnerDrawing.addRect(length - 8, 33, 200, 15);

        } else {
            while (stolpe <= length) {
                svgInnerDrawing.addRect(stolpe, 33, 200, 15);
                stolpe += 300;

            }
            if(length-stolpe >=-150){
                svgInnerDrawing.addRect(length-15, 33, 200, 15);
            }
        }

        svgInnerDrawing.addRect(0,25,10,length);
        svgInnerDrawing.addRect(0,15,10,length);

        return generateSVG;

    }

    /*
    public static SVGDrawing drawCarportfladtTopView(double length, double width) {




        return svg;
    }*/
}

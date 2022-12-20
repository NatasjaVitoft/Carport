package dat.backend.model.services;

public class HelpFunction {


    public static SVGDrawing createNewSVG(int x, int y, int height, int width, String viewbox) {
        return new SVGDrawing(height, width, viewbox, x, y);
    }

    public static SVGDrawing addBeams(SVGDrawing svg, int height, int width) {

        int rafter = 0;

        while (rafter <= height) {
            svg.addRect(rafter, 0, height, 4);
            rafter = rafter + 55;

            System.out.println("tjek lige rafter: " + rafter);

        }

        /*for (int i = 0; i < 800; i += 50) {
            svg.addRect(i, 0, height, 4.5);
        }*/
        return svg;
    }

    public static SVGDrawing addLine(SVGDrawing svg, int height, int width) {

        svg.addLine(0,220,height,220);

        return svg;
    }

    public static SVGDrawing addPole(SVGDrawing svg, int height, int width) {

        int pole = 108;

        if (height < 410) {
            svg.addRect(height - 8, 33, 200, 15);
            System.out.println("kommer vi herind?" + height);
        } else {
            while (pole <= height) {
                svg.addRect(pole, 33, 200, 15);
                pole += 300;
                System.out.println("kommer vi herind1?" + pole);
            }
            if (height - pole >= -150) {
                svg.addRect(height - 15, 33, 200, 15);
                System.out.println("kommer vi herind2?" + height);
            }
        }

        return svg;
    }


}

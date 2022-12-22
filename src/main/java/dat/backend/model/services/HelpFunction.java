package dat.backend.model.services;

public class HelpFunction {

    public static SVGDrawing createNewSVG(int x, int y, int height, int width, String viewbox) {
        return new SVGDrawing(height, width, viewbox, x, y);
    }

    public static SVGDrawing addRafter(SVGDrawing svg, int length, int width) {

        //int additionalRafter1 = width - 600; (DET HER SKAL VI HAVE IND I CALCULATOR
        int rafter = 0;

        while (rafter <= length) {
            svg.addRect(rafter, 0, width, 4.5);
            rafter = rafter + 55;
        }
        return svg;
    }

    public static SVGDrawing addLine(SVGDrawing svg, int x1, int x2, int y1, int y2) {
        svg.addLine(x1, y1, x2, y2);
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

    public static SVGDrawing addPost(SVGDrawing svg, int length, int width) {
        int post = 120;
        while (post <= length-120) {
            svg.addRect(post, 10, 10, 10);
            post = post += 300;
        }
        return svg;
    }

    public static SVGDrawing addStrap1 (SVGDrawing svg, int length, int width) {
        svg.addRect(0, 30, 5, length);
        return svg;
    }

    public static SVGDrawing addStrap2 (SVGDrawing svg, int length, int width) {
        int y = width-30;
        svg.addRect(0, y, 5, length);
        return svg;
    }
    public static SVGDrawing addArrows (SVGDrawing svg, int x1, int x2, int y1, int y2) {
        svg.addArrows(x1, x2, y1, y2);
        return svg;
    }

    public static SVGDrawing addDashedLines (SVGDrawing svg, int length, int width) {
        svg.addDashedLine(10, 10);
        // noget med width minus det som er tilovers i siderne
        return svg;
    }
}

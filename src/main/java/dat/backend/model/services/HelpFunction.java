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

    public static SVGDrawing addPost(SVGDrawing svg, int length, int width) {
        int post = 110;
        while (post <= length) {
            svg.addRect(post, 25, 10, 10);
            svg.addRect(post, width-25, 10, 10);
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
        double d;
        d = Math.sqrt(Math.pow(width,2)+Math.pow(length,2));
        svg.addDashedLine(10, 10, d);
        // noget med width minus det som er tilovers i siderne
        return svg;
    }

    public static SVGDrawing addShed (SVGDrawing svg, int length, int width, int shedwidth, int shedlength) {
        svg.addRect(length - shedlength, 35, shedwidth, shedlength);
        return svg;
    }

    public static SVGDrawing addPostToShed (SVGDrawing svg, int length, int width, int shedwidth, int shedlength) {
            svg.addRect(length-shedlength, 30, 10, 10);
            svg.addRect(length, 30, 10, 10);
            svg.addRect(length-shedlength, shedwidth/2, 10, 10);
            svg.addRect(length, shedwidth/2, 10, 10);
            svg.addRect(length-shedlength, shedwidth, 10, 10);
            svg.addRect(length, shedwidth, 10, 10);
        return svg;
    }
}

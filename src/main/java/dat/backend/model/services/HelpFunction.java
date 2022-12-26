package dat.backend.model.services;

import dat.backend.model.persistence.ConnectionPool;

public class HelpFunction {


    public static SVGDrawing createNewSVG(int x, int y, int height, int width, String viewbox) {
        return new SVGDrawing(height, width, viewbox, x, y);
    }

    public static SVGDrawing addRafter(SVGDrawing svg, SVGDrawing svg2, int length, int width) {

        //int additionalRafter1 = width - 600; (DET HER SKAL VI HAVE IND I CALCULATOR

        int rafter1 = (int) Math.ceil(length / 55);

        int rafter2 = length / rafter1;

        int rafter = 0;

        while (rafter <= length) {
            svg2.addRect(rafter, 0, width, 4.5);
            svg.addSVG(svg2);
            rafter = rafter + rafter2;
        }
        return svg;
    }

    public static SVGDrawing addPost(SVGDrawing svg, SVGDrawing svg2, int length, int width) {
        int post = 110;
        while (post <= length) {
            svg2.addRect(post, 28, 10, 10);
            svg2.addRect(post, width-30, 10, 10);
            post = post += 300;
            svg.addSVG(svg2);
        }
        return svg;
    }

    public static SVGDrawing addStrap1 (SVGDrawing svg, SVGDrawing svg2, int length, int width) {
        svg2.addRect(0, 30, 5, length);
        svg.addSVG(svg2);
        return svg;
    }

    public static SVGDrawing addStrap2 (SVGDrawing svg, SVGDrawing svg2, int length, int width) {
        int y = width-30;
        svg2.addRect(0, y, 5, length);
        svg.addSVG(svg2);
        return svg;
    }
    public static SVGDrawing addArrows (SVGDrawing svg, int x1, int x2, int y1, int y2) {
        svg.addArrows(x1, x2, y1, y2);
        return svg;
    }

    public static SVGDrawing addDashedLines (SVGDrawing svg, int length, int width, int shedwidth, int shedlength) {
        double d;
        d = Math.sqrt(Math.pow(width,2)+Math.pow(length,2));

        if(shedlength==0 && shedwidth==0) {
            svg.addLine(0, 35, length, width - 35);
            svg.addLine(length, 35, 0, width-35);
        } else {
            svg.addLine(0, 35, length - shedlength, width-35);
            svg.addLine(length - shedlength, 35, 0, width-35);
        }
        // noget med width minus det som er tilovers i siderne
        return svg;
    }

    public static SVGDrawing addShed (SVGDrawing svg, int length, int width, int shedwidth, int shedlength) {
        svg.addRect(length - shedlength, 35, shedwidth-35, shedlength);
        return svg;
    }

    public static SVGDrawing addPostToShed (SVGDrawing svg, SVGDrawing svg2, int length, int width, int shedwidth, int shedlength) {
            svg2.addRect(length-shedlength, 30, 10, 10);
            svg2.addRect(length, 30, 10, 10);
            svg2.addRect(length-shedlength, shedwidth/2, 10, 10);
            svg2.addRect(length, shedwidth/2, 10, 10);
            svg2.addRect(length-shedlength, shedwidth, 10, 10);
            svg2.addRect(length, shedwidth, 10, 10);
            svg.addSVG(svg2);
        return svg;
    }
}

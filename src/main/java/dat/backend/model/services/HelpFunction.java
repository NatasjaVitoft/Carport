package dat.backend.model.services;

public class HelpFunction {

    public static SVGDrawing createNewSVG(int x, int y, int height, int width, String viewbox) {
        return new SVGDrawing(height,  width, viewbox, x, y);
    }

    public static SVGDrawing addBeams(SVGDrawing svg, int height, int width) {
        for (int i = 0; i < 800; i += 50) {
            svg.addRect(i, 0, height, 4.5);
        }
        return svg;
    }

}

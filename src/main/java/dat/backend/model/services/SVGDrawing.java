package dat.backend.model.services;

public class SVGDrawing {


    private int height;
    private int width;
    private String viewbox;
    private String svgString = "";

    private final static String HEADERTEMPLATE =
            "<svg height=\"%d%%\" width=\"%d%%\" viewBox=\"%s\" preserveAspectRatio=\"xMinYmin\">";

    private final static String RECTTEMPLATE =
            "<rect x=\"%d\" y=\"%d\" height=\"%f\" width=\"%f\" style=\"stroke:#000000; fill: #ffffff\" />";

    public SVGDrawing(int height, int width, String viewbox) {
        svgString += String.format(HEADERTEMPLATE, height, width, viewbox);
        this.height = height;
        this.width = width;
        this.viewbox = viewbox;
    }

    public String toString() {
        return svgString + "</svg>";
    }

    public void addRect(int x, int y, double height, double width) {
        svgString += String.format(RECTTEMPLATE, x, y, height, width);
    }

    public void addLine(int x1, int y1, int x2, int y2) {

    }

    public void addInnerSVG(SVGDrawing innerSVGDrawing) {

    }
}

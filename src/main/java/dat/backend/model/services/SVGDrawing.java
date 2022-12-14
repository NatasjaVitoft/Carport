package dat.backend.model.services;

public class SVGDrawing {

    private int x;
    private int y;
    private int height;
    private int width;
    private String viewbox;
    private StringBuilder svgString = new StringBuilder();

    private final static String HEADERTEMPLATE =
            "<svg x=\"%d\" y=\"%d\" height=\"%d%%\" width=\"%d%%\" viewBox=\"%s\" preserveAspectRatio=\"xMinYMin\">";
    private final static String RECTTEMPLATE =
            "<rect x=\"%d\" y=\"%d\" height=\"%f\" width=\"%f\" style=\"stroke:#000000; fill: #ffffff\" />";
    private final static String ARROWHEADSTEMPLATE = "<defs>\n" +
            "        <marker id=\"beginArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"0\" refY=\"6\" orient=\"auto\">\n" +
            "            <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />\n" +
            "        </marker>\n" +
            "        <marker id=\"endArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"12\" refY=\"6\" orient=\"auto\">\n" +
            "            <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" />\n" +
            "        </marker>\n" +
            "    </defs>";
    private final static String LINETEMPLATE =
            "<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" style=\"stroke:#000000;\"/>";

    private final static String ARROWTEMPLATE = "<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" style=\"stroke:#000000;\n" +
            "marker-start: url(#beginArrow);\n" + "marker-end: url(#endArrow);\"/>\n";

    private final static String TEXTTEMPLATE = "<text x=\"%d\" y=\"%d\" fill=\"black\" transform=\"rotate(%d %d,%d)\"> %d </text>\n";

    public void addArrowsDefs() {
        String defs = " <defs>\n" +
                "        <marker id=\"beginArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"0\" refY=\"6\" orient=\"auto\">\n" +
                "            <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\"/>\n" +
                "        </marker>\n" +

                "        <marker id=\"endArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"12\" refY=\"6\" orient=\"auto\">\n" +
                "            <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\"/>\n" +
                "        </marker>\n" +
                "    </defs>";

        svgString.append(String.format(defs));
    }


    public SVGDrawing(int height, int width, String viewbox, int x, int y) {
        svgString.append(String.format(HEADERTEMPLATE, x, y, height, width, viewbox));
        this.height = height;
        this.width = width;
        this.viewbox = viewbox;
        this.x = x;
        this.y = y;
    }

    public void addRect(int x, int y, double height, double width) {
        svgString.append(String.format(RECTTEMPLATE, x, y, height, width));
    }

    public void addLine(int x1, int y1, int x2, int y2) {
        svgString.append(String.format(LINETEMPLATE, x1, y1, x2, y2));
    }

    public void addSVG(SVGDrawing svg) {
        svgString.append(svg);
    }

    public void addArrows(int x1, int y1, int x2, int y2) {

        svgString.append(String.format(ARROWTEMPLATE, x1, y1, x2, y2));
    }

    public void addText (int x, int y) {
        svgString.append(String.format(TEXTTEMPLATE, x, y, 0, 0, 0, 55));
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String toString() {
        return svgString + "</svg>";
    }
}

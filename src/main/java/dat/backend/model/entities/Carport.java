package dat.backend.model.entities;

public class Carport {

    private int stolpe;
    private int rem;
    private int spær;
    private int tagplade;
    private int lægte;
    private int brædt;

    public Carport(int stolpe, int rem, int spær, int tagplade, int lægte, int brædt) {
        this.stolpe = stolpe;
        this.rem = rem;
        this.spær = spær;
        this.tagplade = tagplade;
        this.lægte = lægte;
        this.brædt = brædt;
    }

    public int getStolpe() {
        return stolpe;
    }

    public int getRem() {
        return rem;
    }

    public int getSpær() {
        return spær;
    }

    public int getTagplade() {
        return tagplade;
    }

    public int getLægte() {
        return lægte;
    }

    public int getBrædt() {
        return brædt;
    }
}

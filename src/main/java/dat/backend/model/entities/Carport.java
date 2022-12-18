package dat.backend.model.entities;

public class Carport {

    // fields

    int ID;
    int height;
    int length;

    // constructor

    public Carport(int height, int length) {
        this.height = height;
        this.length = length;
    }

    public Carport(int ID, int height, int length) {
        this.ID = ID;
        this.height = height;
        this.length = length;
    }

    // methods

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}

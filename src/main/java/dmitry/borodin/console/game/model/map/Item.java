package dmitry.borodin.console.game.model.map;

import dmitry.borodin.console.game.utils.Coord;

public class Item extends ExplorableObject {

    private static final long serialVersionUID = 4L;            //Default serial version uid
    private int type;
    private Coord coord;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }
}

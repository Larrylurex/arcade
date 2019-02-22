package dmitry.borodin.console.game.model.map;

import dmitry.borodin.console.game.utils.Coord;

public class Enemy extends ExplorableObject {

    private static final long serialVersionUID = 4L;            //Default serial version uid
    private Coord coord;
    private int level;
    private int type;


    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

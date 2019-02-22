package dmitry.borodin.console.game.model.map;

import dmitry.borodin.console.game.utils.Coord;

import java.util.List;

public class Room extends ExplorableObject {

    private Coord upperLeft;
    private Coord lowerRight;
    private List<Coord> doors;

    private boolean opened;

    public Coord getUpperLeft() {
        return upperLeft;
    }

    public void setUpperLeft(Coord upperLeft) {
        this.upperLeft = upperLeft;
    }

    public Coord getLowerRight() {
        return lowerRight;
    }

    public void setLowerRight(Coord lowerRight) {
        this.lowerRight = lowerRight;
    }

    public List<Coord> getDoors() {
        return doors;
    }

    public void setDoors(List<Coord> doors) {
        this.doors = doors;
    }

}

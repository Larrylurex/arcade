package dmitry.borodin.console.game.model.map;

import dmitry.borodin.console.game.utils.Coord;

public class Portal extends ExplorableObject {

    private Coord coord;

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }
}

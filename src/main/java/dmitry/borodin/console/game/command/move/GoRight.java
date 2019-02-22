package dmitry.borodin.console.game.command.move;

import dmitry.borodin.console.game.utils.Coord;

public class GoRight extends CommonMoveCommand {

    @Override
    protected Coord getNewCoords(Coord coords) {
        return new Coord(coords.getX() + 1, coords.getY());
    }

    @Override
    protected int getExploreLeft() {
        return 2;
    }

    @Override
    protected int getExploreRight() {
        return 6;
    }

    @Override
    protected int getExploreUp() {
        return 2;
    }

    @Override
    protected int getExploreDown() {
        return 3;
    }

}

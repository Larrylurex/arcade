package dmitry.borodin.console.game.command.move;

import dmitry.borodin.console.game.utils.Coord;

public class GoUp extends CommonMoveCommand {

    @Override
    protected Coord getNewCoords(Coord coords) {
        return new Coord(coords.getX(), coords.getY() - 1);
    }

    @Override
    protected int getExploreLeft() {
        return 3;
    }

    @Override
    protected int getExploreRight() {
        return 4;
    }

    @Override
    protected int getExploreUp() {
        return 3;
    }

    @Override
    protected int getExploreDown() {
        return 3;
    }


}

package dmitry.borodin.console.game.command.move;

import dmitry.borodin.console.game.Settings;
import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.command.CommonCommand;
import dmitry.borodin.console.game.model.GameContext;
import dmitry.borodin.console.game.model.map.*;
import dmitry.borodin.console.game.utils.Coord;

import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public abstract class CommonMoveCommand extends CommonCommand<GameContext> {

    @Override
    public void doApply(GameContext context) {
        Coord coords = context.getPlayer().getCoord();
        Coord newCoords = getNewCoords(coords);
        boolean mayMove = beforeMove(context, newCoords);
        if (mayMove) {
            context.getPlayer().setCoord(newCoords);
            afterMove(context, newCoords);
        }
    }

    protected abstract Coord getNewCoords(Coord coords);

    private boolean beforeMove(GameContext context, Coord newCoords) {
        boolean goIntoWall = context.getRooms().stream()
                .filter(room -> checkCoordIsWall(room, newCoords))
                .anyMatch(room -> !checkDoor(room, newCoords));

        boolean goIntoEnemy = context.getEnemies().stream()
                .filter(e -> !e.isUsed())
                .map(Enemy::getCoord)
                .anyMatch(eC -> eC.equals(newCoords));

        boolean goOutOfScreen = newCoords.getX() < 1 || newCoords.getX() > Settings.TOTAL_WIDTH - 2 ||
                newCoords.getY() < 1 || newCoords.getY() > Settings.MAIN_BOARD_HEIGHT - 2;

        return !(goIntoEnemy || goIntoWall || goOutOfScreen);
    }

    private boolean checkCoordIsWall(Room room, Coord newCoords) {
        Coord upperLeft = room.getUpperLeft();
        Coord lowerRight = room.getLowerRight();

        return (((newCoords.getY() == upperLeft.getY() || newCoords.getY() == lowerRight.getY() - 1) &&
                (newCoords.getX() >= upperLeft.getX() && newCoords.getX() < lowerRight.getX())) ||
                (((newCoords.getX() == upperLeft.getX() || newCoords.getX() == lowerRight.getX() - 1) &&
                        (newCoords.getY() >= upperLeft.getY() && newCoords.getY() < lowerRight.getY()))));
    }

    private boolean checkDoor(Room room, Coord newCoord) {
        return room.getDoors()
                .stream()
                .map(d -> new Coord(d.getX() + room.getUpperLeft().getX(), d.getY() + room.getUpperLeft().getY()))
                .anyMatch(d -> d.equals(newCoord));
    }

    private void afterMove(GameContext context, Coord newCoords) {
        cleanContext(context);
        explore(context, newCoords);
        collect(context, newCoords);
    }

    private void explore(GameContext context, Coord newCoords) {
        char[][] map = context.getMap();
        int upperBound = newCoords.getY() - getExploreUp();
        int lowerBound = newCoords.getY() + getExploreDown();
        int leftBound = newCoords.getX() - getExploreLeft();
        int rightBound = newCoords.getX() + getExploreRight();

        for (int y = upperBound; y < lowerBound; y++) {
            for (int x = leftBound; x < rightBound; x++) {
                if ((y >= 0 && y < map.length) && (x >= 0 && x < map[y].length)) {
                    Coord expCoord = new Coord(x, y);
                    showEnemies(context, expCoord);
                    showItems(context, expCoord);
                    showRooms(context, expCoord);
                    showPortal(context, expCoord);

                    if (y > upperBound && y < lowerBound - 1 && x > leftBound && x < rightBound - 1) {
                        map[y][x] = '\u25AB';
                    }
                }
            }
        }
    }

    protected abstract int getExploreLeft();

    protected abstract int getExploreRight();

    protected abstract int getExploreUp();

    protected abstract int getExploreDown();

    private void cleanContext(GameContext context) {
        context.setItemClose(false);
        context.setEnemyClose(false);
        context.setPortalClose(false);
        context.setCloseEnemy(null);
        context.setCloseItem(null);

        context.setItems(context.getItems()
                .stream()
                .filter(i -> !i.isUsed())
                .collect(Collectors.toList()));
        context.setEnemies(context.getEnemies()
                .stream()
                .filter(i -> !i.isUsed())
                .collect(Collectors.toList()));
    }

    private void showPortal(GameContext context, Coord expCoord) {
        Portal portal = showExplorable(Collections.singletonList(context.getPortal()), expCoord, (e, c) -> e.getCoord().equals(c));
        if (portal != null) {
            context.setPortalClose(true);
        }
    }

    private void showEnemies(GameContext context, Coord expCoord) {
        Enemy closeEnemy = showExplorable(context.getEnemies(), expCoord, (e, c) -> e.getCoord().equals(c));
        if (closeEnemy != null) {
            context.setEnemyClose(true);
            context.setCloseEnemy(closeEnemy);
        }
    }

    private void showItems(GameContext context, Coord expCoord) {
        Item closeitem = showExplorable(context.getItems(), expCoord, (e, c) -> e.getCoord().equals(c));
        if (closeitem != null) {
            context.setCloseItem(closeitem);
            context.setItemClose(true);
        }
    }

    private void showRooms(GameContext context, Coord expCoord) {
        showExplorable(context.getRooms(), expCoord, this::checkCoordIsWall);
    }

    private <T extends ExplorableObject> T showExplorable(List<T> explorables, Coord expCoord, BiPredicate<T, Coord> filter) {
        return explorables.stream()
                .filter(exp -> filter.test(exp, expCoord))
                .peek(exp -> exp.setExplored(true))
                .findAny()
                .orElse(null);
    }

    private void collect(GameContext context, Coord newCoords) {
        context.getItems()
                .stream()
                .filter(i -> i.getCoord().equals(newCoords))
                .findAny()
                .ifPresent(i -> {
                    i.setUsed(context.getPlayer().collectItem(i));
                });
    }


}

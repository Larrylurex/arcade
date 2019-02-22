package dmitry.borodin.console.game.view;

import dmitry.borodin.console.game.Settings;
import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.model.GameContext;
import dmitry.borodin.console.game.utils.Coord;
import dmitry.borodin.console.game.utils.Message;
import dmitry.borodin.console.game.utils.MessageHolder;
import dmitry.borodin.console.game.view.utils.ConsoleColors;
import dmitry.borodin.console.game.view.utils.DrawableObject;

import java.util.Collections;
import java.util.List;

public abstract class CommonView<T extends CommonContext> implements View<T> {

    protected abstract boolean isHelpRequired();

    protected abstract List<String> getHelp(T context);

    @Override
    public void display(T context) {
        clearView();
        char[][] chars = prepareView(context);
        for (char[] aChar : chars) {
            for (char anAChar : aChar) {
                System.out.print(anAChar);
            }
            System.out.println();
        }
        MessageHolder.getMessages().forEach(m -> {
            String color = m.getType() == Message.Type.ERROR ? ConsoleColors.RED : ConsoleColors.GREEN;
            System.out.println(color + m.getMessage() + ConsoleColors.RESET);
        });
        System.out.print("Print command: ");
    }

    private void clearView() {
        System.out.print("\033\143");
    }

    private char[][] prepareView(T context) {
        int helpHeight = isHelpRequired() ? getHelp(context).size() + 3 : 0;
        int totalHeight = Settings.MAIN_BOARD_HEIGHT + helpHeight;
        char[][] map = new char[totalHeight][Settings.TOTAL_WIDTH];
        addBackGround(map, context, totalHeight);
        addMainBoard(map, context);
        addHelp(map, context, totalHeight);
        return map;
    }

    protected void addBackGround(char[][] map, T context, int totalHeight) {
        char [] [] EMPTY_BG = new char[totalHeight][Settings.TOTAL_WIDTH];
        for (int y = 0; y < EMPTY_BG.length; y++) {
            for (int x = 0; x < EMPTY_BG[y].length; x++) {
                EMPTY_BG[y][x] = ' ';
            }
        }
        System.arraycopy(EMPTY_BG, 0, map, 0, EMPTY_BG.length);
    }

    private void addMainBoard(char[][] map, T context) {
        List<DrawableObject> objects = getMainDrawableObjects(context);
        addMainBorder(map);
        fillContent(map,
                objects,
                new Coord(1, 1),
                new Coord(Settings.TOTAL_WIDTH - 1, Settings.MAIN_BOARD_HEIGHT - 1));
    }



    protected abstract List<DrawableObject> getMainDrawableObjects(T context);

    private void addHelp(char[][] map, T context, int totalHeight) {
        if (isHelpRequired()) {
            List<DrawableObject> helpObjects = convertHelpToDrawable(getHelp(context));
            addHelpBorder(map, totalHeight);
            fillContent(map, helpObjects,
                    new Coord(1, Settings.MAIN_BOARD_HEIGHT),
                    new Coord(Settings.TOTAL_WIDTH - 1, totalHeight - 1));
        }
    }

    private List<DrawableObject> convertHelpToDrawable(List<String> help) {
        char[][] content = help.stream()
                .map(String::toCharArray)
                .toArray(char[][]::new);
        DrawableObject helpObject = new DrawableObject(
                1,
                Settings.MAIN_BOARD_HEIGHT + 1,
                content
        );
        return Collections.singletonList(helpObject);
    }

    private void fillContent(char[][] map, List<DrawableObject> objects, Coord begin, Coord end) {
        for (int y = begin.getY(), innerY = 0; y < end.getY(); y++, innerY++) {
            for (int x = begin.getX(), innerX = 0; x < end.getX(); x++, innerX++) {
                int cX = x;
                int cY = y;

                objects.forEach(obj -> {
                    if (inRange(cY, obj.getY(), obj.getHeight()) &&
                            inRange(cX, obj.getX(), obj.getRowWidth(cY - obj.getY()))) {
                        map[cY][cX] = obj.getContent()[cY - obj.getY()][cX - obj.getX()];
                    }
                });
            }
        }
    }

    private boolean inRange(int number, int rangeStart, int rangeEnd) {
        return number >= rangeStart && number <= rangeEnd;
    }

    private void addMainBorder(char[][] map) {
        addBorder(map,
                new Coord(0, 0),
                new Coord(Settings.TOTAL_WIDTH, Settings.MAIN_BOARD_HEIGHT),
                '\u2550',
                '\u2550',
                '\u2551',
                '\u2554',
                '\u2557',
                isHelpRequired() ? '\u2560' : '\u255A',
                isHelpRequired() ? '\u2563' : '\u255D');
    }

    private void addHelpBorder(char[][] map, int totalHeight) {
        addBorder(map,
                new Coord(0, Settings.MAIN_BOARD_HEIGHT),
                new Coord(Settings.TOTAL_WIDTH, totalHeight),
                ' ',
                '\u2550',
                '\u2551',
                '\u2551',
                '\u2551',
                '\u255A',
                '\u255D');
    }

    protected void addBorder(char[][] map, Coord start, Coord end,
                             char up,
                             char down,
                             char side,
                             char upperLeft,
                             char upperRight,
                             char lowerLeft,
                             char lowerRight) {
        for (int y = start.getY(); y < end.getY() - 1; y++) {
            map[y][start.getX()] = side;
            map[y][end.getX() - 1] = side;
        }
        for (int x = start.getX(); x < end.getX() - 1; x++) {
            map[start.getY()][x] = up;
            map[end.getY() - 1][x] = down;
        }
        map[start.getY()][start.getX()] = upperLeft;
        map[start.getY()][end.getX() - 1] = upperRight;
        map[end.getY() - 1][start.getX()] = lowerLeft;
        map[end.getY() - 1][end.getX() - 1] = lowerRight;
    }

}

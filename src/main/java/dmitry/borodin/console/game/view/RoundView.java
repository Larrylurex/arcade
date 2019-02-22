package dmitry.borodin.console.game.view;

import dmitry.borodin.console.game.Settings;
import dmitry.borodin.console.game.model.GameContext;
import dmitry.borodin.console.game.model.map.*;
import dmitry.borodin.console.game.utils.Coord;
import dmitry.borodin.console.game.utils.ResourceUtils;
import dmitry.borodin.console.game.view.utils.DrawableObject;
import dmitry.borodin.console.game.view.utils.DrawingUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RoundView extends CommonView<GameContext> {

    private static final List<String> HELP = Arrays.asList(
            "Press a, w, s, d - to move",
            "Press m - to open game menu"
    );
    private final char[] ITEM_CHARS;
    private final char[] ENEMY_CHARS;
    private final char[] PLAYER_CHARS;
    private final char ROOM = '\u25AA';
    private final char PORTAL = '\u2617';

    public RoundView() {
        PLAYER_CHARS = ResourceUtils.readResourceAsArray("images/pl_char.txt")[0];
        ITEM_CHARS = ResourceUtils.readResourceAsArray("images/item_char.txt")[0];
        ENEMY_CHARS = ResourceUtils.readResourceAsArray("images/enemy_char.txt")[0];

    }

    @Override
    protected boolean isHelpRequired() {
        return true;
    }

    @Override
    protected List<String> getHelp(GameContext context) {
        List<String> help = new ArrayList<>();
        if (context.isEnemyClose() && !context.getCloseEnemy().isUsed()) {
            help.add("Fire monster is next to you, fight or run!");
            help.add("Press f - to fight!");
        }
        if (context.isItemClose()) {
            String itemName = context.getCloseItem().getType() == 0 ? "Snowflake" : "Heart";
            help.add(itemName +" is close, get it!");
        }
        if (context.isPortalClose()) {
            if(context.isPortalOpened()){
                help.add("Here's a portal, you can go to the next round!");
                help.add("Press n - to go through portal!");
            } else {
                help.add("Here's a portal, but you need to collect 3 " + ITEM_CHARS[0] + " before you can go in");
            }

        }
        help.addAll(HELP);
        return help;
    }

    @Override
    protected List<DrawableObject> getMainDrawableObjects(GameContext context) {
        DrawableObject hudLayer = getHudLayer(context.getPlayer());
        DrawableObject player = getPlayer(context.getPlayer());

        List<DrawableObject> portal = getExplorable(Collections.singletonList(context.getPortal()), this::convertPortalToDrawableObject);
        List<DrawableObject> rooms = getExplorable(context.getRooms(), this::convertRoomToDrawableObject);
        List<DrawableObject> items = getExplorable(context.getItems(), this::convertItemToDrawableObject);
        List<DrawableObject> enemies = getExplorable(context.getEnemies(), this::convertEnemyToDrawableObject);

        List<DrawableObject> objects = new ArrayList<>();
        objects.add(hudLayer);
        objects.addAll(rooms);
        objects.addAll(items);
        objects.addAll(enemies);
        objects.addAll(portal);
        objects.add(player);
        return objects;
    }

    private DrawableObject getHudLayer(Player player) {
        StringBuilder hud = new StringBuilder();
        Map<Integer, Long> groupedItems = player.getItems()
                .stream()
                .collect(Collectors.groupingBy(Item::getType, Collectors.counting()));

        for(int i = 0; i < Settings.ITEM_TYPES; i ++) {
            hud.append(ITEM_CHARS[i])
                    .append(" x ")
                    .append(groupedItems.getOrDefault(i, 0L))
                    .append("   ");
        }
        hud.append("Level")
                .append(" - ")
                .append(player.getLevel());

        char[][] content = new char[][]{hud.toString().toCharArray()};

        return new DrawableObject(2, 1, content);
    }

    @Override
    protected void addBackGround(char[][] map, GameContext context, int totalHeight) {
        super.addBackGround(map, context, totalHeight);
        DrawingUtils.copyArray(context.getMap(), map);
    }

    private DrawableObject getPlayer(Player player) {
        char[][] content = new char[][]{{PLAYER_CHARS[player.getType()]}};
        return new DrawableObject(player.getCoord().getX(), player.getCoord().getY(), content);
    }

    private DrawableObject convertRoomToDrawableObject(Room room) {
        int height = room.getLowerRight().getY() - room.getUpperLeft().getY();
        int width = room.getLowerRight().getX() - room.getUpperLeft().getX();

        char[][] content = new char[height][width];
        for (int y = 0; y < content.length; y++) {
            for (int x = 0; x < content[y].length; x++) {
                content[y][x] = ROOM;
            }
        }
        addBorder(content,
                new Coord(0, 0),
                new Coord(width, height),
                '\u2501',
                '\u2501',
                '\u2503',
                '\u250F',
                '\u2513',
                '\u2517',
                '\u251B');

        room.getDoors().forEach(d -> addDoor(content, d));
        return new DrawableObject(room.getUpperLeft().getX(), room.getUpperLeft().getY(), content);
    }

    private void addDoor(char[][] room, Coord door) {
        room[door.getY()][door.getX()] = ' ';
    }

    private DrawableObject convertItemToDrawableObject(Item item) {
        return new DrawableObject(item.getCoord().getX(), item.getCoord().getY(), new char[][]{{ITEM_CHARS[item.getType()]}});
    }

    private DrawableObject convertEnemyToDrawableObject(Enemy enemy) {
        return new DrawableObject(enemy.getCoord().getX(), enemy.getCoord().getY(), new char[][]{{ENEMY_CHARS[enemy.getType()]}});
    }

    private DrawableObject convertPortalToDrawableObject(Portal portal) {
        return new DrawableObject(portal.getCoord().getX(), portal.getCoord().getY(), new char[][]{{PORTAL}});
    }

    private <T extends ExplorableObject> List<DrawableObject> getExplorable(List<T> explorables,
                                                                            Function<T, DrawableObject> converter) {
        return explorables.stream()
                .filter(ExplorableObject::isExplored)
                .filter(e -> !e.isUsed())
                .map(converter)
                .collect(Collectors.toList());
    }

}

package dmitry.borodin.console.game.command.move;

import dmitry.borodin.console.game.Settings;
import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.model.GameContext;
import dmitry.borodin.console.game.model.map.*;
import dmitry.borodin.console.game.utils.Coord;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GoRightTest extends CommonMoveCommandTest{

    private GoRight command = new GoRight();

    @Test
    public void checkCoordsChanged() {
        GameContext context = getGameContext();
        context.getPlayer().setCoord(new Coord(2, 2));
        command.apply(context);
        Assert.assertEquals("Coords should be changed" , new Coord(3,2), context.getPlayer().getCoord());
    }

    @Test
    public void checkCoordsNotChanged() {
        checkCoordsNotChanged(Arrays.asList(
                new Coord(69,7), // Room Wall
                new Coord(69,3), // Enemy
                new Coord(Settings.TOTAL_WIDTH - 2,7)  // Out of screen

        ));
    }

    @Test
    public void checkExploreItemSnowflake() {
        checkExplore(new Coord(63, 25), GameContext::getItems);
    }

    @Test
    public void checkExploreItemHeart() {
        checkExplore(new Coord(63, 20), GameContext::getItems);
    }

    @Test
    public void checkExploreEnemy() {
        checkExplore(new Coord(63, 3), GameContext::getEnemies);
    }

    @Test
    public void checkExplorePortal() {
        checkExplore(new Coord(63, 15), context -> Collections.singletonList(context.getPortal()));
    }

    @Test
    public void checkExploreRoom() {
        checkExplore(new Coord(53, 7), GameContext::getRooms);
    }

    @Test
    public void checkCollect() {
        checkCollect(new Coord(69, 25), 0);
        checkCollect(new Coord(69, 20), 1);
    }

    @Override
    protected Command<GameContext> getCommand() {
        return command;
    }

    @Override
    protected GameContext getGameContext() {

        GameContext context = new GameContext();
        context.setRound(1);
        List<Item> hearts = new ArrayList<>();
        Item heart = new Item();
        heart.setType(1);
        hearts.add(heart);
        hearts.add(heart);

        Player player = new Player();
        player.setType(0);
        player.setCoord(new Coord(80, 6));
        player.setItems(hearts);
        player.setLevel(1);

        context.setPlayer(player);

        Enemy enemy = new Enemy();
        enemy.setCoord(new Coord(70, 3));
        enemy.setType(0);
        enemy.setLevel(1);
        enemy.setExplored(false);

        context.setEnemies(Collections.singletonList(enemy));

        Room room = new Room();
        room.setUpperLeft(new Coord(70, 5));
        room.setLowerRight(new Coord(120, 10));
        room.setDoors(Collections.singletonList(new Coord(91, 9)));
        room.setExplored(false);

        context.setRooms(Collections.singletonList(room));

        Portal portal = new Portal();
        portal.setCoord(new Coord(70, 15));
        portal.setExplored(false);
        context.setPortal(portal);

        Item heart1 = new Item();
        heart1.setCoord(new Coord(70, 20));
        heart1.setType(1);
        heart1.setExplored(false);
        context.addItem(heart1);


        Item sf = new Item();
        sf.setCoord(new Coord(70, 25));
        sf.setType(0);
        sf.setExplored(false);
        context.addItem(sf);

        return context;

    }
}
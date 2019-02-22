package dmitry.borodin.console.game.command.move;

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

public class GoUpTest extends CommonMoveCommandTest{

    private GoUp command = new GoUp();

    @Test
    public void checkCoordsChanged() {
        GameContext context = getGameContext();
        context.getPlayer().setCoord(new Coord(2, 2));
        command.apply(context);
        Assert.assertEquals("Coords should be changed" , new Coord(2,1), context.getPlayer().getCoord());
    }

    @Test
    public void checkCoordsNotChanged() {
        checkCoordsNotChanged(Arrays.asList(
                new Coord(80,20), // Room Wall
                new Coord(60,21), // Enemy
                new Coord(60,1)  // Out of screen

        ));
    }

    @Test
    public void checkExploreItemSnowflake() {
        checkExplore(new Coord(30, 25), GameContext::getItems);
    }

    @Test
    public void checkExploreItemHeart() {
        checkExplore(new Coord(40, 25), GameContext::getItems);
    }

    @Test
    public void checkExploreEnemy() {
        checkExplore(new Coord(60, 25), GameContext::getEnemies);
    }

    @Test
    public void checkExplorePortal() {
        checkExplore(new Coord(50, 25), context -> Collections.singletonList(context.getPortal()));
    }

    @Test
    public void checkExploreRoom() {
        checkExplore(new Coord(70, 26), GameContext::getRooms);
    }

    @Test
    public void checkCollect() {
        checkCollect(new Coord(30, 21), 0);
        checkCollect(new Coord(40, 21), 1);
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
        enemy.setCoord(new Coord(60, 20));
        enemy.setType(0);
        enemy.setLevel(1);
        enemy.setExplored(false);

        context.setEnemies(Collections.singletonList(enemy));

        Room room = new Room();
        room.setUpperLeft(new Coord(70, 10));
        room.setLowerRight(new Coord(120, 20));
        room.setDoors(Collections.singletonList(new Coord(91, 9)));
        room.setExplored(false);

        context.setRooms(Collections.singletonList(room));

        Portal portal = new Portal();
        portal.setCoord(new Coord(50, 20));
        portal.setExplored(false);
        context.setPortal(portal);

        Item heart1 = new Item();
        heart1.setCoord(new Coord(40, 20));
        heart1.setType(1);
        heart1.setExplored(false);
        context.addItem(heart1);


        Item sf = new Item();
        sf.setCoord(new Coord(30, 20));
        sf.setType(0);
        sf.setExplored(false);
        context.addItem(sf);

        return context;

    }
}
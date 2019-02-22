package dmitry.borodin.console.game.utils;

import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.model.GameContext;
import dmitry.borodin.console.game.model.map.*;
import dmitry.borodin.console.game.view.FightView;
import dmitry.borodin.console.game.view.RoundView;
import dmitry.borodin.console.game.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ViewDisplayApp {

    public static void main(String[] args) {
        showView(getView(), getContext1());
    }

    private static <T extends CommonContext> void showView(View<T> view, T context) {
        view.display(context);
    }

    private static GameContext getContext1() {
        GameContext context = new GameContext();
        context.setRound(0);
        List<Item> hearts = new ArrayList<>();
        Item heart = new Item();
        heart.setType(1);
        hearts.add(heart);
        hearts.add(heart);
        hearts.add(heart);

        Player player = new Player();
        player.setType(0);
        player.setCoord(new Coord(90, 13));
        player.setItems(hearts);
        player.setLevel(1);

        context.setPlayer(player);

        Enemy enemy = new Enemy();
        enemy.setCoord(new Coord(111, 11));
        enemy.setType(0);
        enemy.setLevel(1);
        enemy.setExplored(true);

        Enemy enemy2 = new Enemy();
        enemy2.setCoord(new Coord(89, 25));
        enemy2.setType(0);
        enemy2.setLevel(1);
        enemy2.setExplored(true);

        Enemy enemy3 = new Enemy();
        enemy3.setCoord(new Coord(55, 12));
        enemy3.setType(0);
        enemy3.setLevel(1);
        enemy3.setExplored(true);

        Enemy enemy4 = new Enemy();
        enemy4.setCoord(new Coord(25, 25));
        enemy4.setType(0);
        enemy4.setLevel(1);
        enemy4.setExplored(true);

        context.setEnemies(Arrays.asList(enemy, enemy2, enemy3, enemy4));

        Room room = new Room();
        room.setUpperLeft(new Coord(93, 3));
        room.setLowerRight(new Coord(120, 11));
        room.setDoors(Collections.singletonList(new Coord(18, 7)));
        room.setExplored(true);

        Room room2 = new Room();
        room2.setUpperLeft(new Coord(90, 20));
        room2.setLowerRight(new Coord(120, 28));
        room2.setDoors(Collections.singletonList(new Coord(0, 5)));
        room2.setExplored(true);

        Room room3 = new Room();
        room3.setUpperLeft(new Coord(50, 13));
        room3.setLowerRight(new Coord(70, 22));
        room3.setDoors(Collections.singletonList(new Coord(5, 0)));
        room3.setExplored(true);

        Room room4 = new Room();
        room4.setUpperLeft(new Coord(10, 20));
        room4.setLowerRight(new Coord(25, 30));
        room4.setDoors(Collections.singletonList(new Coord(14, 5)));
        room4.setExplored(true);

        context.setRooms(Arrays.asList(room, room2, room3, room4));

        Portal portal = new Portal();
        portal.setCoord(new Coord(10, 3));
        portal.setExplored(true);
        context.setPortal(portal);

        Item heart1 = new Item();
        heart1.setCoord(new Coord(120, 16));
        heart1.setType(1);
        heart1.setExplored(true);
        context.addItem(heart1);

        Item heart2 = new Item();
        heart2.setCoord(new Coord(105, 24));
        heart2.setType(1);
        heart2.setExplored(true);
        context.addItem(heart2);

        Item heart3 = new Item();
        heart3.setCoord(new Coord(5, 14));
        heart3.setType(1);
        heart3.setExplored(true);
        context.addItem(heart3);

        Item sf = new Item();
        sf.setCoord(new Coord(100, 6));
        sf.setType(0);
        sf.setExplored(true);
        context.addItem(sf);

        Item sf2 = new Item();
        sf2.setCoord(new Coord(85, 4));
        sf2.setType(0);
        sf2.setExplored(true);
        context.addItem(sf2);

        Item sf3 = new Item();
        sf3.setCoord(new Coord(60, 20));
        sf3.setType(0);
        sf3.setExplored(true);
        context.addItem(sf3);

        Item sf4 = new Item();
        sf4.setCoord(new Coord(40, 29));
        sf4.setType(0);
        sf4.setExplored(true);
        context.addItem(sf4);

        Item sf5 = new Item();
        sf5.setCoord(new Coord(13, 22));
        sf5.setType(0);
        sf5.setExplored(true);
        context.addItem(sf5);

        return context;
    }

    private static GameContext getContext2() {
        GameContext context = new GameContext();
        context.setRound(1);
        List<Item> hearts = new ArrayList<>();
        Item heart = new Item();
        heart.setType(1);
        hearts.add(heart);
        hearts.add(heart);
        hearts.add(heart);

        Player player = new Player();
        player.setType(0);
        player.setCoord(new Coord(5, 3));
        player.setItems(hearts);
        player.setLevel(1);

        context.setPlayer(player);

        Enemy enemy = new Enemy();
        enemy.setCoord(new Coord(111, 11));
        enemy.setType(0);
        enemy.setLevel(1);
        enemy.setExplored(true);

        Enemy enemy2 = new Enemy();
        enemy2.setCoord(new Coord(74, 23));
        enemy2.setType(0);
        enemy2.setLevel(1);
        enemy2.setExplored(true);

        Enemy enemy3 = new Enemy();
        enemy3.setCoord(new Coord(50, 8));
        enemy3.setType(0);
        enemy3.setLevel(1);
        enemy3.setExplored(true);

        Enemy enemy4 = new Enemy();
        enemy4.setCoord(new Coord(12, 19));
        enemy4.setType(0);
        enemy4.setLevel(1);
        enemy4.setExplored(true);

        context.setEnemies(Arrays.asList(enemy, enemy2, enemy3, enemy4));

        Room room = new Room();
        room.setUpperLeft(new Coord(93, 3));
        room.setLowerRight(new Coord(120, 11));
        room.setDoors(Collections.singletonList(new Coord(18, 7)));
        room.setExplored(true);

        Room room2 = new Room();
        room2.setUpperLeft(new Coord(75, 20));
        room2.setLowerRight(new Coord(110, 28));
        room2.setDoors(Collections.singletonList(new Coord(0, 3)));
        room2.setExplored(true);

        Room room3 = new Room();
        room3.setUpperLeft(new Coord(30, 3));
        room3.setLowerRight(new Coord(50, 15));
        room3.setDoors(Collections.singletonList(new Coord(19, 5)));
        room3.setExplored(true);

        Room room4 = new Room();
        room4.setUpperLeft(new Coord(5, 20));
        room4.setLowerRight(new Coord(25, 30));
        room4.setDoors(Collections.singletonList(new Coord(7, 0)));
        room4.setExplored(true);

        context.setRooms(Arrays.asList(room, room2, room3, room4));

        Portal portal = new Portal();
        portal.setCoord(new Coord(10, 3));
        portal.setExplored(true);
        context.setPortal(portal);

        Item heart1 = new Item();
        heart1.setCoord(new Coord(120, 16));
        heart1.setType(1);
        heart1.setExplored(true);
        context.addItem(heart1);

        Item heart2 = new Item();
        heart2.setCoord(new Coord(40, 28));
        heart2.setType(1);
        heart2.setExplored(true);
        context.addItem(heart2);

        Item heart3 = new Item();
        heart3.setCoord(new Coord(2, 5));
        heart3.setType(1);
        heart3.setExplored(true);
        context.addItem(heart3);

        Item sf = new Item();
        sf.setCoord(new Coord(100, 6));
        sf.setType(0);
        sf.setExplored(true);
        context.addItem(sf);

        Item sf2 = new Item();
        sf2.setCoord(new Coord(82, 8));
        sf2.setType(0);
        sf2.setExplored(true);
        context.addItem(sf2);

        Item sf3 = new Item();
        sf3.setCoord(new Coord(80, 25));
        sf3.setType(0);
        sf3.setExplored(true);
        context.addItem(sf3);

        Item sf4 = new Item();
        sf4.setCoord(new Coord(40, 5));
        sf4.setType(0);
        sf4.setExplored(true);
        context.addItem(sf4);

        Item sf5 = new Item();
        sf5.setCoord(new Coord(22, 22));
        sf5.setType(0);
        sf5.setExplored(true);
        context.addItem(sf5);

        return context;
    }

    private static RoundView getView() {
        return new RoundView();
    }
}

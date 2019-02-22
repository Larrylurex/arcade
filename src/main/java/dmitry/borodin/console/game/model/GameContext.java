package dmitry.borodin.console.game.model;

import dmitry.borodin.console.game.Settings;
import dmitry.borodin.console.game.model.map.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameContext extends CommonContext implements Serializable {

    private static final long serialVersionUID = 4L;
    private String name;
    private int round;
    private char[][] map;
    private Player player;
    private List<Room> rooms = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private List<Enemy> enemies = new ArrayList<>();
    private Portal portal;
    private boolean portalClose;
    private boolean itemClose;
    private boolean enemyClose;
    private Enemy closeEnemy;
    private Item closeItem;


    public GameContext() {
        initMap();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public char[][] getMap() {
        return map;
    }

    public void setMap(char[][] map) {
        if(map == null || map.length == 0) {
            initMap();
        }
        this.map = map;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void setCloseEnemy(Enemy closeEnemy) {
        this.closeEnemy = closeEnemy;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public boolean isItemClose() {
        return itemClose;
    }

    public void setItemClose(boolean itemClose) {
        this.itemClose = itemClose;
    }

    public boolean isEnemyClose() {
        return enemyClose;
    }

    public void setEnemyClose(boolean enemyClose) {
        this.enemyClose = enemyClose;
    }

    public Enemy getCloseEnemy() {
        return closeEnemy;
    }

    public Portal getPortal() {
        return portal;
    }

    public void setPortal(Portal portal) {
        this.portal = portal;
    }

    public void setPortalClose(boolean portalClose) {
        this.portalClose = portalClose;
    }

    public boolean isPortalClose() {
        return portalClose;
    }

    public boolean isPortalOpened() {
        return player.getItemsOfType(0) >= Settings.KEYS_TO_COLLECT;
    }

    private void initMap() {
        map = new char[Settings.MAIN_BOARD_HEIGHT][Settings.TOTAL_WIDTH];
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                map[y][x] = ' ';
            }
        }
    }

    public Item getCloseItem() {
        return closeItem;
    }

    public void setCloseItem(Item closeItem) {
        this.closeItem = closeItem;
    }
}

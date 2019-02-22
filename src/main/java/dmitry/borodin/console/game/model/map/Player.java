package dmitry.borodin.console.game.model.map;

import dmitry.borodin.console.game.Settings;
import dmitry.borodin.console.game.utils.Coord;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Player implements Serializable {

    private static final long serialVersionUID = 4L;            //Default serial version uid
    private Coord coord;
    private int type;
    private List<Item> items = new ArrayList<>();
    private int level;

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getItemsOfType(int type) {
        return (int)items.stream()
                .filter(i -> type == i.getType())
                .count();
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public boolean collectItem(Item item) {
        int type = item.getType();
        long count = getItemsOfType(type);

        if(count < Settings.ITEM_LIMIT[type]) {
            items.add(item);
            return true;
        }
        return false;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return (int) items.stream()
                .filter(i -> i.getType() == 1)
                .count();
    }

    public void loseHealth() {
        items.stream()
                .filter(i -> i.getType() == 1)
                .findAny().
                ifPresent(i -> items.remove(i));
    }

    @Override
    public String toString() {
        return "Player{" +
                "coord=" + coord +
                ", type=" + type +
                ", items=" + items +
                ", level=" + level +
                '}';
    }
}

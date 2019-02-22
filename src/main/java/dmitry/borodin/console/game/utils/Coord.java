package dmitry.borodin.console.game.utils;

import java.io.Serializable;
import java.util.Objects;

public class Coord implements Serializable {

    private static final long serialVersionUID = 4L;            //Default serial version uid
    private int x, y;

    public Coord() {
        this(0, 0);
    }

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord coord = (Coord) o;
        return x == coord.x &&
                y == coord.y;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }
}

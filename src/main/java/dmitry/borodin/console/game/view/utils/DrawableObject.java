package dmitry.borodin.console.game.view.utils;

public class DrawableObject {

    private final int x, y;
    private final char[][] content;

    public DrawableObject(int x, int y, char[][] content) {
        this.x = x;
        this.y = y;
        this.content = content;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char[][] getContent() {
        return content;
    }

    public int getHeight() {
        return y + content.length - 1;
    }

    public int getRowWidth(int row) {
        return x + content[row].length - 1;
    }
}

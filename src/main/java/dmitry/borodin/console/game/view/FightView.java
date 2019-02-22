package dmitry.borodin.console.game.view;

import dmitry.borodin.console.game.Settings;
import dmitry.borodin.console.game.model.FightContext;
import dmitry.borodin.console.game.model.map.Enemy;
import dmitry.borodin.console.game.model.map.Player;
import dmitry.borodin.console.game.utils.ResourceUtils;
import dmitry.borodin.console.game.view.utils.DrawableObject;
import dmitry.borodin.console.game.view.utils.DrawingUtils;

import java.util.ArrayList;
import java.util.List;

public class FightView extends CommonView<FightContext> {

    @Override
    protected boolean isHelpRequired() {
        return true;
    }

    @Override
    protected List<String> getHelp(FightContext context) {
        List<String> help = new ArrayList<>();

        if (!context.isPlayerAttacked()) {
            help.add("Press a - to attack");
        } else if (!context.isFightOver()) {
            help.add("Press m - to see monster's attack");
        } else {
            help.add("Press e - exit");
        }
        return help;
    }

    @Override
    protected List<DrawableObject> getMainDrawableObjects(FightContext context) {
        List<DrawableObject> objects = new ArrayList<>();

        DrawableObject player = getPlayer(context.getPlayer());
        objects.add(player);
        DrawableObject enemy = getEnemy(context.getEnemy());
        objects.add(enemy);

        objects.add(getVS());

        int minHeight = getMinHeight(player, enemy);

        if (context.isPlayerAttacked()) {

            objects.add(getPlayerScore(context.getPlayerScore(), minHeight));
        }
        if (context.isFightOver()) {
            objects.add(getEnemyScore(context.getEnemyScore(), minHeight));
            objects.add(getWonOrLose(context.getEnemyScore(), context.getPlayerScore()));
        } else {
            int maxHeight = getMaxHeight(player, enemy);

            objects.add(getPlayerLevel(context.getPlayer().getLevel(), maxHeight));
            objects.add(getEnemyLevel(context.getEnemy().getLevel(), maxHeight));
        }
        return objects;
    }

    private int getMaxHeight(DrawableObject player, DrawableObject enemy) {
        return Math.min(player.getY(), enemy.getY());
    }

    private int getMinHeight(DrawableObject player, DrawableObject enemy) {
        return Math.max(player.getHeight(), enemy.getHeight());
    }

    private DrawableObject getPlayer(Player player) {
        String playerImg = "images/pl_" + (player.getType() + 1) + ".txt";
        char[][] content = ResourceUtils.readResourceAsArray(playerImg);
        int adjustedY = Settings.MAIN_BOARD_HEIGHT / 2 - content.length / 2;
        int adjustedX = Settings.TOTAL_WIDTH / 4 - DrawingUtils.getMaxWidth(content) / 2;
        return new DrawableObject(adjustedX, adjustedY, content);
    }

    private DrawableObject getVS() {
        char[][] content = ResourceUtils.readResourceAsArray("images/vs.txt");
        int adjustedY = Settings.MAIN_BOARD_HEIGHT / 2 - content.length / 2;
        int adjustedX = Settings.TOTAL_WIDTH / 2 - DrawingUtils.getMaxWidth(content) / 2;
        return new DrawableObject(adjustedX, adjustedY, content);
    }

    private DrawableObject getEnemy(Enemy enemy) {
        String enemyImg = "images/enemy_" + (enemy.getType() + 1) + ".txt";
        char[][] content = ResourceUtils.readResourceAsArray(enemyImg);
        int adjustedY = Settings.MAIN_BOARD_HEIGHT / 2 - content.length / 2;
        int adjustedX = 3 * Settings.TOTAL_WIDTH / 4 - DrawingUtils.getMaxWidth(content) / 2;
        return new DrawableObject(adjustedX, adjustedY, content);
    }

    private DrawableObject getEnemyLevel(int level, int maxHeight) {
        char[][] content = new char[][]{("LEVEL " + level).toCharArray()};
        int adjustedY = maxHeight - 2;
        int adjustedX = 3 * Settings.TOTAL_WIDTH / 4 - DrawingUtils.getMaxWidth(content) / 2;
        return new DrawableObject(adjustedX, adjustedY, content);
    }

    private DrawableObject getPlayerLevel(int level, int maxHeight) {
        char[][] content = new char[][]{("LEVEL " + level).toCharArray()};
        int adjustedY = maxHeight - 2;
        int adjustedX = Settings.TOTAL_WIDTH / 4 - DrawingUtils.getMaxWidth(content) / 2;
        return new DrawableObject(adjustedX, adjustedY, content);
    }

    private DrawableObject getWonOrLose(int enemyScore, int playerScore) {
        String label = enemyScore > playerScore ? "lose.txt" : "won.txt";
        char[][] content = ResourceUtils.readResourceAsArray("images/" + label);
        int adjustedY = 1;
        int adjustedX = Settings.TOTAL_WIDTH / 2 - DrawingUtils.getMaxWidth(content) / 2;
        return new DrawableObject(adjustedX, adjustedY, content);
    }

    private DrawableObject getEnemyScore(int enemyScore, int minHeight) {
        char[][] content = new char[][]{("SCORE " + enemyScore).toCharArray()};
        int adjustedY = minHeight + 2;
        int adjustedX = 3 * Settings.TOTAL_WIDTH / 4 - DrawingUtils.getMaxWidth(content) / 2;
        return new DrawableObject(adjustedX, adjustedY, content);
    }

    private DrawableObject getPlayerScore(int playerScore, int minHeight) {
        char[][] content = new char[][]{("SCORE " + playerScore).toCharArray()};
        int adjustedY = minHeight + 2;
        int adjustedX = Settings.TOTAL_WIDTH / 4 - DrawingUtils.getMaxWidth(content) / 2;
        return new DrawableObject(adjustedX, adjustedY, content);
    }
}

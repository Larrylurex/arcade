package dmitry.borodin.console.game.model;

import dmitry.borodin.console.game.model.map.Enemy;
import dmitry.borodin.console.game.model.map.Player;

public class FightContext extends ReturnContext {

    private Player player;
    private Enemy enemy;
    private boolean playerAttacked;
    private boolean fightOver;
    private int playerScore;
    private int enemyScore;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public boolean isPlayerAttacked() {
        return playerAttacked;
    }

    public void setPlayerAttacked(boolean playerAttacked) {
        this.playerAttacked = playerAttacked;
    }

    public boolean isFightOver() {
        return fightOver;
    }

    public void setFightOver(boolean fightOver) {
        this.fightOver = fightOver;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getEnemyScore() {
        return enemyScore;
    }

    public void setEnemyScore(int enemyScore) {
        this.enemyScore = enemyScore;
    }

    public boolean won() {
        return enemyScore > playerScore;
    }
}

package dmitry.borodin.console.game.command;

import dmitry.borodin.console.game.Settings;
import dmitry.borodin.console.game.model.EndGameContext;
import dmitry.borodin.console.game.model.FightContext;
import dmitry.borodin.console.game.stage.EndGame;
import dmitry.borodin.console.game.utils.MessageHolder;

import java.util.concurrent.ThreadLocalRandom;

public class MonsterAttackCommand extends CommonCommand<FightContext> {

    @Override
    protected void doApply(FightContext context) {
        if (!context.isFightOver() && context.isPlayerAttacked()) {
            int enemyScore = ThreadLocalRandom.current().nextInt(context.getEnemy().getLevel(), Settings.MAX_SCORE + 1);
            context.setEnemyScore(Math.min(enemyScore, Settings.MAX_SCORE));
            context.setFightOver(true);
            int playerScore = context.getPlayerScore();

            if (enemyScore > playerScore) {
                context.getPlayer().loseHealth();
            } else {
                context.getEnemy().setUsed(true);
                int level = context.getPlayer().getLevel();
                context.getPlayer().setLevel(level + 1);
            }
        } else {
            MessageHolder.addErrorMessage("Unknown command: m");
        }
    }
}

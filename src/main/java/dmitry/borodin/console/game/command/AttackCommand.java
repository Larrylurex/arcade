package dmitry.borodin.console.game.command;

import dmitry.borodin.console.game.Settings;
import dmitry.borodin.console.game.model.FightContext;
import dmitry.borodin.console.game.utils.MessageHolder;

import java.util.concurrent.ThreadLocalRandom;

public class AttackCommand extends CommonCommand<FightContext> {
    @Override
    protected void doApply(FightContext context) {
        if (!context.isPlayerAttacked()) {
            int playerScore = ThreadLocalRandom.current().nextInt(context.getPlayer().getLevel(), Settings.MAX_SCORE + 1);
            context.setPlayerScore(Math.min(playerScore, Settings.MAX_SCORE));
            context.setPlayerAttacked(true);
        } else {
            MessageHolder.addErrorMessage("Unknown command: a");
        }

    }
}

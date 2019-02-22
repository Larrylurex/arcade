package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.model.FightContext;
import dmitry.borodin.console.game.model.GameContext;
import dmitry.borodin.console.game.stage.Fight;
import dmitry.borodin.console.game.stage.Stage;
import dmitry.borodin.console.game.utils.MessageHolder;

public class FightCommand<T extends GameContext> extends SwitchStageCommand<T> {

    @Override
    protected void doApply(T context) {
        if (context.getCloseEnemy() != null && !context.getCloseEnemy().isUsed()) {
            super.doApply(context);
        } else {
            MessageHolder.addErrorMessage("Unknown command: f");
        }
    }

    @Override
    protected Stage getNextStage(T context) {

        FightContext fightContext = new FightContext();
        fightContext.setPlayer(context.getPlayer());
        fightContext.setEnemy(context.getCloseEnemy());
        fightContext.setPrevStage(context.getCurrentStage());
        return new Fight(fightContext);
    }
}

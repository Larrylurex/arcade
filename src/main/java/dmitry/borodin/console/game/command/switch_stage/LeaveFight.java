package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.model.EndGameContext;
import dmitry.borodin.console.game.model.FightContext;
import dmitry.borodin.console.game.stage.EndGame;
import dmitry.borodin.console.game.stage.Stage;
import dmitry.borodin.console.game.utils.MessageHolder;

public class LeaveFight extends SwitchStageCommand<FightContext> {

    @Override
    protected void doApply(FightContext context) {
        if (context.isFightOver()) {
            super.doApply(context);
        } else {
            MessageHolder.addErrorMessage("Unknown command: e");
        }
    }

    @Override
    protected Stage getNextStage(FightContext context) {
        if (context.getPlayer().getHealth() == 0) {
            context.getCurrentStage().setRunning(false);
            EndGameContext endGameContext = new EndGameContext();
            endGameContext.setSuccess(false);
            return new EndGame(endGameContext);
        } else {
            return context.getPrevStage();
        }

    }
}

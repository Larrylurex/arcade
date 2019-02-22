package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.command.CommonCommand;
import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.stage.Stage;

public abstract class SwitchStageCommand<T extends CommonContext> extends CommonCommand<T> {

    @Override
    protected void doApply(T context) {
        context.getCurrentStage().setRunning(false);
        Stage nextStage = getNextStage(context);
        nextStage.setRunning(true);
        context.setNextStage(nextStage);
    }

    protected abstract Stage getNextStage(T context);
}

package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.model.ReturnContext;
import dmitry.borodin.console.game.stage.Stage;

public class ReturnCommand<T extends ReturnContext> extends SwitchStageCommand<T> {

    @Override
    protected Stage getNextStage(T context) {
        return context.getPrevStage();
    }
}

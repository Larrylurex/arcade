package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.stage.Quit;
import dmitry.borodin.console.game.stage.Stage;

public class QuitCommand<T extends CommonContext> extends SwitchStageCommand<T> {

    @Override
    protected Stage getNextStage(T context) {
        CommonContext quitContext = new CommonContext();
        quitContext.setNextStage(null);
        context.getCurrentStage().setRunning(false);
        return new Quit(quitContext);
    }
}

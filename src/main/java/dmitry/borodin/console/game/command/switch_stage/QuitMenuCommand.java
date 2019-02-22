package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.model.ReturnContext;
import dmitry.borodin.console.game.stage.QuitMenu;
import dmitry.borodin.console.game.stage.Stage;

public class QuitMenuCommand<T extends CommonContext> extends SwitchStageCommand<T> {

    @Override
    protected Stage getNextStage(T context) {
        ReturnContext returnContext = new ReturnContext();
        returnContext.setPrevStage(context.getCurrentStage());
        return new QuitMenu(returnContext);
    }
}

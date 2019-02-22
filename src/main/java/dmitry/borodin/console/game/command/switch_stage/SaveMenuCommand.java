package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.model.ReturnableGameContext;
import dmitry.borodin.console.game.stage.SaveMenu;
import dmitry.borodin.console.game.stage.Stage;

public class SaveMenuCommand<T extends ReturnableGameContext> extends SwitchStageCommand<T> {

    @Override
    protected Stage getNextStage(T context) {
        ReturnableGameContext returnableGameContext = new ReturnableGameContext();
        returnableGameContext.setGameContext(context.getGameContext());
        returnableGameContext.setPrevStage(context.getCurrentStage());
        return new SaveMenu(returnableGameContext);
    }
}
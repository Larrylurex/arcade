package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.model.GameContext;
import dmitry.borodin.console.game.model.ReturnableGameContext;
import dmitry.borodin.console.game.stage.GameMenu;
import dmitry.borodin.console.game.stage.Stage;

public class GameMenuCommand<T extends GameContext> extends SwitchStageCommand<T> {

    @Override
    protected Stage getNextStage(T context) {
        ReturnableGameContext returnableGameContext = new ReturnableGameContext();
        returnableGameContext.setPrevStage(context.getCurrentStage());
        returnableGameContext.setGameContext(context);
        return new GameMenu(returnableGameContext);
    }
}

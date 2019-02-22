package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.stage.Stage;
import dmitry.borodin.console.game.stage.StartMenu;

public class GoToStartMenu<T extends CommonContext> extends SwitchStageCommand<T> {
    @Override
    protected Stage getNextStage(CommonContext context) {
        CommonContext newContext = new CommonContext();
        return new StartMenu(newContext);
    }
}

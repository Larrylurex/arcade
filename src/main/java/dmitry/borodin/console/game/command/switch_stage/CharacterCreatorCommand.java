package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.model.ReturnContext;
import dmitry.borodin.console.game.stage.CharacterCreator;
import dmitry.borodin.console.game.stage.Stage;

public class CharacterCreatorCommand<T extends CommonContext> extends SwitchStageCommand<T> {

    @Override
    protected Stage getNextStage(T context) {
        ReturnContext characterContext = new ReturnContext();
        characterContext.setPrevStage(context.getCurrentStage());
        return new CharacterCreator(characterContext);
    }
}

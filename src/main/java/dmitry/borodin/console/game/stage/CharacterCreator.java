package dmitry.borodin.console.game.stage;

import dmitry.borodin.console.game.command.factory.CharacterCreatorCommandFactory;
import dmitry.borodin.console.game.command.factory.CommandFactory;
import dmitry.borodin.console.game.model.ReturnContext;
import dmitry.borodin.console.game.view.CharacterCreatorView;
import dmitry.borodin.console.game.view.View;

public class CharacterCreator extends CommonStage<ReturnContext> {

    public CharacterCreator(ReturnContext context) {
        super(context);
    }

    @Override
    protected View<ReturnContext> getView() {
        return new CharacterCreatorView();
    }

    @Override
    protected CommandFactory<ReturnContext> getCommandFactory() {
        return new CharacterCreatorCommandFactory();
    }
}

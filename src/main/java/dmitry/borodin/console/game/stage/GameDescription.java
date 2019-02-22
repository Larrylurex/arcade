package dmitry.borodin.console.game.stage;

import dmitry.borodin.console.game.command.factory.CommandFactory;
import dmitry.borodin.console.game.command.factory.GameDescriptionCommandFactory;
import dmitry.borodin.console.game.model.ReturnContext;
import dmitry.borodin.console.game.view.GameDescriptionView;
import dmitry.borodin.console.game.view.View;

public class GameDescription extends CommonStage<ReturnContext> {

    public GameDescription(ReturnContext context) {
        super(context);
    }

    @Override
    protected View<ReturnContext> getView() {
        return new GameDescriptionView();
    }

    @Override
    protected CommandFactory<ReturnContext> getCommandFactory() {
        return new GameDescriptionCommandFactory();
    }
}

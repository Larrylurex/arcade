package dmitry.borodin.console.game.stage;

import dmitry.borodin.console.game.command.factory.CommandFactory;
import dmitry.borodin.console.game.command.factory.LoadGameCommandFactory;
import dmitry.borodin.console.game.model.LoadGameContext;
import dmitry.borodin.console.game.view.LoadGameView;
import dmitry.borodin.console.game.view.View;

public class LoadGame extends CommonStage<LoadGameContext> {


    public LoadGame(LoadGameContext context) {
        super(context);
    }

    @Override
    protected View<LoadGameContext> getView() {
        return new LoadGameView();
    }

    @Override
    protected CommandFactory<LoadGameContext> getCommandFactory() {
        return new LoadGameCommandFactory();
    }
}

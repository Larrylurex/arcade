package dmitry.borodin.console.game.stage;

import dmitry.borodin.console.game.command.factory.CommandFactory;
import dmitry.borodin.console.game.command.factory.GameMenuCommandFactory;
import dmitry.borodin.console.game.model.ReturnableGameContext;
import dmitry.borodin.console.game.view.GameMenuView;
import dmitry.borodin.console.game.view.View;

public class GameMenu extends CommonStage<ReturnableGameContext> {

    public GameMenu(ReturnableGameContext context) {
        super(context);
    }

    @Override
    protected View<ReturnableGameContext> getView() {
        return new GameMenuView();
    }

    @Override
    protected CommandFactory<ReturnableGameContext> getCommandFactory() {
        return new GameMenuCommandFactory();
    }
}

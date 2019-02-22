package dmitry.borodin.console.game.stage;

import dmitry.borodin.console.game.command.factory.CommandFactory;
import dmitry.borodin.console.game.command.factory.SaveMenuCommandFactory;
import dmitry.borodin.console.game.model.ReturnableGameContext;
import dmitry.borodin.console.game.view.SaveMenuView;
import dmitry.borodin.console.game.view.View;

public class SaveMenu extends CommonStage<ReturnableGameContext> {


    public SaveMenu(ReturnableGameContext context) {
        super(context);
    }

    @Override
    protected View<ReturnableGameContext> getView() {
        return new SaveMenuView();
    }

    @Override
    protected CommandFactory<ReturnableGameContext> getCommandFactory() {
        return new SaveMenuCommandFactory();
    }
}

package dmitry.borodin.console.game.stage;

import dmitry.borodin.console.game.command.factory.CommandFactory;
import dmitry.borodin.console.game.command.factory.StartMenuCommandFactory;
import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.view.StartMenuView;
import dmitry.borodin.console.game.view.View;

public class StartMenu extends CommonStage<CommonContext> {

    public StartMenu(CommonContext context) {
        super(context);
    }

    @Override
    protected View<CommonContext> getView() {
        return new StartMenuView();
    }

    @Override
    protected CommandFactory<CommonContext> getCommandFactory() {
        return new StartMenuCommandFactory();
    }
}

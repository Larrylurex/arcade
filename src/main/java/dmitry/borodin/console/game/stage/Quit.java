package dmitry.borodin.console.game.stage;

import dmitry.borodin.console.game.command.factory.CommandFactory;
import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.view.QuitView;
import dmitry.borodin.console.game.view.View;

public class Quit extends CommonStage<CommonContext> {

    public Quit(CommonContext context) {
        super(context);
    }

    @Override
    protected View<CommonContext> getView() {
        return new QuitView();
    }

    @Override
    protected CommandFactory<CommonContext> getCommandFactory() {
        return null;
    }

    @Override
    public void setRunning(boolean running) {
        super.setRunning(false);
    }
}

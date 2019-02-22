package dmitry.borodin.console.game.stage;

import dmitry.borodin.console.game.command.factory.CommandFactory;
import dmitry.borodin.console.game.command.factory.RoundCommandFactory;
import dmitry.borodin.console.game.model.GameContext;
import dmitry.borodin.console.game.view.RoundView;
import dmitry.borodin.console.game.view.View;

public class Round extends CommonStage<GameContext> {


    public Round(GameContext context) {
        super(context);
    }

    @Override
    protected View<GameContext> getView() {
        return new RoundView();
    }

    @Override
    protected CommandFactory<GameContext> getCommandFactory() {
        return new RoundCommandFactory();
    }
}

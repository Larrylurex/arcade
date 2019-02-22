package dmitry.borodin.console.game.stage;

import dmitry.borodin.console.game.command.factory.CommandFactory;
import dmitry.borodin.console.game.command.factory.EndGameCommandFactory;
import dmitry.borodin.console.game.model.EndGameContext;
import dmitry.borodin.console.game.view.EndGameView;
import dmitry.borodin.console.game.view.View;

public class EndGame extends CommonStage<EndGameContext> {

    public EndGame(EndGameContext context) {
        super(context);
    }

    @Override
    protected View<EndGameContext> getView() {
        return new EndGameView();
    }

    @Override
    protected CommandFactory<EndGameContext> getCommandFactory() {
        return new EndGameCommandFactory();
    }
}

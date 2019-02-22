package dmitry.borodin.console.game.stage;

import dmitry.borodin.console.game.command.factory.CommandFactory;
import dmitry.borodin.console.game.command.factory.FightCommandFactory;
import dmitry.borodin.console.game.model.FightContext;
import dmitry.borodin.console.game.view.FightView;
import dmitry.borodin.console.game.view.View;

public class Fight extends CommonStage<FightContext> {
    public Fight(FightContext context) {
        super(context);
    }

    @Override
    protected View<FightContext> getView() {
        return new FightView();
    }

    @Override
    protected CommandFactory<FightContext> getCommandFactory() {
        return new FightCommandFactory();
    }
}

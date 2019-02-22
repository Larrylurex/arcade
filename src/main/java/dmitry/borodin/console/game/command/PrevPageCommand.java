package dmitry.borodin.console.game.command;

import dmitry.borodin.console.game.model.LoadGameContext;

public class PrevPageCommand extends CommonCommand<LoadGameContext> {
    @Override
    protected void doApply(LoadGameContext context) {
        context.prevPage();
    }
}

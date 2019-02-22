package dmitry.borodin.console.game.command;

import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.utils.MessageHolder;

public abstract class CommonCommand<T extends CommonContext> implements Command<T> {

    @Override
    public void apply(T context) {
        MessageHolder.eraseErrors();
        doApply(context);
    }

    protected abstract void doApply(T context);
}

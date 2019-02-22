package dmitry.borodin.console.game.command;

import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.utils.MessageHolder;

public class UnknownCommand<T extends CommonContext> extends CommonCommand<T> {


    private String command;

    public UnknownCommand(String command) {
        this.command = command;
    }

    @Override
    public void doApply(T context) {
        MessageHolder.addErrorMessage("Unknown command: " + command);
    }
}

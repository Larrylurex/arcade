package dmitry.borodin.console.game.command.factory;

import dmitry.borodin.console.game.command.Command;

public interface CommandFactory<T> {

    Command<T> getCommand(String command);
}

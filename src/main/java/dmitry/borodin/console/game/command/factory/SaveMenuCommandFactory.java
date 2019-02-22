package dmitry.borodin.console.game.command.factory;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.command.UnknownCommand;
import dmitry.borodin.console.game.command.switch_stage.ReturnCommand;
import dmitry.borodin.console.game.command.switch_stage.SaveGameCommand;
import dmitry.borodin.console.game.model.ReturnableGameContext;

public class SaveMenuCommandFactory implements CommandFactory<ReturnableGameContext> {
    @Override
    public Command<ReturnableGameContext> getCommand(String command) {
        Command<ReturnableGameContext> c;
        if (command.length() > 1) {
            c = new SaveGameCommand<>(command);
        } else if (command.charAt(0) == 'r') {
            c = new ReturnCommand<>();
        } else {
            c = new UnknownCommand<>(command);

        }
        return c;
    }
}

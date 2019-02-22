package dmitry.borodin.console.game.command.factory;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.command.UnknownCommand;
import dmitry.borodin.console.game.command.switch_stage.CharacterCreatorCommand;
import dmitry.borodin.console.game.command.switch_stage.ReturnCommand;
import dmitry.borodin.console.game.model.ReturnContext;

public class GameDescriptionCommandFactory implements CommandFactory<ReturnContext> {
    @Override
    public Command<ReturnContext> getCommand(String command) {
        Command<ReturnContext> c;
        switch (command.charAt(0)) {
            case 's':
                c = new CharacterCreatorCommand<>();
                break;
            case 'b':
                c = new ReturnCommand<>();
                break;
            default:
                c = new UnknownCommand<>(command);
                break;
        }
        return c;
    }
}

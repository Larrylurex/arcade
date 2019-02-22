package dmitry.borodin.console.game.command.factory;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.command.UnknownCommand;
import dmitry.borodin.console.game.command.switch_stage.ReturnCommand;
import dmitry.borodin.console.game.command.switch_stage.StartNewGameCommand;
import dmitry.borodin.console.game.model.ReturnContext;

public class CharacterCreatorCommandFactory implements CommandFactory<ReturnContext> {
    @Override
    public Command<ReturnContext> getCommand(String command) {
        Command<ReturnContext> c;
        switch (command.charAt(0)) {
            case '1':
                c = new StartNewGameCommand<>(0);
                break;
            case '2':
                c = new StartNewGameCommand<>(1);
                break;
            case '3':
                c = new StartNewGameCommand<>(2);
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

package dmitry.borodin.console.game.command.factory;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.command.UnknownCommand;
import dmitry.borodin.console.game.command.switch_stage.GoToStartMenu;
import dmitry.borodin.console.game.command.switch_stage.QuitCommand;
import dmitry.borodin.console.game.model.EndGameContext;

public class EndGameCommandFactory implements CommandFactory<EndGameContext> {
    @Override
    public Command<EndGameContext> getCommand(String command) {
        Command<EndGameContext> c;
        switch (command.charAt(0)) {
            case 'q':
                c = new QuitCommand<>();
                break;
            case 'n':
                c = new GoToStartMenu<>();
                break;
            default:
                c = new UnknownCommand<>(command);
                break;
        }
        return c;
    }
}

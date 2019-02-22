package dmitry.borodin.console.game.command.factory;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.command.UnknownCommand;
import dmitry.borodin.console.game.command.switch_stage.DescriptionMenuCommand;
import dmitry.borodin.console.game.command.switch_stage.QuitMenuCommand;
import dmitry.borodin.console.game.command.switch_stage.ReturnCommand;
import dmitry.borodin.console.game.command.switch_stage.SaveMenuCommand;
import dmitry.borodin.console.game.model.ReturnableGameContext;

public class GameMenuCommandFactory implements CommandFactory<ReturnableGameContext> {
    @Override
    public Command<ReturnableGameContext> getCommand(String command) {
        Command<ReturnableGameContext> c;

        switch (command.charAt(0)) {
            case 'q':
                c = new QuitMenuCommand<>();
                break;
            case 'd':
                c = new DescriptionMenuCommand<>();
                break;
            case 's':
                c = new SaveMenuCommand<>();
                break;
            case 'r':
                c = new ReturnCommand<>();
                break;
            default:
                c = new UnknownCommand<>(command);
                break;

        }
        return c;
    }
}

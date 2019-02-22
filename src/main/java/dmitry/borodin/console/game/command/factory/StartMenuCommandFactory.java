package dmitry.borodin.console.game.command.factory;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.command.UnknownCommand;
import dmitry.borodin.console.game.command.switch_stage.DescriptionMenuCommand;
import dmitry.borodin.console.game.command.switch_stage.LoadGameMenuCommand;
import dmitry.borodin.console.game.command.switch_stage.QuitMenuCommand;
import dmitry.borodin.console.game.model.CommonContext;

public class StartMenuCommandFactory implements CommandFactory<CommonContext> {

    @Override
    public Command<CommonContext> getCommand(String command) {
        Command<CommonContext> c;

        switch (command.charAt(0)) {
            case 'n':
                c = new DescriptionMenuCommand<>();
                break;
            case 'q':
                c = new QuitMenuCommand<>();
                break;
            case 'l':
                c = new LoadGameMenuCommand<>();
                break;
            default:
                c = new UnknownCommand<>(command);
                break;
        }
        return c;
    }
}

package dmitry.borodin.console.game.command.factory;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.command.NextPageCommand;
import dmitry.borodin.console.game.command.PrevPageCommand;
import dmitry.borodin.console.game.command.UnknownCommand;
import dmitry.borodin.console.game.command.switch_stage.LoadGameCommand;
import dmitry.borodin.console.game.command.switch_stage.ReturnCommand;
import dmitry.borodin.console.game.model.LoadGameContext;

public class LoadGameCommandFactory implements CommandFactory<LoadGameContext> {


    @Override
    public Command<LoadGameContext> getCommand(String command) {
        Command<LoadGameContext> c;
        char ch = command.charAt(0);
        if (Character.isDigit(ch)) {
            c = new LoadGameCommand<>(command);
        } else {
            switch (ch) {
                case 'b':
                    c = new ReturnCommand<>();
                    break;
                case 'p':
                    c = new PrevPageCommand();
                    break;
                case 'n':
                    c = new NextPageCommand();
                    break;
                default:
                    c = new UnknownCommand<>(command);
                    break;
            }
        }
        return c;
    }

}

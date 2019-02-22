package dmitry.borodin.console.game.command.factory;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.command.UnknownCommand;
import dmitry.borodin.console.game.command.move.GoDown;
import dmitry.borodin.console.game.command.move.GoLeft;
import dmitry.borodin.console.game.command.move.GoRight;
import dmitry.borodin.console.game.command.move.GoUp;
import dmitry.borodin.console.game.command.switch_stage.FightCommand;
import dmitry.borodin.console.game.command.switch_stage.GameMenuCommand;
import dmitry.borodin.console.game.command.switch_stage.NextRoundCommand;
import dmitry.borodin.console.game.model.GameContext;

public class RoundCommandFactory implements CommandFactory<GameContext> {

    public Command<GameContext> getCommand(String command) {
        Command<GameContext> c;

        switch (command.charAt(0)) {
            case 'w':
                c = new GoUp();
                break;
            case 's':
                c = new GoDown();
                break;
            case 'a':
                c = new GoLeft();
                break;
            case 'd':
                c = new GoRight();
                break;
            case 'f':
                c = new FightCommand<>();
                break;
            case 'm':
                c = new GameMenuCommand<>();
                break;
            case 'n':
                c = new NextRoundCommand<>();
                break;
            default:
                c = new UnknownCommand<>(command);
                break;

        }
        return c;
    }
}

package dmitry.borodin.console.game.command.factory;

import dmitry.borodin.console.game.command.AttackCommand;
import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.command.MonsterAttackCommand;
import dmitry.borodin.console.game.command.UnknownCommand;
import dmitry.borodin.console.game.command.switch_stage.LeaveFight;
import dmitry.borodin.console.game.model.FightContext;

public class FightCommandFactory implements CommandFactory<FightContext> {

    @Override
    public Command<FightContext> getCommand(String command) {
        Command<FightContext> c;
        switch (command.charAt(0)) {
            case 'a':
                c = new AttackCommand();
                break;
            case 'm':
                c = new MonsterAttackCommand();
                break;
            case 'e':
                c = new LeaveFight();
                break;
            default:
                c = new UnknownCommand<>(command);
                break;
        }
        return c;
    }
}

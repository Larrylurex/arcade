package dmitry.borodin.console.game.command.factory;

import dmitry.borodin.console.game.command.AttackCommand;
import dmitry.borodin.console.game.command.MonsterAttackCommand;
import dmitry.borodin.console.game.command.switch_stage.LeaveFight;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FightCommandFactoryTest extends CommandFactoryTest {

    private FightCommandFactory factory = new FightCommandFactory();

    @Test
    public void testValidCommands() {
        checkValidCommands(factory, getValidCommands());
    }

    @Test
    public void testUnknownCommands() {
        checkInvalidCommands(factory, getUnknownCommands());
    }

    private Map<String, Class> getValidCommands() {
        Map<String, Class> validCommands = new HashMap<>();
        validCommands.put("a", AttackCommand.class);
        validCommands.put("m", MonsterAttackCommand.class);
        validCommands.put("e", LeaveFight.class);
        return validCommands;
    }

    private List<String> getUnknownCommands() {
        return Arrays.asList("654", "4", "sdf", "r");
    }
}

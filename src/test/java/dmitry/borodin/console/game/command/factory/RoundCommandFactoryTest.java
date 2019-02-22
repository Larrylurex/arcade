package dmitry.borodin.console.game.command.factory;

import dmitry.borodin.console.game.command.move.GoDown;
import dmitry.borodin.console.game.command.move.GoLeft;
import dmitry.borodin.console.game.command.move.GoRight;
import dmitry.borodin.console.game.command.move.GoUp;
import dmitry.borodin.console.game.command.switch_stage.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoundCommandFactoryTest extends CommandFactoryTest {

    private RoundCommandFactory factory = new RoundCommandFactory();

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
        validCommands.put("w", GoUp.class);
        validCommands.put("s", GoDown.class);
        validCommands.put("a", GoLeft.class);
        validCommands.put("d", GoRight.class);
        validCommands.put("f", FightCommand.class);
        validCommands.put("m", GameMenuCommand.class);
        validCommands.put("n", NextRoundCommand.class);

        return validCommands;
    }

    private List<String> getUnknownCommands() {
        return Arrays.asList("13", "2", "qsdf", "b", "r");
    }
}

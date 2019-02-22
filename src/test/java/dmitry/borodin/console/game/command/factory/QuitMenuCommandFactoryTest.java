package dmitry.borodin.console.game.command.factory;

import dmitry.borodin.console.game.command.switch_stage.QuitCommand;
import dmitry.borodin.console.game.command.switch_stage.ReturnCommand;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuitMenuCommandFactoryTest extends CommandFactoryTest {
    private QuitMenuCommandFactory factory = new QuitMenuCommandFactory();

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
        validCommands.put("y", QuitCommand.class);
        validCommands.put("n", ReturnCommand.class);

        return validCommands;
    }

    private List<String> getUnknownCommands() {
        return Arrays.asList("13", "2", "sdf", "f", "a");
    }
}

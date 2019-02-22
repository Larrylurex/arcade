package dmitry.borodin.console.game.command.factory;

import dmitry.borodin.console.game.command.switch_stage.ReturnCommand;
import dmitry.borodin.console.game.command.switch_stage.SaveGameCommand;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveMenuCommandFactoryTest extends CommandFactoryTest {

    private SaveMenuCommandFactory factory = new SaveMenuCommandFactory();

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
        validCommands.put("qwee", SaveGameCommand.class);
        validCommands.put("wedcc", SaveGameCommand.class);
        validCommands.put("1234", SaveGameCommand.class);
        validCommands.put("r", ReturnCommand.class);
        return validCommands;
    }

    private List<String> getUnknownCommands() {
        return Arrays.asList("a", "2", "s", "b", "d");
    }
}

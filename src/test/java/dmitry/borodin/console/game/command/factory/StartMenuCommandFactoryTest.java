package dmitry.borodin.console.game.command.factory;

import dmitry.borodin.console.game.command.switch_stage.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StartMenuCommandFactoryTest extends CommandFactoryTest {

    private StartMenuCommandFactory factory = new StartMenuCommandFactory();

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
        validCommands.put("n", DescriptionMenuCommand.class);
        validCommands.put("q", QuitMenuCommand.class);
        validCommands.put("l", LoadGameMenuCommand.class);
        return validCommands;
    }

    private List<String> getUnknownCommands() {
        return Arrays.asList("a", "2", "s", "b", "d");
    }
}
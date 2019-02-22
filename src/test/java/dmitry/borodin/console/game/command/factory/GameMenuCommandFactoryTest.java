package dmitry.borodin.console.game.command.factory;

import dmitry.borodin.console.game.command.switch_stage.DescriptionMenuCommand;
import dmitry.borodin.console.game.command.switch_stage.QuitMenuCommand;
import dmitry.borodin.console.game.command.switch_stage.ReturnCommand;
import dmitry.borodin.console.game.command.switch_stage.SaveMenuCommand;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameMenuCommandFactoryTest extends CommandFactoryTest {

    private GameMenuCommandFactory factory = new GameMenuCommandFactory();

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
        validCommands.put("q", QuitMenuCommand.class);
        validCommands.put("d", DescriptionMenuCommand.class);
        validCommands.put("s", SaveMenuCommand.class);
        validCommands.put("r", ReturnCommand.class);

        return validCommands;
    }

    private List<String> getUnknownCommands() {
        return Arrays.asList("654", "4", "xcb", "f", "a");
    }
}

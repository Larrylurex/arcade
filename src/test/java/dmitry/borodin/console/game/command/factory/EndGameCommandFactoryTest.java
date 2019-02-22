package dmitry.borodin.console.game.command.factory;

import dmitry.borodin.console.game.command.switch_stage.GoToStartMenu;
import dmitry.borodin.console.game.command.switch_stage.QuitCommand;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EndGameCommandFactoryTest extends CommandFactoryTest {

    private EndGameCommandFactory factory = new EndGameCommandFactory();

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
        validCommands.put("q", QuitCommand.class);
        validCommands.put("n", GoToStartMenu.class);
        return validCommands;
    }

    private List<String> getUnknownCommands() {
        return Arrays.asList("654", "4", "sdf", "a", "s");
    }
}

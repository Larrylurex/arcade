package dmitry.borodin.console.game.command.factory;

import dmitry.borodin.console.game.command.switch_stage.CharacterCreatorCommand;
import dmitry.borodin.console.game.command.switch_stage.ReturnCommand;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameDescriptionCommandFactoryTest extends CommandFactoryTest {

    private GameDescriptionCommandFactory factory = new GameDescriptionCommandFactory();

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
        validCommands.put("s", CharacterCreatorCommand.class);
        validCommands.put("b", ReturnCommand.class);
        return validCommands;
    }

    private List<String> getUnknownCommands() {
        return Arrays.asList("654", "4", "vdf", "z", "a");
    }
}

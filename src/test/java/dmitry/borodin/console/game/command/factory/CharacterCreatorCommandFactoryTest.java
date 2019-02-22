package dmitry.borodin.console.game.command.factory;

import dmitry.borodin.console.game.command.switch_stage.ReturnCommand;
import dmitry.borodin.console.game.command.switch_stage.StartNewGameCommand;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterCreatorCommandFactoryTest extends CommandFactoryTest {

    private CharacterCreatorCommandFactory factory = new CharacterCreatorCommandFactory();

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
        validCommands.put("1", StartNewGameCommand.class);
        validCommands.put("2", StartNewGameCommand.class);
        validCommands.put("3", StartNewGameCommand.class);
        validCommands.put("b", ReturnCommand.class);
        return validCommands;
    }

    private List<String> getUnknownCommands() {
        return Arrays.asList("654", "4", "sdf");
    }
}

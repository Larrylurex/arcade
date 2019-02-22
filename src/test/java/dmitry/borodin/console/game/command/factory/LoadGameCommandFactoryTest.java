package dmitry.borodin.console.game.command.factory;

import dmitry.borodin.console.game.command.NextPageCommand;
import dmitry.borodin.console.game.command.PrevPageCommand;
import dmitry.borodin.console.game.command.switch_stage.LoadGameCommand;
import dmitry.borodin.console.game.command.switch_stage.ReturnCommand;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadGameCommandFactoryTest extends CommandFactoryTest {

    private LoadGameCommandFactory factory = new LoadGameCommandFactory();

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
        validCommands.put("b", ReturnCommand.class);
        validCommands.put("p", PrevPageCommand.class);
        validCommands.put("n", NextPageCommand.class);
        validCommands.put("1", LoadGameCommand.class);
        validCommands.put("23", LoadGameCommand.class);
        validCommands.put("234", LoadGameCommand.class);

        return validCommands;
    }

    private List<String> getUnknownCommands() {
        return Arrays.asList("sdf", "f", "a");
    }
}

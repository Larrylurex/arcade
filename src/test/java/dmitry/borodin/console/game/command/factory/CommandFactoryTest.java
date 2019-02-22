package dmitry.borodin.console.game.command.factory;

import dmitry.borodin.console.game.command.UnknownCommand;
import dmitry.borodin.console.game.command.factory.CommandFactory;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public abstract class CommandFactoryTest {

    protected void checkValidCommands(CommandFactory factory, Map<String, Class> commands) {
        commands.forEach((s, c) -> Assert.assertTrue("Wrong command", c.isInstance(factory.getCommand(s))));
    }

    protected void checkInvalidCommands(CommandFactory factory, List<String> commands) {
        commands.forEach((s) -> Assert.assertTrue("Wrong command", factory.getCommand(s) instanceof UnknownCommand));
    }

}

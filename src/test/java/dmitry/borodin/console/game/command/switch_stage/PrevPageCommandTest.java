package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.command.PrevPageCommand;
import dmitry.borodin.console.game.model.LoadGameContext;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrevPageCommandTest {

    private PrevPageCommand command = new PrevPageCommand();

    @Test
    public void testCommand() {
        LoadGameContext context = new LoadGameContext();
        List<String> users = Stream.generate(() -> "User").limit(15).collect(Collectors.toList());

        context.nextPage();

        context.setUsers(users);

        command.apply(context);
        Assert.assertEquals("Page number decremented", 0, context.getCurrentPage());

        command.apply(context);
        Assert.assertEquals("Page number not decremented", 0, context.getCurrentPage());
    }

}

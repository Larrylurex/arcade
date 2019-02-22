package dmitry.borodin.console.game.command;

import dmitry.borodin.console.game.model.LoadGameContext;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NextPageCommandTest {

    private NextPageCommand command = new NextPageCommand();

    @Test
    public void testCommand() {
        LoadGameContext context = new LoadGameContext();
        List<String> users = Stream.generate(() -> "User").limit(15).collect(Collectors.toList());

        context.setUsers(users);

        command.apply(context);
        Assert.assertEquals("Page number incremented", 1, context.getCurrentPage());

        command.apply(context);
        Assert.assertEquals("Page number not incremented", 1, context.getCurrentPage());
    }

}

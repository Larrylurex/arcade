package dmitry.borodin.console.game.command;

import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.utils.Message;
import dmitry.borodin.console.game.utils.MessageHolder;
import org.junit.Assert;
import org.junit.Test;

public class UnknownCommandTest {


    @Test
    public void testCommand() {
        UnknownCommand<CommonContext> command = new UnknownCommand<>("AAA");

        command.apply(new CommonContext());

        Assert.assertEquals(1, MessageHolder.getMessages().size());
        Message message = MessageHolder.getMessages().get(0);
        Assert.assertEquals("Wrong command", "Unknown command: AAA", message.getMessage());

    }
}

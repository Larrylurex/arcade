package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.model.GameContext;
import dmitry.borodin.console.game.model.LoadGameContext;
import dmitry.borodin.console.game.stage.Round;
import dmitry.borodin.console.game.utils.Message;
import dmitry.borodin.console.game.utils.MessageHolder;
import dmitry.borodin.console.game.utils.ResourceUtils;
import dmitry.borodin.console.game.utils.TestUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ResourceUtils.class)
public class LoadGameCommandTest extends CommonSwitchMenuCommandTest<LoadGameContext> {

    private LoadGameCommand<LoadGameContext> command = new LoadGameCommand<>("0");

    @Test
    public void testNotIntegerIndex() {
        command = new LoadGameCommand<>("0qwe");

        command.apply(getContext());

        Assert.assertEquals(1, MessageHolder.getMessages().size());
        Message message = MessageHolder.getMessages().get(0);
        Assert.assertEquals("Wrong message", "Unknown game: 0", message.getMessage());

    }

    @Test
    public void testInvalidIndex() {
        command = new LoadGameCommand<>("12");

        LoadGameContext context = getContext();
        command.apply(context);

        Assert.assertEquals(1, MessageHolder.getMessages().size());
        Message message = MessageHolder.getMessages().get(0);
        Assert.assertEquals("Wrong message", "Unknown game: 12", message.getMessage());

        command = new LoadGameCommand<>("5");
        context.nextPage();
        command.apply(context);

        Assert.assertEquals(1, MessageHolder.getMessages().size());
        message = MessageHolder.getMessages().get(0);
        Assert.assertEquals("Wrong message", "Unknown game: 5", message.getMessage());
    }

    @Test
    public void testValidIndex() {
        PowerMockito.mockStatic(ResourceUtils.class);
        when(ResourceUtils.readFileAsObject(eq("./save/4"), any())).thenReturn(null);
        when(ResourceUtils.readResourceAsArray(any())).thenReturn(new char [][]{{' ', ' ', ' '}});

        command = new LoadGameCommand<>("5");

        LoadGameContext context = getContext();

        command.apply(context);

        checkSwitch(context, Round.class);
    }

    private LoadGameContext getContext() {
        LoadGameContext context = new LoadGameContext();
        context.setUsers(Arrays.asList("User1", "User2", "User3",
                "User1", "User2", "User3",
                "User1", "User2", "User3",
                "User1", "User2", "User3",
                "User1", "User2", "User3"));
        context.setCurrentStage(TestUtils.getDummyStage(context));
        return context;
    }



    @Override
    protected Command<LoadGameContext> getCommand() {
        return new LoadGameCommand<>("0");
    }
}

package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.model.GameContext;
import dmitry.borodin.console.game.model.ReturnContext;
import dmitry.borodin.console.game.model.ReturnableGameContext;
import dmitry.borodin.console.game.stage.Round;
import dmitry.borodin.console.game.utils.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;
import java.nio.file.Files;

import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ResourceUtils.class})
public class SaveGameCommandTest extends CommonSwitchMenuCommandTest<ReturnableGameContext> {

    private SaveGameCommand<ReturnableGameContext> command = new SaveGameCommand<>("some_name");

    @Before
    public void setUp() {
        PowerMockito.mockStatic(ResourceUtils.class);
        when(ResourceUtils.writeObject(any(), any())).thenReturn(true);
        MessageHolder.eraseErrors();
    }

    @Test
    public void testCommand() {
        ReturnableGameContext context = getContext();
        checkSwitch(context, context.getPrevStage().getClass());

        Assert.assertEquals(1, MessageHolder.getMessages().size());
        Message message = MessageHolder.getMessages().get(0);
        Assert.assertEquals("Wrong message", "Game is saved", message.getMessage());
    }

    @Test
    public void testSaveError() {
        when(ResourceUtils.writeObject(any(), any())).thenReturn(false);

        ReturnableGameContext context = getContext();
        checkSwitch(context, context.getPrevStage().getClass());

        Assert.assertEquals(1, MessageHolder.getMessages().size());
        Message message = MessageHolder.getMessages().get(0);
        Assert.assertEquals("Wrong message", "Couldn't save game", message.getMessage());

    }

    private ReturnableGameContext getContext() {
        ReturnableGameContext context = new ReturnableGameContext();
        context.setCurrentStage(TestUtils.getDummyStage(context));
        context.setGameContext(new GameContext());

        context.setPrevStage(TestUtils.getDummyStage(new CommonContext()));
        return context;
    }

    @Override
    protected Command<ReturnableGameContext> getCommand() {
        return command;
    }
}

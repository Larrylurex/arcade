package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.model.ReturnContext;
import dmitry.borodin.console.game.stage.Round;
import dmitry.borodin.console.game.utils.GameInitializationException;
import dmitry.borodin.console.game.utils.ResourceUtils;
import dmitry.borodin.console.game.utils.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ResourceUtils.class)
public class StartNewGameCommandTest extends CommonSwitchMenuCommandTest<ReturnContext> {

    private StartNewGameCommand<ReturnContext> command = new StartNewGameCommand<>(1);


    @Test
    public void testCommand() {
        checkSwitch(getContext(), Round.class);
    }

    @Test(expected = GameInitializationException.class)
    public void testInitializationError() {
        PowerMockito.mockStatic(ResourceUtils.class);
        when(ResourceUtils.readResourceAsObject(any(), any())).thenReturn(null);
        checkSwitch(getContext(), Round.class);
    }

    private ReturnContext getContext() {
        ReturnContext context = new ReturnContext();
        context.setCurrentStage(TestUtils.getDummyStage(context));
        return context;
    }

    @Override
    protected Command<ReturnContext> getCommand() {
        return command;
    }
}

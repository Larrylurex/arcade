package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.stage.CharacterCreator;
import dmitry.borodin.console.game.stage.Quit;
import org.junit.Assert;
import org.junit.Test;

public class QuitCommandTest extends CommonSwitchMenuCommandTest<CommonContext> {

    private QuitCommand<CommonContext> command = new QuitCommand<>();

    @Test
    public void testCommand() {
        CommonContext context = getCommonContext();
        getCommand().apply(context);
        Assert.assertFalse("Current stage stopped", context.getCurrentStage().isRunning());
        Assert.assertTrue("Next stage wrong", context.getNextStage() instanceof Quit);
        Assert.assertFalse("Next stage stopped", context.getNextStage().isRunning());
    }

    @Override
    protected Command<CommonContext> getCommand() {
        return command;
    }
}

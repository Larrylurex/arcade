package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.model.GameContext;
import dmitry.borodin.console.game.model.ReturnableGameContext;
import dmitry.borodin.console.game.stage.SaveMenu;
import dmitry.borodin.console.game.utils.TestUtils;
import org.junit.Test;

public class SaveMenuCommandTest extends CommonSwitchMenuCommandTest<ReturnableGameContext> {

    private SaveMenuCommand<ReturnableGameContext> command = new SaveMenuCommand<>();


    @Test
    public void testCommand() {
        checkSwitch(getContext(), SaveMenu.class);
    }

    private ReturnableGameContext getContext() {
        ReturnableGameContext context = new ReturnableGameContext();
        context.setGameContext(new GameContext());
        context.setCurrentStage(TestUtils.getDummyStage(context));
        return context;
    }

    @Override
    protected Command<ReturnableGameContext> getCommand() {
        return command;
    }
}

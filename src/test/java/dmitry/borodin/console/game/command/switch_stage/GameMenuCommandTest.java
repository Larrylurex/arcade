package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.model.GameContext;
import dmitry.borodin.console.game.model.ReturnableGameContext;
import dmitry.borodin.console.game.stage.CommonStage;
import dmitry.borodin.console.game.stage.GameMenu;
import dmitry.borodin.console.game.stage.Stage;
import dmitry.borodin.console.game.utils.TestUtils;
import org.junit.Assert;
import org.junit.Test;

public class GameMenuCommandTest extends CommonSwitchMenuCommandTest<GameContext> {

    private GameMenuCommand<GameContext> command = new GameMenuCommand<>();


    @Test
    public void testSwitch() throws NoSuchFieldException, IllegalAccessException {
        GameContext context = getContext();
        checkSwitch(context, GameMenu.class);
        Object contextFromStage = getContextFromStage((CommonStage) context.getNextStage());
        Assert.assertTrue("Wrong context", contextFromStage instanceof ReturnableGameContext);
        ReturnableGameContext returnableGameContext = (ReturnableGameContext) contextFromStage;
        Assert.assertEquals("Wrong context", context, returnableGameContext.getGameContext());

    }

    protected GameContext getContext() {
        GameContext context = new GameContext();
        Stage dummyStage = TestUtils.getDummyStage(context);
        dummyStage.setRunning(true);
        context.setCurrentStage(dummyStage);
        return context;
    }

    @Override
    protected Command<GameContext> getCommand() {
        return command;
    }
}

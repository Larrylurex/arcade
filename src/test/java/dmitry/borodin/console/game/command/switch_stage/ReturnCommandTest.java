package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.model.ReturnContext;
import dmitry.borodin.console.game.stage.Quit;
import dmitry.borodin.console.game.stage.Stage;
import dmitry.borodin.console.game.utils.TestUtils;
import org.junit.Assert;
import org.junit.Test;

public class ReturnCommandTest extends CommonSwitchMenuCommandTest<ReturnContext> {

    private ReturnCommand<ReturnContext> command = new ReturnCommand<>();

    @Test
    public void testCommand() {
        ReturnContext context = getContext();
        checkSwitch(context, context.getPrevStage().getClass());
    }

    private ReturnContext getContext() {
        ReturnContext context = new ReturnContext();
        Stage dummyStage = TestUtils.getDummyStage(context);
        context.setCurrentStage(dummyStage);

        Stage dummyStage2 = TestUtils.getDummyStage(getCommonContext());
        context.setPrevStage(dummyStage2);

        return context;
    }

    @Override
    protected Command<ReturnContext> getCommand() {
        return command;
    }
}

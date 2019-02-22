package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.stage.GameDescription;
import org.junit.Test;

public class DescriptionMenuCommandTest extends CommonSwitchMenuCommandTest<CommonContext> {

    private DescriptionMenuCommand<CommonContext> command = new DescriptionMenuCommand<>();

    @Test
    public void testCommand() {
        checkSwitch(getCommonContext(), GameDescription.class);
    }

    @Override
    protected Command<CommonContext> getCommand() {
        return command;
    }
}

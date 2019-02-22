package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.stage.Quit;
import dmitry.borodin.console.game.stage.QuitMenu;
import org.junit.Assert;
import org.junit.Test;

public class QuitMenuCommandTest extends CommonSwitchMenuCommandTest<CommonContext> {

    private QuitMenuCommand<CommonContext> command = new QuitMenuCommand<>();

    @Test
    public void testCommand() {
        checkSwitch(getCommonContext(), QuitMenu.class);
    }

    @Override
    protected Command<CommonContext> getCommand() {
        return command;
    }
}

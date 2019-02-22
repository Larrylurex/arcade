package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.stage.LoadGame;
import org.junit.Test;

public class LoadGameMenuTest extends CommonSwitchMenuCommandTest<CommonContext> {

    private LoadGameMenuCommand<CommonContext> command = new LoadGameMenuCommand<>();

    @Test
    public void testCommand() {
        checkSwitch(getCommonContext(), LoadGame.class);
    }

    @Override
    protected Command<CommonContext> getCommand() {
        return command;
    }
}

package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.stage.CharacterCreator;
import dmitry.borodin.console.game.stage.StartMenu;
import org.junit.Test;

public class GoToStartMenuCommandTest extends CommonSwitchMenuCommandTest<CommonContext> {

    private GoToStartMenu<CommonContext> command = new GoToStartMenu<>();

    @Test
    public void testCommand() {
        checkSwitch(getCommonContext(), StartMenu.class);
    }

    @Override
    protected Command<CommonContext> getCommand() {
        return command;
    }
}

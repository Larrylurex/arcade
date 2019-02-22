package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.stage.CharacterCreator;
import org.junit.Test;

public class CharacterCreatorCommandTest extends CommonSwitchMenuCommandTest<CommonContext> {

    private CharacterCreatorCommand<CommonContext> command = new CharacterCreatorCommand<>();

    @Test
    public void testCommand() {
        checkSwitch(getCommonContext(), CharacterCreator.class);
    }

    @Override
    protected Command<CommonContext> getCommand() {
        return command;
    }
}

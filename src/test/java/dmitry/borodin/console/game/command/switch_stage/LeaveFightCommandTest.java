package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.model.FightContext;
import dmitry.borodin.console.game.model.map.Item;
import dmitry.borodin.console.game.model.map.Player;
import dmitry.borodin.console.game.stage.EndGame;
import dmitry.borodin.console.game.stage.Stage;
import dmitry.borodin.console.game.utils.Message;
import dmitry.borodin.console.game.utils.MessageHolder;
import dmitry.borodin.console.game.utils.TestUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class LeaveFightCommandTest extends CommonSwitchMenuCommandTest<FightContext> {

    private LeaveFight command = new LeaveFight();

    @Test
    public void testFightIsNotOver() {
        FightContext context = getContext();

        command.apply(context);

        Assert.assertEquals(1, MessageHolder.getMessages().size());
        Message message = MessageHolder.getMessages().get(0);
        Assert.assertEquals("Wrong command", "Unknown command: e", message.getMessage());
    }

    @Test
    public void testPlayerIsDead() {
        FightContext context = getContext();
        context.getPlayer().setItems(Collections.emptyList());
        context.setFightOver(true);

        checkSwitch(context, EndGame.class);
    }

    @Test
    public void testPlayerWon() {
        FightContext context = getContext();
        Item item = new Item();
        item.setType(1);
        context.getPlayer().setItems(Collections.singletonList(item));
        context.setFightOver(true);
        Stage nextStage = TestUtils.getDummyStage(new CommonContext());
        context.setPrevStage(nextStage);

        checkSwitch(context, nextStage.getClass());
    }

    private FightContext getContext() {
        FightContext context = new FightContext();
        context.setFightOver(false);
        context.setPlayer(new Player());
        context.setCurrentStage(TestUtils.getDummyStage(context));
        return context;
    }

    @Override
    protected Command<FightContext> getCommand() {
        return command;
    }
}

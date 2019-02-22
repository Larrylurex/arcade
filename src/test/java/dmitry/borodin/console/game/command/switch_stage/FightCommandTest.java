package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.model.FightContext;
import dmitry.borodin.console.game.model.GameContext;
import dmitry.borodin.console.game.model.map.Enemy;
import dmitry.borodin.console.game.model.map.Player;
import dmitry.borodin.console.game.stage.CommonStage;
import dmitry.borodin.console.game.stage.Fight;
import dmitry.borodin.console.game.stage.Stage;
import dmitry.borodin.console.game.utils.Message;
import dmitry.borodin.console.game.utils.MessageHolder;
import dmitry.borodin.console.game.utils.TestUtils;
import org.junit.Assert;
import org.junit.Test;

public class FightCommandTest extends CommonSwitchMenuCommandTest<GameContext> {

    private FightCommand<GameContext> command = new FightCommand<>();

    @Test
    public void testSwitch() throws NoSuchFieldException, IllegalAccessException {
        GameContext context = getContext();
        checkSwitch(context, Fight.class);
        Object contextFromStage = getContextFromStage((CommonStage) context.getNextStage());
        Assert.assertTrue("Wrong context", contextFromStage instanceof FightContext);
        FightContext fightContext = (FightContext)contextFromStage;
        Assert.assertEquals("Wrong player set", context.getPlayer(), fightContext.getPlayer());
        Assert.assertEquals("Wrong enemy set", context.getCloseEnemy(), fightContext.getEnemy());

    }

    @Test
    public void testWrongCommand() {
        GameContext context = getContext();
        context.setCloseEnemy(null);
        command.apply(context);
        Assert.assertEquals(1, MessageHolder.getMessages().size());
        Message message = MessageHolder.getMessages().get(0);
        Assert.assertEquals("Wrong command", "Unknown command: f", message.getMessage());


        Enemy closeEnemy = new Enemy();
        closeEnemy.setUsed(true);
        context.setCloseEnemy(closeEnemy);
        command.apply(context);
        Assert.assertEquals(1, MessageHolder.getMessages().size());
        message = MessageHolder.getMessages().get(0);
        Assert.assertEquals("Wrong command", "Unknown command: f", message.getMessage());

    }

    protected GameContext getContext() {
        GameContext context = new GameContext();
        context.setPlayer(new Player());
        context.setCloseEnemy(new Enemy());
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

package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.model.EndGameContext;
import dmitry.borodin.console.game.model.GameContext;
import dmitry.borodin.console.game.model.ReturnableGameContext;
import dmitry.borodin.console.game.model.map.Item;
import dmitry.borodin.console.game.model.map.Player;
import dmitry.borodin.console.game.stage.EndGame;
import dmitry.borodin.console.game.stage.Round;
import dmitry.borodin.console.game.stage.Stage;
import dmitry.borodin.console.game.utils.Message;
import dmitry.borodin.console.game.utils.MessageHolder;
import dmitry.borodin.console.game.utils.ResourceUtils;
import dmitry.borodin.console.game.utils.TestUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ResourceUtils.class})
public class NextRoundCommandTest extends CommonSwitchMenuCommandTest<GameContext> {

    private NextRoundCommand<GameContext> command = new NextRoundCommand<>();

    @Before
    public void setUp() {
        PowerMockito.mockStatic(ResourceUtils.class);
        MessageHolder.eraseErrors();
        when(ResourceUtils.readResourceAsArray(any())).thenReturn(new char [][]{{' ', ' ', ' '}});

    }

    @Test
    public void testPortalClosed() {
        GameContext context = getContext();
        context.getPlayer().setItems(Collections.emptyList());
        command.apply(context);

        Assert.assertEquals(1, MessageHolder.getMessages().size());
        Message message = MessageHolder.getMessages().get(0);
        Assert.assertEquals("Wrong message", "You don't have enough snowflakes to go through portal", message.getMessage());
    }

    @Test
    public void testPortalOpenedAndLastRound() {
        when(ResourceUtils.readResourceAsObject(any(), any())).thenReturn(null);

        GameContext context = getContext();
        checkSwitch(context, EndGame.class);
    }

    @Test
    public void testPortalOpenedAndHasNextRound() {
        when(ResourceUtils.readResourceAsObject(any(), any())).thenReturn(getContext());

        GameContext context = getContext();
        checkSwitch(context, Round.class);
    }

    protected GameContext getContext() {
        GameContext context = new GameContext();
        Stage dummyStage = TestUtils.getDummyStage(context);
        dummyStage.setRunning(true);
        context.setCurrentStage(dummyStage);
        Player player = new Player();
        Item item = new Item();
        item.setType(0);
        player.collectItem(item);
        player.collectItem(item);
        player.collectItem(item);

        context.setPlayer(player);
        return context;
    }


    @Override
    protected Command<GameContext> getCommand() {
        return command;
    }
}

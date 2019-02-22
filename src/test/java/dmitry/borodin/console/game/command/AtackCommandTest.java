package dmitry.borodin.console.game.command;

import dmitry.borodin.console.game.model.FightContext;
import dmitry.borodin.console.game.model.map.Player;
import dmitry.borodin.console.game.utils.Message;
import dmitry.borodin.console.game.utils.MessageHolder;
import org.junit.Assert;
import org.junit.Test;

public class AtackCommandTest {

    private AttackCommand command = new AttackCommand();


    @Test
    public void testWrongCommand() {

        FightContext context = new FightContext();
        context.setPlayerAttacked(true);

        command.apply(context);

        Assert.assertEquals(1, MessageHolder.getMessages().size());
        Message message = MessageHolder.getMessages().get(0);
        Assert.assertEquals("Wrong command", "Unknown command: a", message.getMessage());

    }

    @Test
    public void testCommand() {

        FightContext context = new FightContext();
        context.setPlayerAttacked(false);
        Player player = new Player();
        player.setLevel(2);
        context.setPlayer(player);
        command.apply(context);

        Assert.assertTrue("Player attacked", context.isPlayerAttacked());
        Assert.assertTrue("Player score not set", context.getPlayerScore() > 0);

    }
}

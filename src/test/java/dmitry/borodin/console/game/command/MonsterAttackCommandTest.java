package dmitry.borodin.console.game.command;

import dmitry.borodin.console.game.model.FightContext;
import dmitry.borodin.console.game.model.map.Enemy;
import dmitry.borodin.console.game.model.map.Item;
import dmitry.borodin.console.game.model.map.Player;
import dmitry.borodin.console.game.utils.Message;
import dmitry.borodin.console.game.utils.MessageHolder;
import org.junit.Assert;
import org.junit.Test;

public class MonsterAttackCommandTest {

    private MonsterAttackCommand command = new MonsterAttackCommand();

    @Test
    public void testWrongCommand() {

        FightContext context = new FightContext();
        context.setFightOver(true);

        command.apply(context);

        Assert.assertEquals(1, MessageHolder.getMessages().size());
        Message message = MessageHolder.getMessages().get(0);
        Assert.assertEquals("Wrong command", "Unknown command: m", message.getMessage());

        context.setFightOver(false);
        context.setPlayerAttacked(false);
        command.apply(context);

        Assert.assertEquals(1, MessageHolder.getMessages().size());
        message = MessageHolder.getMessages().get(0);
        Assert.assertEquals("Wrong command", "Unknown command: m", message.getMessage());

    }

    @Test
    public void testPlayerWon() {

        FightContext context = new FightContext();
        context.setPlayerAttacked(false);
        context.setPlayerAttacked(true);
        context.setPlayerScore(100);

        Player player = new Player();
        player.setLevel(2);
        context.setPlayer(player);

        Enemy enemy  = new Enemy();
        context.setEnemy(enemy);
        command.apply(context);


        Assert.assertTrue("Fight over", context.isFightOver());
        Assert.assertTrue("Enemy is used", context.getEnemy().isUsed());
        Assert.assertEquals("Player level increased", 3, context.getPlayer().getLevel());
    }

    @Test
    public void testEnemyWon() {

        FightContext context = new FightContext();
        context.setPlayerAttacked(false);
        context.setPlayerAttacked(true);
        context.setPlayerScore(0);

        Player player = new Player();
        Item item = new Item();
        item.setType(1);
        player.collectItem(item);
        player.collectItem(item);
        player.collectItem(item);
        player.setLevel(2);
        context.setPlayer(player);

        Enemy enemy  = new Enemy();
        enemy.setLevel(10);
        context.setEnemy(enemy);
        command.apply(context);


        Assert.assertTrue("Fight over", context.isFightOver());
        Assert.assertFalse("Enemy is not used", context.getEnemy().isUsed());
        Assert.assertEquals("Player lost health", 2, context.getPlayer().getItemsOfType(1));
    }


}

package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.model.EndGameContext;
import dmitry.borodin.console.game.model.GameContext;
import dmitry.borodin.console.game.model.map.Item;
import dmitry.borodin.console.game.model.map.Player;
import dmitry.borodin.console.game.stage.EndGame;
import dmitry.borodin.console.game.stage.Round;
import dmitry.borodin.console.game.stage.Stage;
import dmitry.borodin.console.game.utils.MessageHolder;
import dmitry.borodin.console.game.utils.ResourceUtils;

import java.util.ArrayList;
import java.util.List;

public class NextRoundCommand<T extends GameContext> extends SwitchStageCommand<T> {

    @Override
    protected void doApply(T context) {
        if (context.isPortalOpened()) {
            super.doApply(context);
        } else {
            MessageHolder.addInfoMessage("You don't have enough snowflakes to go through portal");
        }

    }

    @Override
    protected Stage getNextStage(T context) {
        GameContext gameContext = prepareGameContext(context);
        if (gameContext != null) {
            return new Round(gameContext);
        } else {
            EndGameContext endGameContext = new EndGameContext();
            endGameContext.setSuccess(true);
            return new EndGame(endGameContext);
        }
    }

    private GameContext prepareGameContext(T context) {
        int round = context.getRound() + 1;
        GameContext gameContext = ResourceUtils.readResourceAsObject("rounds/round" + round + ".txt", GameContext.class);
        if (gameContext == null) {
            return null;
        } else {
            Player player = gameContext.getPlayer();
            player.setLevel(context.getPlayer().getLevel());

            List<Item> items = new ArrayList<>();
            Item heart = new Item();
            heart.setType(1);
            items.add(heart);
            items.add(heart);
            items.add(heart);
            player.setItems(items);

            gameContext.setPlayer(player);
            gameContext.setName(context.getName());
            gameContext.setRound(round);
            return gameContext;
        }

    }
}

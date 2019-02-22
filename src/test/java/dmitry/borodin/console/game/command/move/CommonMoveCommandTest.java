package dmitry.borodin.console.game.command.move;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.model.GameContext;
import dmitry.borodin.console.game.model.map.ExplorableObject;
import dmitry.borodin.console.game.utils.Coord;
import org.junit.Assert;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class CommonMoveCommandTest {

    protected void checkCoordsNotChanged(List<Coord> coords) {
        coords.forEach(c -> {
            GameContext context = getGameContext();
            context.getPlayer().setCoord(c);
            getCommand().apply(context);
            Assert.assertEquals("Coords shouldn't be changed" , c, context.getPlayer().getCoord());
        });
    }

    protected <T extends ExplorableObject> void checkExplore(Coord playerCoord, Function<GameContext, List<T>> getter) {
        GameContext context = getGameContext();
        context.getPlayer().setCoord(playerCoord);
        getCommand().apply(context);
        List<T> exploredItems = getter.apply(context)
                .stream()
                .filter(ExplorableObject::isExplored)
                .collect(Collectors.toList());
        Assert.assertTrue("Explorable shouldn't be explored: " + exploredItems, exploredItems.isEmpty());

        getCommand().apply(context);
        exploredItems = getter.apply(context);
        Assert.assertFalse("Explorable should be explored: " + exploredItems, exploredItems.isEmpty());
    }


    protected void checkCollect(Coord coord, int type) {
        GameContext context = getGameContext();
        context.getPlayer().setCoord(coord);
        int itemsOfTypeBefore = context.getPlayer().getItemsOfType(type);
        getCommand().apply(context);
        Assert.assertEquals("Item should be collected" , itemsOfTypeBefore + 1, context.getPlayer().getItemsOfType(type));

    }

    protected abstract Command<GameContext> getCommand();

    protected abstract GameContext getGameContext();

}

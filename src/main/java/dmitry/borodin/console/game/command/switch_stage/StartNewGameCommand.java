package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.model.GameContext;
import dmitry.borodin.console.game.model.ReturnContext;
import dmitry.borodin.console.game.stage.Round;
import dmitry.borodin.console.game.stage.Stage;
import dmitry.borodin.console.game.utils.GameInitializationException;
import dmitry.borodin.console.game.utils.ResourceUtils;

public class StartNewGameCommand<T extends ReturnContext> extends SwitchStageCommand<T> {

    private int character;

    public StartNewGameCommand(int character) {

        this.character = character;
    }

    @Override
    protected Stage getNextStage(T context) {
        GameContext gameContext = prepareGameContext();
        return new Round(gameContext);
    }

    private GameContext prepareGameContext() {
        GameContext gameContext = initNewGameContext();
        gameContext.getPlayer().setType(character);
        return gameContext;
    }

    private GameContext initNewGameContext() {
        String resource = "rounds/round0.txt";
        GameContext gameContext = ResourceUtils.readResourceAsObject(resource, GameContext.class);
        if (gameContext == null) {
            throw new GameInitializationException("Couldn't load resource: " + resource);
        }
        return gameContext;
    }


}

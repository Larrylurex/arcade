package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.model.GameContext;
import dmitry.borodin.console.game.model.LoadGameContext;
import dmitry.borodin.console.game.stage.Round;
import dmitry.borodin.console.game.stage.Stage;
import dmitry.borodin.console.game.utils.MessageHolder;
import dmitry.borodin.console.game.utils.ResourceUtils;

public class LoadGameCommand<T extends LoadGameContext> extends SwitchStageCommand<T> {

    private int selectedGame;

    public LoadGameCommand(String ch) {
        try {
            selectedGame = Integer.parseInt(ch) - 1;
        } catch (NumberFormatException e) {
            selectedGame = -1;
        }
    }

    @Override
    protected void doApply(T context) {
        if(checkValidGame(context, selectedGame)){
            super.doApply(context);
        } else {
            MessageHolder.addErrorMessage("Unknown game: " + (selectedGame + 1));
        }
    }

    private boolean checkValidGame(T context, int selectedGame) {
        int from = context.getCurrentPage() * context.getPageSize();
        int to = from + context.getPageSize();
        return selectedGame >= from &&
                selectedGame < to;
    }

    @Override
    protected Stage getNextStage(T context) {
        GameContext gameContext = prepareGameContext(context);
        return new Round(gameContext);
    }

    private GameContext prepareGameContext(T context) {
        return loadGameContext(context.getGame(selectedGame));
    }

    private GameContext loadGameContext(String game) {
        GameContext gameContext = ResourceUtils.readFileAsObject("./save/" + game, GameContext.class);
        if (gameContext == null) {
            gameContext = new GameContext();
            MessageHolder.addErrorMessage("Couldn't load game");
        }
        return gameContext;
    }
}

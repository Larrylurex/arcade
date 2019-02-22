package dmitry.borodin.console.game.model;

public class ReturnableGameContext extends ReturnContext {

    private GameContext gameContext;

    public GameContext getGameContext() {
        return gameContext;
    }

    public void setGameContext(GameContext gameContext) {
        this.gameContext = gameContext;
    }
}

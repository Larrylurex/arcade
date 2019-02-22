package dmitry.borodin.console.game.stage;

public interface Stage {

    Stage run();

    void setRunning(boolean running);

    boolean isRunning();
}

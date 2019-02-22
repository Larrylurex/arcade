package dmitry.borodin.console.game.command;

public interface Command<T> {

    void apply(T context);
}

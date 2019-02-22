package dmitry.borodin.console.game.stage;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.command.factory.CommandFactory;
import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.view.View;

import java.util.Scanner;

public abstract class CommonStage<T extends CommonContext> implements Stage {

    private static final int DELAY = 100;
    private Scanner scanner;
    private View<T> view;
    private CommandFactory<T> commandFactory;
    private T context;
    private boolean running = true;


    public CommonStage(T context) {
        this.context = context;
        context.setCurrentStage(this);
        this.scanner = new Scanner(System.in);
        this.view = getView();
        this.commandFactory = getCommandFactory();
    }

    @Override
    public Stage run() {
        view = getView();
        view.display(context);
        while (running) {
            try {
                Command<T> command = commandFactory.getCommand(scanner.next());
                command.apply(context);
                view.display(context);
                Thread.sleep(DELAY);
            } catch (InterruptedException ignored) {
            }
        }
        return context.getNextStage();
    }

    @Override
    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    protected abstract View<T> getView();

    protected abstract CommandFactory<T> getCommandFactory();
}

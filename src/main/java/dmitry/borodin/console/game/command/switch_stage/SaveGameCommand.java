package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.model.ReturnableGameContext;
import dmitry.borodin.console.game.stage.Stage;
import dmitry.borodin.console.game.utils.MessageHolder;
import dmitry.borodin.console.game.utils.ResourceUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SaveGameCommand<T extends ReturnableGameContext> extends SwitchStageCommand<T> {

    private String name;

    public SaveGameCommand(String name) {
        this.name = name;
    }

    @Override
    protected Stage getNextStage(T context) {
        context.getGameContext().setName(name);
        try {
            Files.createDirectories(Paths.get(".", "save"));
        } catch (IOException e) {
            MessageHolder.addErrorMessage("Couldn't save game");
        }
        boolean saved = ResourceUtils.writeObject("./save/" + name, context.getGameContext());
        if (!saved) {
            MessageHolder.addErrorMessage("Couldn't save game");
        } else {
            MessageHolder.addInfoMessage("Game is saved");
        }
        return context.getPrevStage();
    }
}

package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.model.LoadGameContext;
import dmitry.borodin.console.game.stage.LoadGame;
import dmitry.borodin.console.game.stage.Stage;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LoadGameMenuCommand<T extends CommonContext> extends SwitchStageCommand<T> {

    @Override
    protected Stage getNextStage(T context) {
        LoadGameContext loadGameContext = new LoadGameContext();
        List<String> users = loadUserData();
        loadGameContext.setUsers(users);
        loadGameContext.setPrevStage(context.getCurrentStage());
        return new LoadGame(loadGameContext);
    }

    private List<String> loadUserData() {
        File folder = new File("./save");
        return Optional.of(folder)
                .filter(File::exists)
                .filter(File::isDirectory)
                .map(File::listFiles)
                .map(Arrays::asList)
                .orElseGet(Collections::emptyList)
                .stream()
                .map(File::getName)
                .collect(Collectors.toList());
    }
}

package dmitry.borodin.console.game;

import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.stage.Stage;
import dmitry.borodin.console.game.stage.StartMenu;

public class Game {

    public void run() {
        CommonContext context = new CommonContext();
        Stage stage = new StartMenu(context);
        context.setCurrentStage(stage);
        while (stage != null) {
            stage = stage.run();
        }
    }
}

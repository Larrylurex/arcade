package dmitry.borodin.console.game.model;

import dmitry.borodin.console.game.stage.Stage;

public class ReturnContext extends CommonContext {

    private transient Stage prevStage;

    public Stage getPrevStage() {
        return prevStage;
    }

    public void setPrevStage(Stage prevStage) {
        this.prevStage = prevStage;
    }
}

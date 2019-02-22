package dmitry.borodin.console.game.model;

import dmitry.borodin.console.game.stage.Stage;

import java.io.Serializable;

public class CommonContext implements Serializable {

    private transient Stage currentStage;
    private transient Stage nextStage;

    public Stage getNextStage() {
        return nextStage;
    }

    public void setNextStage(Stage nextStage) {
        this.nextStage = nextStage;
    }

    public void setCurrentStage(Stage currentStage) {
        this.currentStage = currentStage;
    }

    public Stage getCurrentStage() {
        return currentStage;
    }
}

package dmitry.borodin.console.game.model.map;

import java.io.Serializable;

public abstract class ExplorableObject implements Serializable {

    private boolean explored;
    private boolean used;

    public boolean isExplored() {
        return explored;
    }

    public void setExplored(boolean explored) {
        this.explored = explored;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}

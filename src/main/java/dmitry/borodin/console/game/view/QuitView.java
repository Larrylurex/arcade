package dmitry.borodin.console.game.view;

import dmitry.borodin.console.game.Settings;
import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.utils.ResourceUtils;
import dmitry.borodin.console.game.view.utils.DrawableObject;
import dmitry.borodin.console.game.view.utils.DrawingUtils;

import java.util.Collections;
import java.util.List;

public class QuitView extends CommonView<CommonContext> {

    @Override
    protected boolean isHelpRequired() {
        return false;
    }

    @Override
    protected List<String> getHelp(CommonContext context) {
        return null;
    }

    @Override
    protected List<DrawableObject> getMainDrawableObjects(CommonContext context) {
        return Collections.singletonList(readQuitQuestion());
    }

    private DrawableObject readQuitQuestion() {
        char[][] content = ResourceUtils.readResourceAsArray("images/quit.txt");
        int adjustedY = Settings.MAIN_BOARD_HEIGHT / 3 - content.length / 2;
        int adjustedX = Settings.TOTAL_WIDTH / 2 - DrawingUtils.getMaxWidth(content) / 2;
        return new DrawableObject(adjustedX, adjustedY, content);
    }
}

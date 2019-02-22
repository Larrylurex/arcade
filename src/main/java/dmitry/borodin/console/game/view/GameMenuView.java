package dmitry.borodin.console.game.view;

import dmitry.borodin.console.game.Settings;
import dmitry.borodin.console.game.model.ReturnableGameContext;
import dmitry.borodin.console.game.utils.ResourceUtils;
import dmitry.borodin.console.game.view.utils.DrawableObject;
import dmitry.borodin.console.game.view.utils.DrawingUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameMenuView extends CommonView<ReturnableGameContext> {

    private static final List<String> HELP = Arrays.asList(
            "Press q - to quit",
            "Press d - to see game description",
            "Press s - to save result",
            "press r - to resume game");

    @Override
    protected boolean isHelpRequired() {
        return true;
    }

    @Override
    protected List<String> getHelp(ReturnableGameContext context) {
        return HELP;
    }

    @Override
    protected List<DrawableObject> getMainDrawableObjects(ReturnableGameContext context) {
        return Collections.singletonList(readQuitQuestion());
    }

    private DrawableObject readQuitQuestion() {
        char[][] content = ResourceUtils.readResourceAsArray("images/game_menu.txt");
        int adjustedY = Settings.MAIN_BOARD_HEIGHT / 3 - content.length / 2;
        int adjustedX = Settings.TOTAL_WIDTH / 2 - DrawingUtils.getMaxWidth(content) / 2;
        return new DrawableObject(adjustedX, adjustedY, content);
    }
}

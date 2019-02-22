package dmitry.borodin.console.game.view;

import dmitry.borodin.console.game.Settings;
import dmitry.borodin.console.game.model.ReturnContext;
import dmitry.borodin.console.game.utils.ResourceUtils;
import dmitry.borodin.console.game.view.utils.DrawableObject;
import dmitry.borodin.console.game.view.utils.DrawingUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuitMenuView extends CommonView<ReturnContext> {

    private static final List<String> HELP = Arrays.asList("Press y - to quit", "Press n - to return");

    @Override
    protected boolean isHelpRequired() {
        return true;
    }

    @Override
    protected List<String> getHelp(ReturnContext context) {
        return HELP;
    }

    @Override
    protected List<DrawableObject> getMainDrawableObjects(ReturnContext context) {
        return Collections.singletonList(readQuitQuestion());
    }

    private DrawableObject readQuitQuestion() {
        char[][] content = ResourceUtils.readResourceAsArray("images/quit_question.txt");
        int adjustedY = Settings.MAIN_BOARD_HEIGHT / 3 - content.length / 2;
        int adjustedX = Settings.TOTAL_WIDTH / 2 - DrawingUtils.getMaxWidth(content) / 2;
        return new DrawableObject(adjustedX, adjustedY, content);
    }
}

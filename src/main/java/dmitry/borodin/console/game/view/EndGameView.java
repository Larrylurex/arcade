package dmitry.borodin.console.game.view;

import dmitry.borodin.console.game.Settings;
import dmitry.borodin.console.game.model.EndGameContext;
import dmitry.borodin.console.game.utils.ResourceUtils;
import dmitry.borodin.console.game.view.utils.DrawableObject;
import dmitry.borodin.console.game.view.utils.DrawingUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EndGameView extends CommonView<EndGameContext> {

    private static final List<String> HELP = Arrays.asList(
            "Press q - to quit",
            "Press n - to start new game"
    );

    @Override
    protected boolean isHelpRequired() {
        return true;
    }

    @Override
    protected List<String> getHelp(EndGameContext context) {
        return HELP;
    }

    @Override
    protected List<DrawableObject> getMainDrawableObjects(EndGameContext context) {
        String label = context.isSuccess() ? "end.txt" : "gameover.txt";
        char[][] content = ResourceUtils.readResourceAsArray("images/" + label);
        int adjustedY = Settings.MAIN_BOARD_HEIGHT / 3 - content.length / 2;
        int adjustedX = Settings.TOTAL_WIDTH / 2 - DrawingUtils.getMaxWidth(content) / 2;
        return Collections.singletonList(new DrawableObject(adjustedX, adjustedY, content));
    }
}

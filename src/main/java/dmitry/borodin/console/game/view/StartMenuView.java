package dmitry.borodin.console.game.view;

import dmitry.borodin.console.game.Settings;
import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.utils.ResourceUtils;
import dmitry.borodin.console.game.view.utils.DrawableObject;
import dmitry.borodin.console.game.view.utils.DrawingUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StartMenuView extends CommonView<CommonContext> {

    private static final List<String> HELP = Arrays.asList(
            "Press q - to quit",
            "Press n - to start new game",
            "Press l - to load saved game"
    );

    @Override
    protected boolean isHelpRequired() {
        return true;
    }

    @Override
    protected List<DrawableObject> getMainDrawableObjects(CommonContext context) {
        return Collections.singletonList(readLogo());
    }

    @Override
    protected List<String> getHelp(CommonContext context) {
        return HELP;
    }

    private DrawableObject readLogo() {
        char[][] content = ResourceUtils.readResourceAsArray("images/logo.txt");
        int adjustedY = Settings.MAIN_BOARD_HEIGHT / 3 - content.length / 2;
        int adjustedX = Settings.TOTAL_WIDTH / 2 - DrawingUtils.getMaxWidth(content) / 2;
        return new DrawableObject(adjustedX, adjustedY, content);
    }

}

package dmitry.borodin.console.game.view;

import dmitry.borodin.console.game.Settings;
import dmitry.borodin.console.game.model.ReturnContext;
import dmitry.borodin.console.game.utils.ResourceUtils;
import dmitry.borodin.console.game.view.utils.DrawableObject;
import dmitry.borodin.console.game.view.utils.DrawingUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CharacterCreatorView extends CommonView<ReturnContext> {


    private static final List<String> HELP = Arrays.asList(
            "Press 1-3 - to choose character",
            "Press b - to get back"
    );

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
        List<DrawableObject> objects = new ArrayList<>();
        objects.addAll(getSnowmen());
        objects.addAll(getNumbers());
        return objects;
    }

    private List<DrawableObject> getSnowmen() {
        char[][] pl1Content = ResourceUtils.readResourceAsArray("images/pl_1.txt");
        char[][] pl2Content = ResourceUtils.readResourceAsArray("images/pl_2.txt");
        char[][] pl3Content = ResourceUtils.readResourceAsArray("images/pl_3.txt");
        int adjustedY = Settings.MAIN_BOARD_HEIGHT / 4 - pl1Content.length / 2;
        int adjustedX = Settings.TOTAL_WIDTH / 4 - DrawingUtils.getMaxWidth(pl1Content) / 2;
        DrawableObject sm1 = new DrawableObject(adjustedX, adjustedY, pl1Content);

        adjustedY = Settings.MAIN_BOARD_HEIGHT / 4 - pl2Content.length / 2;
        adjustedX = Settings.TOTAL_WIDTH / 2 - DrawingUtils.getMaxWidth(pl2Content) / 2;
        DrawableObject sm2 = new DrawableObject(adjustedX, adjustedY, pl2Content);

        adjustedY = Settings.MAIN_BOARD_HEIGHT / 4 - pl3Content.length / 2;
        adjustedX = 3 * Settings.TOTAL_WIDTH / 4 - DrawingUtils.getMaxWidth(pl3Content) / 2;
        DrawableObject sm3 = new DrawableObject(adjustedX, adjustedY, pl3Content);

        return Arrays.asList(sm1, sm2, sm3);
    }

    private List<DrawableObject> getNumbers() {
        char[][] oneContent = ResourceUtils.readResourceAsArray("images/one.txt");
        char[][] twoContent = ResourceUtils.readResourceAsArray("images/two.txt");
        char[][] threeContent = ResourceUtils.readResourceAsArray("images/three.txt");
        int adjustedY = Settings.MAIN_BOARD_HEIGHT / 2 - oneContent.length / 2;
        int adjustedX = Settings.TOTAL_WIDTH / 4 - DrawingUtils.getMaxWidth(oneContent) / 2;
        DrawableObject one = new DrawableObject(adjustedX, adjustedY, oneContent);

        adjustedY = Settings.MAIN_BOARD_HEIGHT / 2 - twoContent.length / 2;
        adjustedX = Settings.TOTAL_WIDTH / 2 - DrawingUtils.getMaxWidth(twoContent) / 2;
        DrawableObject two = new DrawableObject(adjustedX, adjustedY, twoContent);

        adjustedY = Settings.MAIN_BOARD_HEIGHT / 2 - threeContent.length / 2;
        adjustedX = 3 * Settings.TOTAL_WIDTH / 4 - DrawingUtils.getMaxWidth(threeContent) / 2;
        DrawableObject three = new DrawableObject(adjustedX, adjustedY, threeContent);

        return Arrays.asList(one, two, three);
    }
}

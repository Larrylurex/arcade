package dmitry.borodin.console.game.view;

import dmitry.borodin.console.game.Settings;
import dmitry.borodin.console.game.model.LoadGameContext;
import dmitry.borodin.console.game.utils.ResourceUtils;
import dmitry.borodin.console.game.view.utils.DrawableObject;
import dmitry.borodin.console.game.view.utils.DrawingUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadGameView extends CommonView<LoadGameContext> {


    @Override
    protected boolean isHelpRequired() {
        return true;
    }

    @Override
    protected List<String> getHelp(LoadGameContext context) {
        List<String> help = new ArrayList<>();
        String chooseGame;
        List<String> users = context.getCurrentPageUsers();
        if (users.isEmpty()) {
            chooseGame = "No saved games";
        } else {
            int from = (context.getCurrentPage() * context.getPageSize()) + 1;
            int to = users.size() + (context.getCurrentPage() * context.getPageSize());
            if (from == to) {
                chooseGame = "Press " + from + " to choose a game";

            } else {
                chooseGame = "Press " + from + " - " + to + " to choose a game";

            }
        }
        help.add(chooseGame);
        if (context.hasNextPage()) {
            help.add("Press n - to see next page");
        }
        if (context.getCurrentPage() > 0) {
            help.add("Press p - to see previous page");
        }
        help.add("Press b - to get back");
        return help;
    }

    @Override
    protected List<DrawableObject> getMainDrawableObjects(LoadGameContext context) {
        DrawableObject label = getLabel();
        char[][] userObjContent = getUserObj(context);

        int adjustedY = label.getHeight() + 5;
        int adjustedX = Settings.TOTAL_WIDTH / 2 - DrawingUtils.getMaxWidth(userObjContent) / 2;
        DrawableObject userObj = new DrawableObject(adjustedX, adjustedY, userObjContent);

        return Arrays.asList(label, userObj);
    }

    private DrawableObject getLabel() {
        char[][] content = ResourceUtils.readResourceAsArray("images/saved_games.txt");
        int adjustedY = Settings.MAIN_BOARD_HEIGHT / 5 - content.length / 2;
        int adjustedX = Settings.TOTAL_WIDTH / 2 - DrawingUtils.getMaxWidth(content) / 2;
        return new DrawableObject(adjustedX, adjustedY, content);
    }

    private char[][] getUserObj(LoadGameContext context) {
        List<String> content = new ArrayList<>();
        List<String> users = context.getCurrentPageUsers();
        for (int i = 0; i < users.size(); i++) {
            int index = context.getCurrentPage() * context.getPageSize() + i + 1;
            String margin = index < 10 ? "    " : "   ";

            content.add(index + "." + margin + users.get(i));
        }
        return content.stream()
                .map(String::toCharArray)
                .toArray(char[][]::new);
    }
}

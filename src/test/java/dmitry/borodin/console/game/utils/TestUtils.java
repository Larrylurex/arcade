package dmitry.borodin.console.game.utils;

import dmitry.borodin.console.game.command.factory.CommandFactory;
import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.stage.CommonStage;
import dmitry.borodin.console.game.stage.Stage;
import dmitry.borodin.console.game.view.View;

public class TestUtils {

    public static <T extends CommonContext>  Stage getDummyStage(T context) {
        return new CommonStage<T>(context){

            @Override
            protected View<T> getView() {
                return null;
            }

            @Override
            protected CommandFactory<T> getCommandFactory() {
                return null;
            }
        };
    }
}

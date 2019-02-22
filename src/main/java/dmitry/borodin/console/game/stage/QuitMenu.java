package dmitry.borodin.console.game.stage;

import dmitry.borodin.console.game.command.factory.CommandFactory;
import dmitry.borodin.console.game.command.factory.QuitMenuCommandFactory;
import dmitry.borodin.console.game.model.ReturnContext;
import dmitry.borodin.console.game.view.QuitMenuView;
import dmitry.borodin.console.game.view.View;

public class QuitMenu extends CommonStage<ReturnContext> {

    public QuitMenu(ReturnContext context) {
        super(context);
    }

    @Override
    protected View<ReturnContext> getView() {
        return new QuitMenuView();
    }

    @Override
    protected CommandFactory<ReturnContext> getCommandFactory() {
        return new QuitMenuCommandFactory();
    }
}

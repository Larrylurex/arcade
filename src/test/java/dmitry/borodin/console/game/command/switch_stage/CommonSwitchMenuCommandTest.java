package dmitry.borodin.console.game.command.switch_stage;

import dmitry.borodin.console.game.command.Command;
import dmitry.borodin.console.game.model.CommonContext;
import dmitry.borodin.console.game.stage.CommonStage;
import dmitry.borodin.console.game.stage.Stage;
import dmitry.borodin.console.game.utils.TestUtils;
import org.junit.Assert;

import java.lang.reflect.Field;

public abstract class CommonSwitchMenuCommandTest<T extends CommonContext> {

    protected void checkSwitch(T context, Class clazz) {
        getCommand().apply(context);
        Assert.assertFalse("Current stage stopped", context.getCurrentStage().isRunning());
        Assert.assertTrue("Next stage wrong", clazz.isInstance(context.getNextStage()));
        Assert.assertTrue("Next stage started", context.getNextStage().isRunning());
    }

    protected Object getContextFromStage(CommonStage stage) throws NoSuchFieldException, IllegalAccessException {
        Field context = CommonStage.class.getDeclaredField("context");
        context.setAccessible(true);
        return context.get(stage);
    }

    protected CommonContext getCommonContext() {
        CommonContext context = new CommonContext();
        Stage dummyStage = TestUtils.getDummyStage(context);
        dummyStage.setRunning(true);
        context.setCurrentStage(dummyStage);
        return context;
    }

    protected abstract Command<T> getCommand();
}

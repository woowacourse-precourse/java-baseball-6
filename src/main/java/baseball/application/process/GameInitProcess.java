package baseball.application.process;

import baseball.application.context.BaseballContext;
import baseball.application.context.IoContext;
import baseball.application.process.base.BaseballProcess;

public class GameInitProcess implements BaseballProcess {

    private final String next = "playerInputProcess";

    @Override
    public void execute(BaseballContext baseballContext, IoContext ioContext) {
        baseballContext.init();
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public String next() {
        return next;
    }
}

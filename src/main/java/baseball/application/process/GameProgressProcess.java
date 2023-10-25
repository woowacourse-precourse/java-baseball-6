package baseball.application.process;

import baseball.application.context.BaseballContext;
import baseball.application.context.IoContext;
import baseball.application.process.base.BaseballProcess;
import baseball.domain.compararesult.CompareResult;

public class GameProgressProcess implements BaseballProcess {

    private String next = "gameEndProcess";

    @Override
    public void execute(BaseballContext baseballContext, IoContext ioContext) {
        CompareResult result = baseballContext.compareNumbers();
        ioContext.println(result.toString());
        determineNextProcess(result);
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public String next() {
        return next;
    }

    private void determineNextProcess(CompareResult result) {
        if (result.isAnswer()) {
            next = "gameEndProcess";
        }
        if (!result.isAnswer()) {
            next = "playerInputProcess";
        }
    }
}

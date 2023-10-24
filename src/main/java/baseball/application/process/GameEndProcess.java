package baseball.application.process;

import baseball.application.context.BaseballContext;
import baseball.application.context.IoContext;
import baseball.application.process.base.BaseballProcess;

public class GameEndProcess implements BaseballProcess {

    private static final String ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String next = "determineRestartProcess";

    @Override
    public void execute(BaseballContext baseballContext, IoContext ioContext) {
        ioContext.println(ANSWER_MESSAGE);
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

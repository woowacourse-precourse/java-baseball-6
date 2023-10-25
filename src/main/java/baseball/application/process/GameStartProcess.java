package baseball.application.process;

import baseball.application.context.BaseballContext;
import baseball.application.context.IoContext;
import baseball.application.process.base.BaseballProcess;

public class GameStartProcess implements BaseballProcess {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String next = "gameInitProcess";

    @Override
    public void execute(BaseballContext baseballContext, IoContext ioContext) {
        ioContext.println(GAME_START_MESSAGE);
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

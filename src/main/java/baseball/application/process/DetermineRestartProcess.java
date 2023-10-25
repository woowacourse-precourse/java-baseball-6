package baseball.application.process;

import baseball.application.context.BaseballContext;
import baseball.application.context.IoContext;
import baseball.application.process.base.BaseballProcess;
import baseball.domain.restartflag.RestartFlag;

public class DetermineRestartProcess implements BaseballProcess {

    private static final String ASK_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private String next = "applicationEndProcess";

    @Override
    public void execute(BaseballContext baseballContext, IoContext ioContext) {
        ioContext.println(ASK_RESTART_MESSAGE);
        String input = ioContext.readLine();
        RestartFlag flag = baseballContext.inputRestartFlag(input);
        determineNextProcess(flag);
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public String next() {
        return next;
    }

    private void determineNextProcess(RestartFlag flag) {
        if (flag.isRestart()) {
            next = "gameInitProcess";
        }
        if (!flag.isRestart()) {
            next = "applicationEndProcess";
        }
    }
}

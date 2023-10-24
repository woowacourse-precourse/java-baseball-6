package baseball.application.process;

import baseball.application.context.BaseballContext;
import baseball.application.context.IoContext;
import baseball.application.process.base.BaseballProcess;

public class ApplicationEndProcess implements BaseballProcess {

    private static final String ERROR_MESSAGE_CANNOT_EXECUTE_MORE = "더 이상 진행할 수 없습니다.";

    @Override
    public void execute(BaseballContext baseballContext, IoContext ioContext) {
        throw new IllegalArgumentException(ERROR_MESSAGE_CANNOT_EXECUTE_MORE);
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public String next() {
        throw new IllegalArgumentException(ERROR_MESSAGE_CANNOT_EXECUTE_MORE);
    }
}

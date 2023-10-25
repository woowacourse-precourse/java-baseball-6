package baseball.application.process.base;

import baseball.application.context.BaseballContext;
import baseball.application.context.IoContext;

public interface BaseballProcess {

    void execute(BaseballContext baseballContext, IoContext ioContext);

    boolean hasNext();

    String next();
}

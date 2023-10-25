package baseball.application.process;

import static org.mockito.Mockito.mock;

import baseball.application.context.BaseballContext;
import baseball.application.context.IoContext;

public abstract class BaseballProcessTest {

    final BaseballContext baseballContext = mock(BaseballContext.class);
    final IoContext ioContext = mock(IoContext.class);
}

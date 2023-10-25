package baseball.application.process;

import baseball.application.context.BaseballContext;
import baseball.application.context.IoContext;
import baseball.application.process.base.BaseballProcess;

public class PlayerInputProcess implements BaseballProcess {

    private static final String PLAYER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    private final String next = "gameProgressProcess";

    @Override
    public void execute(BaseballContext baseballContext, IoContext ioContext) {
        ioContext.print(PLAYER_INPUT_MESSAGE);
        String input = ioContext.readLine();
        baseballContext.changePlayerNumber(input);
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

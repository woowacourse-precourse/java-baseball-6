package baseball.View;

import baseball.Exception.ReplayOrQuitGameException;
import camp.nextstep.edu.missionutils.Console;

public class NextGamePlayerInputView {
    private final ReplayOrQuitGameException replayOrQuitGameException = new ReplayOrQuitGameException();

    public int nextGameSetup() {
        String numberAfterGameEnd = Console.readLine();
        replayOrQuitGameException.selectReplayOrQuitGameException(numberAfterGameEnd);
        return Integer.parseInt(numberAfterGameEnd);
    }
}

package baseball.view;

import baseball.exception.AfterGamePlayException;
import camp.nextstep.edu.missionutils.Console;

public class NextGameUserInputView {
    private final AfterGamePlayException afterGamePlayException = new AfterGamePlayException();

    public int askNextGame() {
        String numberAfterGameEnd = Console.readLine();
        afterGamePlayException.askAfterResultException(numberAfterGameEnd);
        return Integer.valueOf(numberAfterGameEnd);
    }
}
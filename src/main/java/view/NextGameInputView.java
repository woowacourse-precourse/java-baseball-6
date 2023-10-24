package view;

import camp.nextstep.edu.missionutils.Console;
import util.ValidationCheck;

public class NextGameInputView {
    private final ValidationCheck validationCheck = new ValidationCheck();

    public int nextGameSetup() {
        String numberAfterGameEnd = Console.readLine();
        validationCheck.selectReplayOrQuitGameException(numberAfterGameEnd);
        return Integer.parseInt(numberAfterGameEnd);
    }
}

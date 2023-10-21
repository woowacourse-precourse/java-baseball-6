package baseball.view;

import static baseball.util.Validator.checkCanChangeToInteger;
import static baseball.util.Validator.checkIsBlank;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final OutputView outputView;

    public InputView(final OutputView outputView) {
        this.outputView = outputView;
    }

    public String readGuessNumbers() {
        try {
            String guessNumbers = Console.readLine();
            checkIsBlank(guessNumbers);
            checkCanChangeToInteger(guessNumbers);
            return guessNumbers;
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            return readGuessNumbers();
        }
    }

    public String readGameStateNumber() {
        try {
            String gameState = Console.readLine();
            checkIsBlank(gameState);
            checkCanChangeToInteger(gameState);
            return gameState;
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            return readGameStateNumber();
        }
    }
}

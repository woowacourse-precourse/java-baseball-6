package baseball.io;

import baseball.model.Score;
import baseball.utils.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class UserIOHandler {
    public void displayGameStartMessage() {
        OutputView.printGameStartMessage();
    }

    public void displayRoundOutcome(Score score) {
        OutputView.printRoundResult(score);
    }

    public String readUserInputForNumbers() {
        return InputView.readUserInputForNumbers();
    }

    public List<Integer> validateAndParseUserInput(String userInput) {
        InputValidator.validateUserInput(userInput);
        return userInput.chars().mapToObj(Character::getNumericValue).toList();
    }

    public String readUserInputForRestart() {
        return InputView.readUserInputForRestart();
    }
}

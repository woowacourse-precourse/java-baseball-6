package baseball.input;

import baseball.game.GameConstants;
import camp.nextstep.edu.missionutils.Console;

public class GameSceneInput {
    public GameSceneInput() {
        // Empty
    }

    public String getUserInput() {
        final String userInput = Console.readLine();
        validateUserInputLengthSizeRandomNumber(userInput);
        return userInput;
    }

    private void validateUserInputLengthSizeRandomNumber(final String userInput) {
        if (userInput.length() != GameConstants.SIZE_RANDOM_NUMBER) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }
    }
}

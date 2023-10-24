package baseball.domain.validators;

import baseball.domain.constants.NumberBaseballConstants;

public class NumberBaseballValidator {

    public void validateContinueGame(int userChoice) {
        if(
                userChoice != NumberBaseballConstants.CONTINUE_GAME &&
                userChoice != NumberBaseballConstants.GAME_OVER
        )
            throw new IllegalArgumentException(
                    NumberBaseballConstants.CONTINUE_GAME +
                    " 또는 " +
                    NumberBaseballConstants.GAME_OVER +
                    "만 입력 가능합니다.");
    }
}

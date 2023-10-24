package baseball.console.game.numberbaseball.domain.user;

import baseball.console.game.numberbaseball.config.ExceptionMessage;
import baseball.console.game.numberbaseball.util.NumberUtils;

public class UserPredictionValidator {
    public static void validate(String userPrediction) throws IllegalArgumentException {
        try {
            int number = Integer.parseInt(userPrediction);

            if (!isThreeDigitNumber(number))
                throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_THREE_DIGITS + number);

            if (NumberUtils.hasDuplicateDigits(number))
                throw new IllegalArgumentException(ExceptionMessage.INVALID_HAS_DUPLICATE_DIGITS + number);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_INTEGER + userPrediction);
        }
    }

    private static boolean isThreeDigitNumber(int number) {
        return 100 < number && number < 999;
    }
}

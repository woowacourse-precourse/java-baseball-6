package baseball.console.game.numberbaseball.domain.user;

import baseball.console.game.numberbaseball.util.NumberUtils;

public class UserPredictionValidator {
    public static void validate(String userPrediction) throws IllegalArgumentException {
        try {
            int number = Integer.parseInt(userPrediction);

            if (!(100 < number && number < 999))
                throw new IllegalArgumentException("입력값은 세 자리 정수이어야 합니다.");
            if (NumberUtils.hasDuplicateDigits(number))
                throw new IllegalArgumentException("입력값은 각 자리 숫자가 모두 달라야합니다.");

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다.");
        }
    }
}

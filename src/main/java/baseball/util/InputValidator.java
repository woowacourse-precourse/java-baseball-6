package baseball.util;

import static baseball.domain.Constant.BALLS_LENGTH;
import static baseball.domain.Constant.NUMBER_FORMAT;
import static baseball.domain.ErrorMessage.BALL_NUMBER_IS_NOT_NUMBER;
import static baseball.domain.ErrorMessage.BALL_NUMBER_IS_DUPLICATED;
import static baseball.domain.ErrorMessage.BALL_NUMBER_SIZE_IS_NOT_MATCHED;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public static void validateBalls(String rawBalls) {
        validateNumber(rawBalls);
        List<Integer> rawBallList = InputConvertor.convertStringToList(rawBalls);
        InputValidator.validateBallsCount(rawBallList);
        InputValidator.valdateDuplicates(rawBallList);
    }

    private static void validateNumber(String rawBalls) {
        if (!isNumber(rawBalls)) {
            throw new IllegalArgumentException(BALL_NUMBER_IS_NOT_NUMBER);
        }
    }

    private static boolean isNumber(String rawBalls) {
        return rawBalls.matches(NUMBER_FORMAT);
    }

    public static void validateBallsCount(List<Integer> rawBallList) {
        if (!hasThreeDigits(rawBallList)) {
            throw new IllegalArgumentException(BALL_NUMBER_SIZE_IS_NOT_MATCHED);
        }
    }

    private static boolean hasThreeDigits(List<Integer> ballList) {
        return ballList.size() == BALLS_LENGTH;
    }

    public static void valdateDuplicates(List<Integer> rawBallList) {
        if (hasDuplicatesInList(rawBallList)) {
            throw new IllegalArgumentException(BALL_NUMBER_IS_DUPLICATED);
        }
    }

    private static boolean hasDuplicatesInList(List<Integer> ballList) {
        Set<Integer> ballSet = new HashSet<>(ballList);
        return ballSet.size() != ballList.size();
    }
}

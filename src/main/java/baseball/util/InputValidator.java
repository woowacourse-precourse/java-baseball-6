package baseball.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    private static final int BALL_COUNT = 3;
    private static final String NUMBER_FORMAT = "\\d+";
    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "[ERROR] 올바른 숫자를 입력해주세요.";
    private static final String NUMBER_COUNT_EXCEPTION_MESSAGE = "[ERROR] 3자리의 숫자를 입력해주세요.";
    private static final String DUPLICATES_EXCEPTION_MESSAGE = "[ERROR] 중복되지 않는 3자리의 숫자를 입력해주세요.";

    public static void validateBalls(String rawBalls) {
        validateNumber(rawBalls);
        List<Integer> rawBallList = InputConvertor.convertStringToList(rawBalls);
        InputValidator.validateBallsCount(rawBallList);
        InputValidator.valdateDuplicates(rawBallList);
    }

    private static void validateNumber(String rawBalls) {
        if (!isNumber(rawBalls)) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isNumber(String rawBalls) {
        return rawBalls.matches(NUMBER_FORMAT);
    }

    public static void validateBallsCount(List<Integer> rawBallList) {
        if (!hasThreeDigits(rawBallList)) {
            throw new IllegalArgumentException(NUMBER_COUNT_EXCEPTION_MESSAGE);
        }
    }

    private static boolean hasThreeDigits(List<Integer> ballList) {
        return ballList.size() == BALL_COUNT;
    }

    public static void valdateDuplicates(List<Integer> rawBallList) {
        if (hasDuplicatesInList(rawBallList)) {
            throw new IllegalArgumentException(DUPLICATES_EXCEPTION_MESSAGE);
        }
    }

    private static boolean hasDuplicatesInList(List<Integer> ballList) {
        Set<Integer> ballSet = new HashSet<>(ballList);
        return ballSet.size() != ballList.size();
    }


}

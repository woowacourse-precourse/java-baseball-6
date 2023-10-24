package baseball;

import static baseball.GameClient.BALL_LENGTH;
import static baseball.GameClient.RANGE_MAXIMUM_VALUE;
import static baseball.GameClient.RANGE_MINIMUM_VALUE;

import java.util.List;

/**
 * 사용자의 입력을 검증하는 클래스.
 * <p>단순한 입력 검증이 목표이며, 검증 성공 여부만을 알려준다.
 */
public class NumbersInputValidator {

    private NumbersInputValidator() {
    }

    public static boolean validatePlayerNumbers(List<Integer> playerNumbers) {
        return validateNumberCount(playerNumbers) &&
                validateDistinctNumbers(playerNumbers) &&
                validateNumbersInRange(playerNumbers);
    }

    private static boolean validateNumberCount(List<Integer> numbers) {
        return numbers.size() == BALL_LENGTH;
    }

    private static boolean validateDistinctNumbers(List<Integer> numbers) {
        long distinctNumberCount = numbers.stream()
                .distinct()
                .count();
        return distinctNumberCount == numbers.size();
    }

    private static boolean validateNumbersInRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(NumbersInputValidator::validateNumberInRange);
    }

    private static boolean validateNumberInRange(Integer number) {
        return RANGE_MINIMUM_VALUE <= number && number <= RANGE_MAXIMUM_VALUE;
    }
}

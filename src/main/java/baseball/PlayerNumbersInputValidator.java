package baseball;

import static baseball.GameClient.BALL_LENGTH;
import static baseball.GameClient.RANGE_MAXIMUM_VALUE;
import static baseball.GameClient.RANGE_MINIMUM_VALUE;

import java.util.List;

/**
 * 사용자의 입력을 검증하는 클래스.
 * <p>단순한 입력 검증이 목표이며, 검증 성공 여부만을 알려준다. 추가적인 예외 발생 등은 PlayerInput에서 처리한다.
 */
public class PlayerNumbersInputValidator {

    public boolean validatePlayerNumbers(List<Integer> playerNumbers) {
        return validateNumberCount(playerNumbers) &&
                validateDistinctNumbers(playerNumbers) &&
                validateNumbersInRange(playerNumbers);
    }

    private boolean validateNumberCount(List<Integer> numbers) {
        return numbers.size() == BALL_LENGTH;
    }

    private boolean validateDistinctNumbers(List<Integer> numbers) {
        long distinctNumberCount = numbers.stream()
                .distinct()
                .count();
        return distinctNumberCount == numbers.size();
    }

    private boolean validateNumbersInRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(this::validateNumberInRange);
    }

    private boolean validateNumberInRange(Integer number) {
        return RANGE_MINIMUM_VALUE <= number && number <= RANGE_MAXIMUM_VALUE;
    }
}

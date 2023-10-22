package baseball.dto.validator;

import baseball.dto.BattedBallsDTO;
import baseball.exception.BallDuplicatedException;
import baseball.exception.InvalidBallContentException;
import baseball.exception.InvalidBallCountException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BattedBallsValidatorTest {

    private static final String INVALID_COUNT = "1234";
    private static final String INVALID_BALL_CONTENT = "abc";
    private static final String ZERO_IN_BALL = "012";
    private static final String DUPLICATED_BALLS = "111";

    private final BattedBallsValidator battedBallsValidator = new BattedBallsValidator();

    @Test
    void 공_개수_예외_테스트() {
        assertValidationWorks(INVALID_COUNT, InvalidBallCountException.class);
    }

    @Test
    void 공에_숫자_아닌_값_포함_예외_테스트() {
        assertValidationWorks(INVALID_BALL_CONTENT, InvalidBallContentException.class);
    }

    @Test
    void 공에_0_포함_예외_테스트() {
        assertValidationWorks(ZERO_IN_BALL, InvalidBallContentException.class);
    }

    @Test
    void 중복된_숫자_예외_테스트() {
        assertValidationWorks(DUPLICATED_BALLS, BallDuplicatedException.class);
    }

    private void assertValidationWorks(String invalidInput, Class<?> expectedException) {
        BattedBallsDTO battedBallsDTO = getBattedBalls(invalidInput);
        assertThatThrownBy(() -> battedBallsValidator.validate(battedBallsDTO))
                .isInstanceOf(expectedException);
    }

    private static BattedBallsDTO getBattedBalls(String battedBalls) {
        return BattedBallsDTO.from(battedBalls);
    }
}

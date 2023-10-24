package baseball.service;

import baseball.domain.Ball;
import baseball.domain.BaseballNumber;
import baseball.domain.BaseballResult;
import baseball.domain.Strike;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseballServiceTest {
    private BaseballService baseballService;

    @BeforeEach
    public void setUp() {
        baseballService = new BaseballService();
    }
    @DisplayName("야구 게임 결과 계산 테스트")
    @ParameterizedTest
    @MethodSource("generateUserNumbers")
    public void 야구_게임_결과_계산(BaseballNumber playerNumber, BaseballResult expected) {
        BaseballNumber computerNumber = new BaseballNumber(1, 2, 3);

        BaseballResult result = baseballService.calculateResult(computerNumber, playerNumber);

        assertEquals(expected.toString(), result.toString());
    }
    static Stream<Arguments> generateUserNumbers() {
        return Stream.of(
                Arguments.of(new BaseballNumber(1, 2, 3), new BaseballResult(Strike.THREE, Ball.ZERO)),
                Arguments.of(new BaseballNumber(4, 2, 3), new BaseballResult(Strike.TWO, Ball.ZERO)),
                Arguments.of(new BaseballNumber(4, 5, 3), new BaseballResult(Strike.ONE, Ball.ZERO)),
                Arguments.of(new BaseballNumber(4, 1, 5), new BaseballResult(Strike.ZERO, Ball.ONE)),
                Arguments.of(new BaseballNumber(4, 1, 2), new BaseballResult(Strike.ZERO, Ball.TWO)),
                Arguments.of(new BaseballNumber(2, 3, 1), new BaseballResult(Strike.ZERO, Ball.THREE)),
                Arguments.of(new BaseballNumber(1, 4, 2), new BaseballResult(Strike.ONE, Ball.ONE)),
                Arguments.of(new BaseballNumber(1, 3, 2), new BaseballResult(Strike.ONE, Ball.TWO)),
                Arguments.of(new BaseballNumber(4, 5, 6), new BaseballResult(Strike.ZERO, Ball.ZERO))
        );
    }
}

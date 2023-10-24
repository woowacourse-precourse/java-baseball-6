package baseball.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BaseBallResultTest {

    @ParameterizedTest
    @MethodSource("provideStrikeBaseBallResult")
    void isAllStrike_메소드_모두_스트라이크일시_true_반환(final List<Integer> numbers, final boolean expected) {
        final BaseBallResult baseBallResult = new BaseBallResult(
                new BaseBallNumberGroup(List.of(1, 2, 3)),
                new BaseBallNumberGroup(numbers)
        );

        assertThat(baseBallResult.isAllStrike()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideStrikeBaseBallResult() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), true),
                Arguments.of(List.of(1, 2, 4), false)
        );
    }

    @Test
    void getBallAndStrike_메소드_볼과_스트라이크가_담긴_BallAndStrike_객체_반환() {
        BaseBallResult baseBallResult = new BaseBallResult(
                new BaseBallNumberGroup(List.of(1, 2, 3)),
                new BaseBallNumberGroup(List.of(1, 3, 4))
        );

        BallAndStrike ballAndStrike = baseBallResult.getBallAndStrike();
        assertThat(ballAndStrike).isEqualTo(new BallAndStrike(1, 1));
    }
}

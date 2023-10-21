package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RefereeTest {
    @ParameterizedTest
    @MethodSource("eachPossibleCase")
    @DisplayName("Referee가 Computer & User 간 숫자 야구 게임 결과(RoundResult)를 도출한다")
    void judge(
            final List<Integer> computerBaseballs,
            final List<Integer> userBaseballs,
            final int strikeCount,
            final int ballCount,
            final boolean isClear
    ) {
        // when
        final RoundResult result = Referee.judge(computerBaseballs, userBaseballs);

        // then
        assertAll(
                () -> assertThat(result.strikeCount()).isEqualTo(strikeCount),
                () -> assertThat(result.ballCount()).isEqualTo(ballCount),
                () -> assertThat(result.isClear()).isEqualTo(isClear)
        );
    }

    private static Stream<Arguments> eachPossibleCase() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(4, 5, 6), 0, 0, false), // nothing
                Arguments.of(List.of(1, 2, 3), List.of(4, 5, 1), 0, 1, false), // 1 ball
                Arguments.of(List.of(1, 2, 3), List.of(2, 1, 5), 0, 2, false), // 2 ball
                Arguments.of(List.of(1, 2, 3), List.of(3, 1, 2), 0, 3, false), // 3 ball
                Arguments.of(List.of(1, 2, 3), List.of(1, 4, 5), 1, 0, false), // 1 strike
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 5), 2, 0, false), // 2 strike
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), 3, 0, true), // 3 strike (clear)
                Arguments.of(List.of(1, 2, 3), List.of(1, 3, 5), 1, 1, false), // 1 strike + 1 ball
                Arguments.of(List.of(1, 2, 3), List.of(1, 3, 2), 1, 2, false) // 1 strike + 2 ball
        );
    }
}

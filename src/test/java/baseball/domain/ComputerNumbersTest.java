package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ComputerNumbersTest {

    @AfterEach
    void resetBallCounter() {
        BallCounter.reset();
    }

    @DisplayName("같은 숫자가 같은 자리에 있으면 스트라이크의 개수가 1 증가하고, 같은 숫자가 다른 자리에 있으면 볼의 개수가 1 증가한다.")
    @ParameterizedTest
    @MethodSource("parametersForTest")
    void ㅇ(List<Integer> computerNumberList, List<Integer> playerNumberList, int countOfBall, int countOfStrike) {
        // given
        ComputerNumbers computerNumbers = new ComputerNumbers(computerNumberList);

        // when
        computerNumbers.checkPlayerNumbers(playerNumberList, 3);

        // then
        assertThat(BallCounter.getCountOfBall()).isEqualTo(countOfBall);
        assertThat(BallCounter.getCountOfStrike()).isEqualTo(countOfStrike);
    }

    static Stream<Arguments> parametersForTest() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(1, 4, 5), 0, 1),
                Arguments.of(List.of(1, 2, 3), List.of(2, 4, 5), 1, 0),
                Arguments.of(List.of(1, 2, 3), List.of(1, 3, 5), 1, 1),
                Arguments.of(List.of(1, 2, 3), List.of(7, 6, 5), 0, 0)
        );
    }
}
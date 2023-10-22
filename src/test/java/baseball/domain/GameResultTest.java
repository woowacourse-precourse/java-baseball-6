package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameResultTest {

    private static Stream<Arguments> generateBallCount() {
        return Stream.of(
                Arguments.of(new GameResult(1, 2), "2볼 1스트라이크"),
                Arguments.of(new GameResult(0, 0), "낫싱"),
                Arguments.of(new GameResult(3, 0), "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        );
    }

    private static Stream<Arguments> generateCount() {
        return Stream.of(
                Arguments.of(new GameResult(1, 2), false),
                Arguments.of(new GameResult(3, 0), true)
        );
    }

    @DisplayName("결과에 대한 문자열을 정상적으로 반환한다")
    @ParameterizedTest(name = "[{index}] Input : {0} ")
    @MethodSource("generateBallCount")
    void createResult(GameResult gameResult, String result) {
        assertThat(gameResult.getResult()).isEqualTo(result);
    }

    @DisplayName("결과에 따른 승리 여부를 반환한다")
    @ParameterizedTest(name = "[{index}] Input : {0} ")
    @MethodSource("generateCount")
    void checkWin(GameResult gameResult, boolean result) {
        assertThat(gameResult.isWin()).isEqualTo(result);
    }
}

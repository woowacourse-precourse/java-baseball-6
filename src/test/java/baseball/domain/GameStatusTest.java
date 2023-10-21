package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class GameStatusTest {
    @DisplayName("게임 상태가 실행중인지 아닌지 테스트")
    @ParameterizedTest
    @MethodSource("createGameStatusData")
    void 게임_상태_테스트(GameStatus gameStatus, boolean run) {
        assertThat(GameStatus.isRun(gameStatus)).isEqualTo(run);
    }
    private static Stream<Arguments> createGameStatusData() {
        return Stream.of(
                Arguments.of(GameStatus.RUN, true),
                Arguments.of(GameStatus.STOP, false)
        );
    }
}
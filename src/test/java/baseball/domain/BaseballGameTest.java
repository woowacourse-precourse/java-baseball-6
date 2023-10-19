package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

class BaseballGameTest {

    @ParameterizedTest
    @MethodSource("ballsAndPlayResult")
    @DisplayName("컴퓨터의 숫자와 플레이어의 숫자를 통해 숫자 야구 게임을 진행하여 결과를 알 수 있다.")
    void play(Balls userBalls, PlayResult expected) {
        Balls computerBalls = new Balls(List.of(1, 2, 3));
        BaseballGame baseballGame = new BaseballGame(computerBalls);

        PlayResult actual = baseballGame.play(userBalls);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> ballsAndPlayResult() {
        return Stream.of(
                arguments(new Balls(List.of(1, 2, 3)), new PlayResult(3, 0)),
                arguments(new Balls(List.of(1, 4, 2)), new PlayResult(1, 1)),
                arguments(new Balls(List.of(4, 5, 6)), new PlayResult(0, 0))
        );
    }
}
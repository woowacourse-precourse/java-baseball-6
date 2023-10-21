package baseball.domain.game;

import baseball.domain.game.result.PlayResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

class BaseballGameTest {
    private BaseballGame baseballGame;

    @BeforeEach
    void setUp() {
        baseballGame = new BaseballGame() {
            @Override
            protected List<Integer> createRandomNumbers() {
                return List.of(1, 2, 3);
            }
        };
    }

    @ParameterizedTest
    @MethodSource("ballsAndPlayResult")
    @DisplayName("컴퓨터의 숫자와 플레이어의 숫자를 통해 숫자 야구 게임을 진행하여 결과를 알 수 있다.")
    void play(Balls userBalls, PlayResult expected) {
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

    @Test
    @DisplayName("플레이어가 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.")
    void isGameEnd() {
        Balls userBalls = new Balls(List.of(3, 4, 5));
        baseballGame.play(userBalls);
        assertThat(baseballGame.isGameEnd()).isFalse();

        userBalls = new Balls(List.of(1, 2, 3));
        baseballGame.play(userBalls);
        assertThat(baseballGame.isGameEnd()).isTrue();
    }

    @Test
    @DisplayName("게임을 다시 시작할 수 있다.")
    void restart() {
        Balls userBalls = new Balls(List.of(1, 2, 3));
        baseballGame.play(userBalls);
        assertThat(baseballGame.isGameEnd()).isTrue();

        baseballGame.restart();
        assertThat(baseballGame.isGameEnd()).isFalse();
    }

    @Test
    @DisplayName("게임이 종료되지 않은 상태에서 게임을 다시 시작하려 하면 예외가 발생한다.")
    void impossibleToRestart() {
        assertThat(baseballGame.isGameEnd()).isFalse();

        assertThatThrownBy(() -> baseballGame.restart())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임이 종료되지 않은 상태에서 게임을 다시 시작할 수 없습니다.");
    }
}
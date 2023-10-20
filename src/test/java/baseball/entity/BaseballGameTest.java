package baseball.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballGameTest {

    @DisplayName("숫자 야구 게임을 생성할 수 있다.")
    @Test
    void create() {
        BaseballGame baseballGame = BaseballGame.from(simpleBallsGenerator());
        BaseballGame otherBaseballGame = BaseballGame.from(simpleBallsGenerator());

        assertThat(baseballGame).isEqualTo(otherBaseballGame);
    }

    @DisplayName("알 수 없는 공 생성기(null)로 객체를 생성할 수 없다.")
    @Test
    void createWithNull() {
        assertThatThrownBy(() -> BaseballGame.from(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 공 생성기(null)로 객체를 생성할 수 없습니다.");
    }

    @DisplayName("게임 라운드를 실행할 수 있다.")
    @Test
    void play() {
        BaseballGame baseballGame = BaseballGame.from(simpleBallsGenerator());

        PlayResult playResult = baseballGame.play(Balls.from(List.of(2, 3, 6)));

        assertThat(playResult.getBallCount()).isEqualTo(2);
        assertThat(playResult.getStrikeCount()).isEqualTo(0);
    }

    private BallsGenerator simpleBallsGenerator() {
        return () -> Balls.from(List.of(1, 2, 3));
    }
}

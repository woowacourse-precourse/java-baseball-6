package baseball;

import baseball.domain.GameResult;
import baseball.domain.Player;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @Test
    void 유효한_입력_반환_테스트() {
        String input = "123";
        assertThat(player.getInputNumber(input)).containsExactly(1, 2, 3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12a", "1234", "0"})
    void 유효하지_않은_입력_예외_테스트(String invalidInput) {
        assertThatThrownBy(() -> player.getInputNumber(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유효한_재시작_옵션_테스트() {
        String validOption = "1";
        assertThat(player.receiveRetryOption(validOption)).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "abc"})
    void 유효하지_않은_재시작_옵션_예외_테스트(String invalidOption) {
        assertThatThrownBy(() -> player.receiveRetryOption(invalidOption))
                .isInstanceOf(IllegalArgumentException.class);
    }
}


class GameResultTest {

    @Test
    void 게임_초기_결과_테스트() {
        GameResult gameResult = GameResult.initialResult();
        assertThat(gameResult.getStrikes()).isEqualTo(0);
        assertThat(gameResult.getBalls()).isEqualTo(0);
        assertThat(gameResult.isGameOver()).isFalse();
    }

    @Test
    void 게임_종료_결과_테스트() {
        GameResult gameResult = new GameResult(3, 0);
        assertThat(gameResult.getStrikes()).isEqualTo(3);
        assertThat(gameResult.getBalls()).isEqualTo(0);
        assertThat(gameResult.isGameOver()).isTrue();
    }

    @Test
    void 게임_진행중_결과_테스트() {
        GameResult gameResult = new GameResult(1, 1);
        assertThat(gameResult.getStrikes()).isEqualTo(1);
        assertThat(gameResult.getBalls()).isEqualTo(1);
        assertThat(gameResult.isGameOver()).isFalse();
    }
}
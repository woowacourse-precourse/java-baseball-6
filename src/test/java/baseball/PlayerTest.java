package baseball;

import baseball.baseballV1.model.Ball;
import baseball.baseballV1.model.Player;
import baseball.baseballV1.model.TripleBalls;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerTest {
    private Player player;

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    void 올바른_범위_서로_다른_숫자_검증(String correctInput) {
        Assertions.assertThatNoException().isThrownBy(() -> player = new Player(correctInput));
    }

    @ParameterizedTest
    @ValueSource(strings = {"ab1", "한글1", "*/2", "0_1"})
    void 수가_아닌_경우_예외_발생(String threeButNotNumberInput) {
        Assertions.assertThatThrownBy(() -> player = new Player(threeButNotNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 문자를");
    }

    @ParameterizedTest
    @ValueSource(strings = {"11 3 7", "-1 0 2", "1 2 34"})
    void 범위에서_벗어난_경우_예외_발생(String threeButNotNumberInput) {
        Assertions.assertThatThrownBy(() -> player = new Player(threeButNotNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3개의 수로");
    }

    @ParameterizedTest
    @ValueSource(strings = {"588", "111", "112"})
    void 중복된_숫자_예외_발생(String duplicatedNumberInput) {
        Assertions.assertThatThrownBy(() -> player = new Player(duplicatedNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된");
    }

    @Test
    void 입력된_숫자_TripleBalls_변환_확인() {
        Player player = new Player("123");
        TripleBalls playerTripleBalls = player.getPlayerTripleBalls();

        Assertions.assertThat(playerTripleBalls.getTripleBalls()).containsExactly(new Ball(1, 1),
                new Ball(2, 2), new Ball(3, 3));
    }


}

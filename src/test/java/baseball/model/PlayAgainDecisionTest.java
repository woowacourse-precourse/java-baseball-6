package baseball.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayAgainDecisionTest {
    @ParameterizedTest(name = "[{index}] {0} 을 넣으면 정상 생성된다")
    @ValueSource(ints = {1, 2})
    void create(int element) {
        PlayAgainDecision playAgainDecision = PlayAgainDecision.of(element);
        assertThat(playAgainDecision).isNotNull();
    }

    @ParameterizedTest(name = "[{index}] {0} 을 넣으면 예외가 발생한다.")
    @ValueSource(ints = {-1, 0, 3, 5, 100})
    void validateInput_ex(int element) {
        assertThatThrownBy(() -> PlayAgainDecision.of(element))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class HintTest {

    @ParameterizedTest
    @CsvSource(value = {"1:0", "3:0"}, delimiter = ':')
    void 결과에_스트라이크만_존재하는지_판별(int strike, int ball) {
        Hint hint = new Hint(strike, ball);
        Assertions.assertThat(hint.isOnlyStrike()).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "0:3"}, delimiter = ':')
    void 결과에_볼만_존재하는지_판별(int strike, int ball) {
        Hint hint = new Hint(strike, ball);
        Assertions.assertThat(hint.isOnlyBall()).isTrue();
    }

    @Test
    void 결과가_낫싱인지_판별() {
        Hint hint = new Hint(0, 0);
        Assertions.assertThat(hint.isNothing()).isTrue();
    }

    @Test
    void 게임이_종료되었는지_판별() {
        Hint hint = new Hint(3, 0);
        Assertions.assertThat(hint.isGameFinish()).isTrue();
    }
}

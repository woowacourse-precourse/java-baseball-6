package baseball.domain;

import static baseball.domain.GameRestartStatus.END;
import static baseball.domain.GameRestartStatus.RESTART;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class GameRestartStatusTest {

    @ParameterizedTest
    @CsvSource(value = {"1,RESTART", "2,END"})
    void from은_재시도를_위한_숫자에_맞는_재시도_상태를_응답한다(int gameRestartNumber, GameRestartStatus expectedGameRestartStatus) {
        GameRestartStatus actualGameRestartStatus = GameRestartStatus.from(gameRestartNumber);

        assertThat(actualGameRestartStatus).isEqualTo(expectedGameRestartStatus);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    void from은_재시도를_위한_숫자가_아닌_경우에는_예외를_응답한다(int gameRestartNumber) {
        assertThatThrownBy(() -> GameRestartStatus.from(gameRestartNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isRestart_메서드는_재시도_상태인지_확인한다() {
        assertThat(RESTART.isRestart()).isTrue();
    }

    @Test
    void isRestart_메서드는_재시도_상태가_아니면_false를_응답한다() {
        assertThat(END.isRestart()).isFalse();
    }

}

package baseball.model;

import static baseball.model.GameRestartOption.END;
import static baseball.model.GameRestartOption.RESTART;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class GameRestartOptionTest {

    @ParameterizedTest
    @CsvSource(value = {"1,RESTART", "2,END"})
    void 재시도를_위한_숫자가_맞는지_검증한다(int gameRestartNumber, GameRestartOption expectedGameRestartOption) {
        GameRestartOption actualGameRestartOption = GameRestartOption.from(gameRestartNumber);

        assertThat(actualGameRestartOption).isEqualTo(expectedGameRestartOption);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    void 재시도를_위한_숫자가_아닌_경우에는_예외가_발생한다(int gameRestartNumber) {
        assertThatThrownBy(() -> GameRestartOption.from(gameRestartNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시도를_의미하는_값은_재시도를_원하는_상태이다() {
        assertThat(RESTART.isRestart()).isTrue();
    }

    @Test
    void 종료상태를_의미하는_값은_재시도를_원하는_상태가_아니다() {
        assertThat(END.isRestart()).isFalse();
    }

}
